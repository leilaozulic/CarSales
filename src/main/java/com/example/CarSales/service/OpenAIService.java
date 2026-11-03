package com.example.CarSales.service;

import com.example.CarSales.DTOs.CarAnalysisResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openai.client.OpenAIClient;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseInputImage;
import com.openai.models.responses.ResponseInputItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenAIService {

    private final OpenAIClient openAIClient; //connection between CarSales and OpenAI's API
    private final ObjectMapper objectMapper; //converts JSON to JavaObject

    public OpenAIService(
            OpenAIClient openAIClient,
            ObjectMapper objectMapper
    ) {
        this.openAIClient = openAIClient;
        this.objectMapper = objectMapper;
    }

    public CarAnalysisResult analyseCarPhoto(
            List<String> imageUrls,
            String description
    ) {
        if (imageUrls == null || imageUrls.isEmpty()) {
            throw new IllegalArgumentException(
                    "At least one photo is required." //TODO add msg
            );
        }

        //This here is a nested class
        ResponseInputItem.Message.Builder messageBuilder =  //A message input to the model with a role indicating instruction for OpenAI (prompt builder)
                ResponseInputItem.Message.builder()
                        .role(ResponseInputItem.Message.Role.USER) //TODO add msg
                        .addInputTextContent("""           
                                Analyse these photos of the same car
                                for a vehicle marketplace.
                                
                                Return ONLY a valid JSON object with these
                                exact fields:
                                {
                                  "make": string or null,
                                  "model": string or null,
                                  "year": integer or null,
                                  "bodyType": string or null,
                                  "exteriorColor": string or null,
                                  "fuelType": string or null,
                                  "transmission": string or null,
                                  "engineSize": string or null,
                                  "enginePowerHp": integer or null,
                                  "notes": string or null
                                }
                                
                                Rules:
                                - Identify the make and model only when
                                  reasonably identifiable.
                                - Give an approximate year only when
                                  supported by visible evidence.
                                - Describe the visible exterior colour.
                                - Do not guess mileage, VIN, engine size,
                                  horsepower, fuel type, transmission or trim.
                                - Leave uncertain values as JSON null.
                                - Do not invent specifications from appearance.
                                - Use notes to explain relevant uncertainty.
                                - Do not include Markdown or code fences.
                                - Return no text outside the JSON object.
                                """);

        if (description != null && !description.isBlank()) { //check if the description is null, if it is add it to the AI's prompt
            messageBuilder.addInputTextContent(
                    "Additional information supplied by the user: "
                            + description
                            + ". Treat this as a clue, not as verified fact."
            );
        }

        for (String imageUrl : imageUrls) {
            if (imageUrl == null || imageUrl.isBlank()) {
                continue;
            }

            ResponseInputImage image = ResponseInputImage.builder() //OpenAI's class for image supply
                    .imageUrl(imageUrl)
                    .detail(ResponseInputImage.Detail.HIGH)
                    .build();

            messageBuilder.addContent(image);
        }

        ResponseInputItem.Message message = messageBuilder.build(); // build the full message

        ResponseCreateParams params = ResponseCreateParams.builder() //the parameters needed to create a response from an OpenAI model
                .model("gpt-4.1-mini")
                .inputOfResponse( //sets the list as the input for the request
                        List.of(ResponseInputItem.ofMessage(message)) //ResponseInputItem.ofMessage(message) -> converting the message to ResponseInputItem
                        //List.of -> we can send multiple messages to AI, we are sending one message (list of one)
                )
                .build();

        Response response = openAIClient.responses().create(params); //sends the request and stores the response

        String json = response //extracting information from the response
                .output()
                .stream()  //building data processing pipeline
                .flatMap(item -> item.message().stream())
                .flatMap(outputMessage -> outputMessage.content().stream())
                .flatMap(content -> content.outputText().stream())
                .map(outputText -> outputText.text())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "The AI returned no analysis."
                ));

        try {
            return objectMapper.readValue(
                    json,
                    CarAnalysisResult.class
            );
        } catch (JsonProcessingException exception) {
            throw new IllegalStateException(
                    "The AI returned an invalid vehicle analysis response.",
                    exception
            );
        }
    }
}

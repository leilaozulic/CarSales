-- Rename the existing foreign key columns.
ALTER TABLE car
    RENAME COLUMN model_id_id TO model_id;

ALTER TABLE car
    RENAME COLUMN color_id_id TO color_id;

-- Change VIN to text.
ALTER TABLE car
    ALTER COLUMN vin TYPE VARCHAR(17)
        USING vin::text;

-- Add non-unique indexes for model and color.
CREATE INDEX idx_car_model_id
    ON car (model_id);

CREATE INDEX idx_car_color_id
    ON car (color_id);

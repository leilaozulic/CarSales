CREATE TABLE email_verification_token
(
    token      VARCHAR(64) PRIMARY KEY,
    user_id    INTEGER   NOT NULL UNIQUE,
    expires_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_email_verification_token_user
        FOREIGN KEY (user_id)
            REFERENCES application_user (id)
            ON DELETE CASCADE
);

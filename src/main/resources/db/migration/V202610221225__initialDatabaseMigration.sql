CREATE SEQUENCE IF NOT EXISTS application_user_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS badge_definition_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS car_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS color_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS conversation_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS image_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS listing_analytics_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS listing_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS location_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS make_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS message_attachment_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS message_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS model_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS notification_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS rating_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS report_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS user_badge_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE application_user
(
    id                INTEGER NOT NULL,
    username          VARCHAR(255),
    email             VARCHAR(255),
    password_hash     VARCHAR(255),
    first_name        VARCHAR(255),
    last_name         VARCHAR(255),
    phone_number      VARCHAR(255),
    profile_image_url VARCHAR(255),
    status            SMALLINT,
    is_verified       BOOLEAN,
    is_dealer         BOOLEAN,
    created_at        TIMESTAMP WITHOUT TIME ZONE,
    updated_at        TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_application_user PRIMARY KEY (id)
);

CREATE TABLE badge_definition
(
    id          INTEGER NOT NULL,
    type        VARCHAR(255),
    level       INTEGER,
    title       VARCHAR(255),
    description VARCHAR(255),
    icon_url    VARCHAR(255),
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_badgedefinition PRIMARY KEY (id)
);

CREATE TABLE car
(
    id                          INTEGER NOT NULL,
    model_id_id                 INTEGER,
    color_id_id                 INTEGER,
    year                        INTEGER,
    mileage                     INTEGER,
    fuel_type                   VARCHAR(255),
    transmission                VARCHAR(255),
    drive_type                  VARCHAR(255),
    body_type                   VARCHAR(255),
    engine_power_hp             INTEGER,
    engine_size                 VARCHAR(255),
    seat_material               VARCHAR(255),
    seat_adjustment             VARCHAR(255),
    headlight_type              VARCHAR(255),
    climate_control_type        VARCHAR(255),
    parking_assistance_level    VARCHAR(255),
    vin                         BIGINT,
    has_navigation              BOOLEAN,
    has_bluetooth               BOOLEAN,
    has_apple_carplay           BOOLEAN,
    has_android_auto            BOOLEAN,
    has_cruise_control          BOOLEAN,
    has_adaptive_cruise_control BOOLEAN,
    has_lane_assist             BOOLEAN,
    has_blind_spot_monitor      BOOLEAN,
    has_heated_seats            BOOLEAN,
    has_ventilated_seats        BOOLEAN,
    has_sunroof                 BOOLEAN,
    has_panorama_roof           BOOLEAN,
    has_keyless_entry           BOOLEAN,
    has_push_start              BOOLEAN,
    has_alloy_wheels            BOOLEAN,
    has_abs                     BOOLEAN,
    has_esp                     BOOLEAN,
    description                 VARCHAR(255),
    created_at                  TIMESTAMP WITHOUT TIME ZONE,
    updated_at                  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_car PRIMARY KEY (id)
);

CREATE TABLE color
(
    id   INTEGER NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_color PRIMARY KEY (id)
);

CREATE TABLE conversation
(
    id            INTEGER NOT NULL,
    listing_id_id INTEGER,
    buyer_id_id   INTEGER,
    seller_id_id  INTEGER,
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_conversation PRIMARY KEY (id)
);

CREATE TABLE image
(
    id            INTEGER NOT NULL,
    listing_id_id INTEGER,
    url           VARCHAR(255),
    order_index   INTEGER,
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_image PRIMARY KEY (id)
);

CREATE TABLE listing
(
    id             INTEGER NOT NULL,
    car_id_id      INTEGER,
    seller_id_id   INTEGER,
    location_id_id INTEGER,
    title          VARCHAR(255),
    description    VARCHAR(255),
    current_price  DECIMAL,
    last_price     DECIMAL,
    is_active      BOOLEAN,
    created_at     TIMESTAMP WITHOUT TIME ZONE,
    updated_at     TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_listing PRIMARY KEY (id)
);

CREATE TABLE listing_analytics
(
    id            INTEGER NOT NULL,
    listing_id_id INTEGER,
    view_count    INTEGER,
    save_count    INTEGER,
    updated_at    TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_listinganalytics PRIMARY KEY (id)
);

CREATE TABLE listing_application_users
(
    application_users_id INTEGER NOT NULL,
    favorite_listings_id INTEGER NOT NULL
);

CREATE TABLE location
(
    id        INTEGER NOT NULL,
    country   VARCHAR(255),
    city      VARCHAR(255),
    latitude  DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    CONSTRAINT pk_location PRIMARY KEY (id)
);

CREATE TABLE make
(
    id   INTEGER NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_make PRIMARY KEY (id)
);

CREATE TABLE message
(
    id                 INTEGER NOT NULL,
    conversation_id_id INTEGER,
    message_by         VARCHAR(255),
    content            VARCHAR(255),
    delivered_at       TIMESTAMP WITHOUT TIME ZONE,
    seen_at            TIMESTAMP WITHOUT TIME ZONE,
    created_at         TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_message PRIMARY KEY (id)
);

CREATE TABLE message_attachment
(
    id            INTEGER NOT NULL,
    message_id_id INTEGER,
    file_url      VARCHAR(255),
    file_type     VARCHAR(255),
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_messageattachment PRIMARY KEY (id)
);

CREATE TABLE model
(
    id         INTEGER NOT NULL,
    make_id_id INTEGER,
    name       VARCHAR(255),
    CONSTRAINT pk_model PRIMARY KEY (id)
);

CREATE TABLE notification
(
    id             INTEGER NOT NULL,
    user_id_id     INTEGER,
    type           VARCHAR(255),
    reference_id   INTEGER,
    reference_type VARCHAR(255),
    is_read        BOOLEAN,
    created_at     TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_notification PRIMARY KEY (id)
);

CREATE TABLE rating
(
    id                  INTEGER NOT NULL,
    rater_id_id         INTEGER,
    rated_user_id_id    INTEGER,
    score               INTEGER,
    comment             VARCHAR(255),
    verification_status VARCHAR(255),
    verification_reason VARCHAR(255),
    created_at          TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_rating PRIMARY KEY (id)
);

CREATE TABLE report
(
    id            INTEGER NOT NULL,
    user_id_id    INTEGER,
    listing_id_id INTEGER,
    reason        VARCHAR(255),
    description   VARCHAR(255),
    status        VARCHAR(255),
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_report PRIMARY KEY (id)
);

CREATE TABLE user_badge
(
    id                  INTEGER NOT NULL,
    user_id_id          INTEGER,
    badge_definition_id INTEGER,
    earned_at           TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_userbadge PRIMARY KEY (id)
);

CREATE UNIQUE INDEX idx_4e69555ed4000171717ac7748 ON car (vin);

CREATE UNIQUE INDEX idx_5dda7c4a851b9d51b1d788679 ON application_user (username);

CREATE UNIQUE INDEX idx_e2740a38df7c2d077a49fb5e3 ON application_user (email);

ALTER TABLE car
    ADD CONSTRAINT FK_CAR_ON_COLOR_ID FOREIGN KEY (color_id_id) REFERENCES color (id);

ALTER TABLE car
    ADD CONSTRAINT FK_CAR_ON_MODEL_ID FOREIGN KEY (model_id_id) REFERENCES model (id);

ALTER TABLE conversation
    ADD CONSTRAINT FK_CONVERSATION_ON_BUYER_ID FOREIGN KEY (buyer_id_id) REFERENCES application_user (id);

ALTER TABLE conversation
    ADD CONSTRAINT FK_CONVERSATION_ON_LISTING_ID FOREIGN KEY (listing_id_id) REFERENCES listing (id);

ALTER TABLE conversation
    ADD CONSTRAINT FK_CONVERSATION_ON_SELLER_ID FOREIGN KEY (seller_id_id) REFERENCES application_user (id);

ALTER TABLE image
    ADD CONSTRAINT FK_IMAGE_ON_LISTING_ID FOREIGN KEY (listing_id_id) REFERENCES listing (id);

ALTER TABLE listing_analytics
    ADD CONSTRAINT FK_LISTINGANALYTICS_ON_LISTING_ID FOREIGN KEY (listing_id_id) REFERENCES listing (id);

ALTER TABLE listing
    ADD CONSTRAINT FK_LISTING_ON_CAR_ID FOREIGN KEY (car_id_id) REFERENCES car (id);

ALTER TABLE listing
    ADD CONSTRAINT FK_LISTING_ON_LOCATION_ID FOREIGN KEY (location_id_id) REFERENCES location (id);

ALTER TABLE listing
    ADD CONSTRAINT FK_LISTING_ON_SELLER_ID FOREIGN KEY (seller_id_id) REFERENCES application_user (id);

ALTER TABLE message_attachment
    ADD CONSTRAINT FK_MESSAGEATTACHMENT_ON_MESSAGE_ID FOREIGN KEY (message_id_id) REFERENCES message (id);

ALTER TABLE message
    ADD CONSTRAINT FK_MESSAGE_ON_CONVERSATION_ID FOREIGN KEY (conversation_id_id) REFERENCES conversation (id);

ALTER TABLE model
    ADD CONSTRAINT FK_MODEL_ON_MAKE_ID FOREIGN KEY (make_id_id) REFERENCES make (id);

ALTER TABLE notification
    ADD CONSTRAINT FK_NOTIFICATION_ON_USER_ID FOREIGN KEY (user_id_id) REFERENCES application_user (id);

ALTER TABLE rating
    ADD CONSTRAINT FK_RATING_ON_RATED_USER_ID FOREIGN KEY (rated_user_id_id) REFERENCES application_user (id);

ALTER TABLE rating
    ADD CONSTRAINT FK_RATING_ON_RATER_ID FOREIGN KEY (rater_id_id) REFERENCES application_user (id);

ALTER TABLE report
    ADD CONSTRAINT FK_REPORT_ON_LISTING_ID FOREIGN KEY (listing_id_id) REFERENCES listing (id);

ALTER TABLE report
    ADD CONSTRAINT FK_REPORT_ON_USER_ID FOREIGN KEY (user_id_id) REFERENCES application_user (id);

ALTER TABLE user_badge
    ADD CONSTRAINT FK_USERBADGE_ON_USER_ID FOREIGN KEY (user_id_id) REFERENCES application_user (id);

ALTER TABLE listing_application_users
    ADD CONSTRAINT fk_lisappuse_on_listing FOREIGN KEY (favorite_listings_id) REFERENCES listing (id);

ALTER TABLE listing_application_users
    ADD CONSTRAINT fk_lisappuse_on_user FOREIGN KEY (application_users_id) REFERENCES application_user (id);
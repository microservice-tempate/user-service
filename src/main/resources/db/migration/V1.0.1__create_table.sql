CREATE TABLE user
(
    id       BINARY(16)   NOT NULL,
    username VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE user
    ADD CONSTRAINT uc_user_email UNIQUE (email);

ALTER TABLE user
    ADD CONSTRAINT uc_user_username UNIQUE (username);
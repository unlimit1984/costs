CREATE TABLE purchase (
  id           INT              NOT NULL GENERATED ALWAYS AS IDENTITY ( START WITH 0, INCREMENT BY 1),
  money        DOUBLE PRECISION NOT NULL,
  created_date TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  catetory     VARCHAR(50)      NOT NULL,
  comment      VARCHAR(50),
  CONSTRAINT primary_key_purchase PRIMARY KEY (id)
);
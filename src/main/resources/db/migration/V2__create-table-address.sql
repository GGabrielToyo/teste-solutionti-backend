CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE tb_solti_address (
    solti_address_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    solti_address_zip_code VARCHAR(20) NOT NULL,
    solti_address_street VARCHAR(255),
    solti_address_complement VARCHAR(255),
    solti_address_unit VARCHAR(50),
    solti_address_district VARCHAR(100),
    solti_address_city VARCHAR(100),
    solti_address_state_abbr VARCHAR(5),
    solti_address_state VARCHAR(100),
    solti_address_region VARCHAR(50),
    solti_address_ibge_code VARCHAR(10),
    solti_address_gia_code VARCHAR(10),
    solti_address_area_code VARCHAR(3),
    solti_address_siafi_code VARCHAR(10),
    solti_address_created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    solti_address_user_id UUID NOT NULL,

    CONSTRAINT fk_solti_address_user FOREIGN KEY (solti_address_user_id)
    REFERENCES tb_solti_user(solti_user_id)
);


CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE tb_solti_user (
    solti_user_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    solti_user_name VARCHAR(100) NOT NULL,
    solti_user_cpf VARCHAR(20) NOT NULL UNIQUE,
    solti_user_created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
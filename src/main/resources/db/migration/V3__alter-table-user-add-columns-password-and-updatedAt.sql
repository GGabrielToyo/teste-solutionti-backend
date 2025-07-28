ALTER TABLE "tb_solti_user"
    ADD COLUMN solti_user_password VARCHAR(255) NOT NULL,
    ADD COLUMN solti_user_updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
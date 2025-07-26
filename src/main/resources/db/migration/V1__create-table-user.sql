CREATE TABLE tb_solti_user (
    solti_user_id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
    solti_user_name VARCHAR(100) NOT NULL,
    solti_user_cpf VARCHAR(20) NOT NULL UNIQUE,
    solti_user_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
);

CREATE TABLE consertos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_entrada VARCHAR(255) NOT NULL,
    data_saida VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    anos_experiencia INT NOT NULL,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    ano INT NOT NULL CHECK (ano > 0)
);
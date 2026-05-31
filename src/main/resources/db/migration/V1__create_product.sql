CREATE TABLE TB_PRODUCT (
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    ean VARCHAR(13),
    nome_produto VARCHAR(255),
    descricao_produto VARCHAR(255),
    preco_produto DECIMAL(10,2)
);
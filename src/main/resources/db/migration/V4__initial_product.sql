-- Atualizar Notebook Dell
UPDATE TB_PRODUCT
SET nome_produto = 'Notebook Dell Inspiron 15',
    categoria_produto = 'Notebook',
    descricao_produto = 'Notebook Dell Inspiron 15 com 16GB RAM',
    preco_produto = 4500.00,
    preco_custo = 3500.00
WHERE ean = '7891234567890';

-- Atualizar Monitor LG
UPDATE TB_PRODUCT
SET nome_produto = 'Monitor LG 27 UHD',
    categoria_produto = 'Monitor',
    descricao_produto = 'Monitor LG 27 polegadas 4K UHD',
    preco_produto = 1899.90,
    preco_custo = 1200.00
WHERE ean = '7891112223334';

-- Atualizar Smartphone Samsung
UPDATE TB_PRODUCT
SET nome_produto = 'Galaxy S23 Ultra',
    categoria_produto = 'Smartphone',
    descricao_produto = 'Galaxy S23 Ultra 256GB',
    preco_produto = 5999.99,
    preco_custo = 4500.00
WHERE ean = '7899876543210';

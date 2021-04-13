INSERT INTO tb_categoria(id, nome)
VALUES (1, 'RPG'),
       (2, 'Informática'),
       (3, 'Direito'),
       (4, 'Gastronomia');

INSERT INTO tb_livro(id, nome, preco, paginas, codigo, categoria_id)
VALUES (1, 'Magic The Gathering Theros Beyond Death Bundle', 189.89, 0, 1, 1),
       (2, 'Pokemon Espada E Escudo 1 Blister Triplo', 21.90, 0, 2, 1),
       (3, 'Use A Cabeca Desenvolvendo Para Android', 199.99, 928, 3, 2),
       (4, 'Introducao A Programacao Com Python', 73.00, 328, 4, 2),
       (5, 'Flutter Na Pratica', 115.00, 368, 5, 2),
       (6, 'Vade Mecum 2020 - Saraiva', 207.00, 2568, 6, 3),
       (7, 'Pacote Anticrime Comentado - Nucci', 78.00, 150, 7, 3),
       (8, 'Hamburgueres - 50 Das Melhores Receitas', 24.90, 128, 8, 4),
       (9, 'Culinaria Vegana Para Atletas', 65.00, 228, 9, 4);
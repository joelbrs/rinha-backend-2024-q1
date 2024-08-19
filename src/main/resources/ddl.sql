SET
    TIMEZONE = 'America/Fortaleza';

CREATE TABLE tb_client (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    limite INTEGER NOT NULL
);

CREATE TABLE tb_transacao (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(1) NOT NULL CHECK (tipo IN ('c', 'd')),
    descricao VARCHAR(10) NOT NULL,
    realizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id INTEGER NOT NULL,
    valor INTEGER NOT NULL,
    FOREIGN KEY (client_id) REFERENCES tb_client(id)
);

CREATE TABLE tb_saldo (
    id SERIAL PRIMARY KEY,
    valor INTEGER NOT NULL DEFAULT(0),
    client_id INTEGER NOT NULL,
    FOREIGN KEY (client_id) REFERENCES tb_client(id)
);

INSERT INTO
    tb_client (nome, limite)
VALUES
    ('o barato sai caro', 1000 * 100),
    ('zan corp ltda', 800 * 100),
    ('les cruders', 10000 * 100),
    ('padaria joia de cocaia', 100000 * 100),
    ('kid mais', 5000 * 100);
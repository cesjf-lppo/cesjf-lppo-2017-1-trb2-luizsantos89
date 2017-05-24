CREATE TABLE Coleta(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    descricao VARCHAR(1000) NOT NULL,
    data TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Leitura(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    coleta INTEGER,
    local VARCHAR(100),
    leitura REAL,
    unidade VARCHAR(100),
    atualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_Coleta FOREIGN KEY (coleta) REFERENCES Coleta(id)
);

SELECT * FROM Coleta AS c INNER JOIN Leitura AS l ON c.ID = l.COLETA;

DELETE * FROM Coleta;
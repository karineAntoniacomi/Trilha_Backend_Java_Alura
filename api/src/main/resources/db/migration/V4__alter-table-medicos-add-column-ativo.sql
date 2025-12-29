ALTER TABLE medicos
ADD COLUMN ativo INT;

UPDATE medicos
SET ativo = 1;

ALTER TABLE medicos
ALTER COLUMN ativo SET NOT NULL;

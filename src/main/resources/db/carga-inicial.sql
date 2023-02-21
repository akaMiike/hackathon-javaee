INSERT INTO curso_rest.Usuario (id, name, login, email, password, birthDate, createdAt, updatedAt)
VALUES
       (1, 'Michael', 'mike123', 'mike@abc.com', TO_BASE64('Mike1234$'), '2001-08-21', now(), now()),
       (2, 'Nicholas', 'nike321', 'nike@bcd.com', TO_BASE64('Nike4321$'), '2000-09-11', now(),now()),
       (3, 'Soares', 'soaress', 'soares123@cde.com', TO_BASE64('$#Soares14'), '2000-05-01', now(),now()),
       (4, 'Silva', '__silva', 'silvaa@bcd.com', TO_BASE64('_Siilva00'), '1999-02-05', now(),now()),
       (5, 'Sousa', 'sousinha', 'sousa@abc.com', TO_BASE64('Sousaa11'), '2002-12-02', now(),now());
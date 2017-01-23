INSERT INTO subject  VALUES (1,'123','admin');
INSERT INTO grupo VALUES (1,'Grupo dos administradores do sistema','ADMINISTRADORES');
INSERT INTO grupo VALUES (2,'Grupo dos secretários dos cursos','SECRETARIOS');
INSERT INTO grupo VALUES (3,'Grupo dos coordenadores dos cursos','COORDENADORES');
INSERT INTO grupo VALUES (4,'Grupo dos usuários da direção','DIRECAO');
INSERT INTO grupo VALUES (5,'Grupo dos vigilantes','VIGILANTES');
INSERT INTO grupo VALUES (6,'Grupo dos terceirizados','TERCEIRIZADOS');
INSERT INTO grupo VALUES (7,'Grupo de usuários da biblioteca','BIBLIOTECA');
INSERT INTO subject_group VALUES (1,1)
select setval('seq_subject', 1);
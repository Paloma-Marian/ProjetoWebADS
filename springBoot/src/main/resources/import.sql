insert into tb_alunos(nome, cpf, email, status)values('paloma.marian','124.789.456-98','paloma.marian@gmail.com','ATIVO');
insert into tb_alunos(nome, cpf, email, status)values('joao.marian','657.789.333-08','joao.marian@gmail.com','ATIVO');
insert into tb_alunos(nome, cpf, email, status)values('pedro.marian','222.147.258-20','pedro.marian@gmail.com','DESATIVADO');

insert into tb_materias(aluno_id, nome, nota1, nota2, nota3, notafim, status)values(1,'Matemática','0.0','0.0','0.0','0.0','CURSANDO');
insert into tb_materias(aluno_id, nome, nota1, nota2, nota3, notafim, status)values(2,'Português','0.0','0.0','0.0','0.0','CURSANDO');
insert into tb_materias(aluno_id, nome, nota1, nota2, nota3, notafim, status)values(3,'Inglês','7.0','7.0','7.0','7.0','APROVADO');

insert into tb_turmas(aluno_id, nome, semestre, data, status)values(1,'ADS','1','2022-12-16','APROVADO');
insert into tb_turmas(aluno_id, nome, semestre, data, status)values(1,'ADS','2','2022-12-16','APROVADO');
insert into tb_turmas(aluno_id, nome, semestre, data, status)values(1,'ADS','3','2023-12-16','ANDAMENTO');
insert into tb_turmas(aluno_id, nome, semestre, data, status)values(1,'ADS','4','2022-12-16','APROVADO');
insert into tb_turmas(aluno_id, nome, semestre, data, status)values(2,'ADS','1','2023-12-16','ANDAMENTO');
insert into tb_turmas(aluno_id, nome, semestre, data, status)values(3,'ADS','1','2021-12-16','APROVADO');
insert into tb_turmas(aluno_id, nome, semestre, data, status)values(3,'ADS','2','2021-12-16','APROVADO');
insert into tb_turmas(aluno_id, nome, semestre, data, status)values(3,'ADS','3','2021-12-16','APROVADO');
insert into tb_turmas(aluno_id, nome, semestre, data, status)values(3,'ADS','4','2021-12-16','APROVADO');

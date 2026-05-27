create database script;

use script;

create table Cad_Cli (
id int not null,
nome varchar(100) not null,
sobrenome varchar(100) not null,
nomemae varchar(100) not null,
nomepai varchar(100),
cpf varchar(30) not null,
datanascimento date not null,
endereco varchar(200) not null,
cep varchar(20) not null
);


package model;

import java.time.LocalDate;

public class Cliente {

    private int id;
    private String nome;
    private String sobrenome;
    private String nomemae;
    private String nomepai;
    private String cpf;
    private LocalDate datanascimento;
    private String endereco;
    private String cep;

    public Cliente() {
     }

     public Cliente(int id, String nome, String sobrenome, String nomemae, String nomepai, String cpf, LocalDate datanascimento, String endereco, String cep) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nomemae = nomemae;
        this.nomepai = nomepai;
        this.cpf = cpf;
        this.datanascimento = datanascimento;
        this.endereco = endereco;
        this.cep = cep;
     }

       public Cliente( String nome, String sobrenome, String nomemae, String nomepai, String cpf, LocalDate datanascimento, String endereco, String cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nomemae = nomemae;
        this.nomepai = nomepai;
        this.cpf = cpf;
        this.datanascimento = datanascimento;
        this.endereco = endereco;
        this.cep = cep;
     }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getNomemae() {
        return nomemae;
    }
    public void setNomemae(String nomemae) {
        this.nomemae = nomemae;
    }
    public String getNomepai() {
        return nomepai;
    }
    public void setNomepai(String nomepai) {
        this.nomepai = nomepai;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDate getDatanascimento() {
        return datanascimento;
    }
    public void setDatanascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
}
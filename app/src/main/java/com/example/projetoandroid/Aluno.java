package com.example.projetoandroid;

public class Aluno {
    private String nome, email, telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String toString() {
        return "Aluno: {nome: " + nome + ", email: " + email + ", telefone: " + telefone + "}";
    }
}

package classes;

import java.io.Serializable;

public class Cliente implements Serializable{

    private int id, nuit, idade;
    private String nome, celular;
    private char sexo;
    private double saldo;


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente(int id, String nome, int idade, char sexo, String celular, int nuit, double saldo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.celular = celular;
        this.nuit = nuit;
        this.saldo = saldo;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getNuit() {
        return nuit;
    }

    public void setNuit(int nuit) {
        this.nuit = nuit;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", celular=" + celular
                + ", nuit=" + nuit + "]";
    }

}
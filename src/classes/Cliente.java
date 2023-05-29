package classes;

public class Cliente {

    private int idC;
    private String nome;
    private int idade;
    private char sexo;
    private String celular;
    private int nuit;

    public Cliente(int idC, String nome, int idade, char sexo, String celular, int nuit) {
        this.idC = idC;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.celular = celular;
        this.nuit = nuit;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
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
        return "Cliente [idC=" + idC + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", celular=" + celular
                + ", nuit=" + nuit + "]";
    }

}

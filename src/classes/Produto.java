package classes;
import java.util.Calendar;

public class Produto {
    private int idP;
    private String nome;
    private String categoria;
    private Calendar entStock;
    private int quantidade;
    private double preco;

    public Produto(int idP, String nome, String categoria, Calendar entStock, int quantidade, double preco) {
        this.idP = idP;
        this.nome = nome;
        this.categoria = categoria;
        this.entStock = entStock;
        this.quantidade = quantidade;
        this.preco = preco;
    }


    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Calendar getEntStock() {
        return entStock;
    }

    public void setEntStock(Calendar entStock) {
        this.entStock = entStock;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto [idP=" + idP + ", nome=" + nome + ", categoria=" + categoria + ", entStock=" + entStock
                + ", quantidade=" + quantidade + ", preco=" + preco + "]";
    }

}

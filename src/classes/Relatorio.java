package classes;

import java.io.Serializable;

public class Relatorio implements Serializable{
    private Produto prod;
    private Venda venda;
    private Cliente cliente;

    public Relatorio(Produto prod, Venda venda, Cliente cliente) {
        this.prod = prod;
        this.venda = venda;
        this.cliente = cliente;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}

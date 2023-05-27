package classes;
import java.util.Calendar;

public class Venda {
    private int id;
    private Calendar dataVenda;
    private int idCliente;
    private int idProduto;

    public Venda(int id, Calendar dataVenda, int idCliente, int idProduto) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Calendar dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return "Venda [id=" + id + ", dataVenda=" + dataVenda + ", idCliente=" + idCliente + ", idProduto=" + idProduto
                + "]";
    }

}

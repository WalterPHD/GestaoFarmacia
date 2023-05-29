package classes;
import java.util.Calendar;

public class Venda {
    private int idV;
    private Calendar dataVenda;
    private int idCliente;
    private int idProduto;
    private double total;
    private int quantidade;

    public Venda(int idV, Calendar dataVenda, int idCliente, int idProduto,double total,int quantidade) {
        this.idV = idV;
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.total=total;
        this.quantidade=quantidade;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
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
    

    public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Venda [idV=" + idV + ", dataVenda=" + dataVenda + ", idCliente=" + idCliente + ", idProduto=" + idProduto
				+ ", total=" + total + ", quantidade=" + quantidade + "]";
	}


}

package carrinho;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import cliente.Cliente;
import compras.Compras;
import produto.Produto;
import produto.Stock;

public class OperacoesCarrinho {
	Stock stock = new Stock();

	public Vector adicionarProduto(int id, Vector carrinho, Vector lista, int quantidade) {
		boolean stock = qntty(id, lista, quantidade);
		int indexExiste = verificaExistenciaCarinho(id, carrinho);

		if (stock) {
			Produto found = produtoStock(id,lista);
			if (indexExiste != -1) {
				Produto adicionar = new Produto(id, found.getNome(), quantidade, found.getPreco());
				found.setQtd(found.getQtd() - quantidade);
				((Carrinho) carrinho.get(indexExiste))
						.setQtd((((Carrinho) carrinho.get(indexExiste))).getQtd() + quantidade);
				(((Carrinho) carrinho.get(indexExiste)))
						.setTotal(found.getPreco() * (((Carrinho) carrinho.get(indexExiste))).getQtd());
			} else {
				found.setQtd(found.getQtd() - quantidade);
				Carrinho produto = new Carrinho(id, found.getNome(), quantidade, found.getPreco(),
						found.getPreco() * quantidade);
				carrinho.add(produto);
//				

			}
		}
		return carrinho;
	}

//Index do produto no stock
	public boolean qntty(int id, Vector lista, int quantidade) {
		int posicao = stock.procurarCodigo(lista, id);
		if (posicao != -1) {
			Produto encontrado = ((Produto) lista.get(posicao));

			if (quantidade > encontrado.getQtd()) {
				System.out.println("A quantidade pretendida de " + encontrado.getNome()+" nao esta disponivel, apenas tem "+encontrado.getQtd());
				return false;
			} else if (encontrado.getQtd() < 0) {
				System.out.println("O produto"+ encontrado.getNome() +" que esta a tentar vender não tem disponibilidade");
				return false;

			} else if (quantidade < 0) {
				System.out.println("Insira uma quantidade válida");
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
public Produto produtoStock(int id, Vector lista) {
	for (int i = 0; i < lista.size(); i++) {
		if (((Produto) lista.get(i)).getId() == id) {
			return (Produto) lista.get(i);
		}
	}
	return null;
}
	public int verificaExistenciaCarinho(int id, Vector carrinho) {
		for (int i = 0; i < carrinho.size(); i++) {
			if (((Carrinho) carrinho.get(i)).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	public Vector removerProduto(int id, Vector carrinho, Vector temporario) {
		int index = procuraProdutoCarrinho(id, carrinho);
		for (int i = 0; i < carrinho.size(); i++) {
			// && ((Produto)cart.getProdutos().get(i)).getQtd()
			if (((Produto) carrinho.get(i)).getId() == id) {

				carrinho.remove(i);
				System.out.println("ECONTRAMOS");
				return carrinho;
			}
		}
		System.out.println("NAO ECONTRAMOS");

		return carrinho;
	}

	public Vector removerProdutoQuantidade(int id, Vector carrinho, Vector temporario, int quantidade) {
		int index = procuraProdutoCarrinho(id, carrinho);

		Stock stock = new Stock();
		int indexStock = stock.procurarCodigo(temporario, id);
		if (index != -1) {
			if (((Produto) carrinho.get(index)).getId() == ((Produto) temporario.get(indexStock)).getId()) {// Se tem no
																											// carrinho,
				if(qntty(id,carrinho,quantidade)) {																							// tem no
				((Produto) temporario.get(indexStock))
						.setQtd(((Produto) temporario.get(indexStock)).getQtd() + quantidade);
				((Produto) carrinho.get(index)).setQtd(((Produto) carrinho.get(index)).getQtd() - quantidade);
				if (((Produto) carrinho.get(index)).getQtd() <= 0) {
					carrinho.remove(index);
				}
				}else{
					System.out.println("Quantidade de invalida!");
				}
			}
		} else {
			System.out.println("Produto nao esta no carrinho");
		}

		return carrinho;
	}

	public int procuraProdutoCarrinho(int id, Vector carrinho) {
		for (int i = 0; i < carrinho.size(); i++) {
			if (((Produto) carrinho.get(i)).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public void listarItensCarrinho(Vector carrinho) {
		for (int i = 0; i < carrinho.size(); i++) {
			System.out.println(((Carrinho) carrinho.get(i)).toCarrinho());
		}
	}

	public boolean estaVazio(Vector carrinho) {
		if (carrinho.size() == 0) {
			return false;
		}
		return true;
	}
public Vector actualizarVendas(Vector carrinho, Vector produtos) {
	for (int i = 0; i < carrinho.size(); i++) {
		for (int j = 0; j < produtos.size(); j++) {
			if(((Carrinho)carrinho.get(i)).getId()==((Produto)produtos.get(j)).getId()) {
				((Produto)produtos.get(j)).setVendas((((Produto) produtos.get(j)).getVendas() + 1) );
				
				return produtos;
			}
			
		}
	}
	return produtos;
}

	public boolean vendaDinheiro(int id,Vector carrinho, Cliente cl) {
		double total = 0;
		Vector compraCliente = cl.getCompras();
		for (int i = 0; i < carrinho.size(); i++) {
			total += ((Carrinho) carrinho.get(i)).getTotal();
		}
		
		
		if (estaVazio(carrinho)) {
			Calendar cal=Calendar.getInstance();
			Compras venda = new Compras(cal,id, cl.getId(), cl.getNome(), carrinho, (total+total*0.16));
			cl.getCompras().add(venda);
			System.out.println("\nSEM IVA: "+total+"\nACRÉSCIMO DE IVA: " + total*0.16+"\nTOTAL="+(total+total*0.16));
			
			System.out.println(((Compras)cl.getCompras().get(cl.getCompras().size()-1)).toString());
			System.out.println("Compra feita com sucesso\n");
			return true;
		}
		return false;
	}

}

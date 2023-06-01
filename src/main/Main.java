package main;

import produto.Produto;
import produto.Stock;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import carrinho.*;
import cliente.*;
import compras.Compras;

public class Main {
//ver situação de IDS
	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		OperacoesVitais opVitais = new OperacoesVitais();


		Vector clientes = new Vector();
		String caminhoClientes = "Cliente\\ClientesDB.txt";
		File fileClientes = new File(caminhoClientes);
		if (fileClientes.length() != 0) {
			clientes = (Vector) opVitais.recuperarObjecto(caminhoClientes);
		}
		Vector produtos = new Vector();
		String caminhoProduto = "Produtos\\ProdutosDB.txt";
		File fileProdutos = new File(caminhoProduto);
		if (fileProdutos.length() != 0) {
			produtos = (Vector) opVitais.recuperarObjecto(caminhoProduto);
		}

		Vector vendas = new Vector();
		String caminhoVendas = "Vendas\\VendasDB.txt";
		File fileVendas = new File(caminhoVendas);
		if (fileVendas.length() != 0) {
			vendas = (Vector) opVitais.recuperarObjecto(caminhoVendas);
		}
		OperecoesCliente opCliente = new OperecoesCliente();

		OperacoesCarrinho operacoesCart = new OperacoesCarrinho();

		Stock stock = new Stock();

		Scanner ler = new Scanner(System.in);

		Random aleatorio = new Random();

		int operacao;
		int id;
		do {
			System.out.println(
					"\t-----\tBEM-VINDO(A) A FARMACIA SALGADO\t-----\n SELECCIONE A SUA OPCAO\n1.Comprar\n2. Mais Opcoes(Cliente/Produto/Vendas)\n0. SAIR DO PROGRAMA\n>>> ");
			operacao = ler.nextInt();
			int procuraCodigo = -1;
			switch (operacao) {
			case 1:
				Vector carrinho = new Vector();
				System.out.print("\nIDENTIFIQUE-SE USANDO O NUMERO DO CLIENTE\n>>>");
				int codeCLiente = ler.nextInt();
				procuraCodigo = opCliente.procuraID(clientes, codeCLiente);
				if (procuraCodigo != -1) {
					int opcoesCarrinho;
					do {
						System.out.print("\n BEM-VINDO(A) (" + ((Cliente) clientes.get(procuraCodigo)).getId() + ") "
								+ ((Cliente) clientes.get(procuraCodigo)).getNome() + " "
								+ "\n-----\tESCOLHA A SUA OPERACAO DE CARRINHO\t------\n1. Adicionar produto no carrinho\n2. Remover Produto do carrinho\n3. Ver produtos no carrinho\n4. Ver produtos disponíveis\n5. Finalizar Compra\n0. CANCELAR\n>>> ");
						opcoesCarrinho = ler.nextInt();

						Vector stockTemporario = produtos;
						switch (opcoesCarrinho) {
						case 1:
							System.out.println("Qual é o código do produto que pretende adicionar no carrinho?");
							int codProd = ler.nextInt();
							int index = stock.procurarCodigo(produtos, codProd);
							if (index != -1) {

								System.out.println("E qual é a quantidade de " + ((Produto) produtos.get(index)).getNome()
										+ " que pretende adicionar ao carrinho?");
								int quantidade = ler.nextInt();
								operacoesCart.adicionarProduto(((Produto) produtos.get(index)).getId(), carrinho,
										stockTemporario, quantidade);
							} else {
								System.out.println("Produto não está em stock");
							}

							break;
						case 2:
							System.out.println("Qual é o código do produto que pretende remover no carrinho?");
							int code = ler.nextInt();
							operacoesCart.removerProdutoQuantidade(code, carrinho, stockTemporario, 2);
							break;
						case 3:
							System.out.println("\n--------------------\tITENS\t--------------------");
							operacoesCart.listarItensCarrinho(carrinho);
							break;
						case 4:
							stock.imprimirTodos(stockTemporario);
							break;
						case 5:
							int idCompra = vendas.size()+1;
							if (operacoesCart.vendaDinheiro(idCompra, carrinho,
									(Cliente) clientes.get(procuraCodigo))) {
								operacoesCart.actualizarVendas(carrinho, stockTemporario);
								boolean record = opVitais.gravarObjecto(stockTemporario, caminhoProduto);
								boolean gravou = opVitais.gravarObjecto(clientes, caminhoClientes);

								boolean registado = opVitais.gravarObjecto(vendas, caminhoVendas);

							} else {
								System.out.println("\nErro na compra, contacte o suporte ao cliente!\n\n");
							}
							opcoesCarrinho = 0;

							break;
						}
					} while (opcoesCarrinho != 0);
				} else {
					System.out.println("-----------------------------------\nCLIENTE COM CODIGO " + codeCLiente
							+ " NAO CADASTRADO! TENTE DE NOVO\n------------------------------------");
				}
				break;
			case 2:
				int opcoes;

				do {// OPERAÇÕES MAIS OPERAÇÕES
					System.out.println("-----\tOPCOES\t-----");
					System.out.print("\n1. Clientes\n2. Produtos\n3. Vendas\n0. Voltar\n>>> ");
					opcoes = ler.nextInt();
					switch (opcoes) {
					case 1:
						int opcaoCliente;
						do {// OPERAÇÕES DOS CLIENTES

							System.out.print(
									"\n\t-----OPERACOES CLIENTE-----\n1. Criar Cliente\n2. Actualizar Cliente\n3. Remover Cliente\n4. Pesquisar Cliente\n5. Ver todos os clientes\n6. Ver conta Correne do Cliente\n0. SAIR E SALVAR ALTERACOES\n>>> ");
							opcaoCliente = ler.nextInt();
							switch (opcaoCliente) {
							case 0:
								boolean gravou = opVitais.gravarObjecto(clientes, caminhoClientes);
								break;
							case 1:
								// 1-INSERIR CLIENTE
								Vector compras = new Vector();// Vector vazio com compras do Cliente novo
								// GERAÇÃO DE ID
								int codigo = clientes.size()+1	;
								System.out.println("BI DO CLIENTE:");
								String bi = ler.next().toUpperCase().replace(" ", "");
								// VERIFICAÇÃO DE BIS DUPLICADOS
								ler.nextLine();
								System.out.println("Nome do Cliente:");
								String nome = ler.nextLine().toUpperCase();
								// ler.nextLine();
								System.out.println("Número de telemovel Cliente");
								String numeroTel = "+" + ler.nextLine().replace(" ", "");
								;
								System.out.println("E-mail");
								String email = "+" + ler.next().replace(" ", "");
								;
								ler.nextLine();
								Cliente cl = new Cliente(cal, codigo, bi, nome, numeroTel, email, compras);
								opCliente.adicionarCliente(clientes, cl);
								break;
							case 2:
								// 2 - Actualizar dados do Cliente
								System.out.println("Por-favor insira o ID do cliente que pretende editar os dados");
								int identi = ler.nextInt();
								opCliente.editarDadoCliente(clientes, identi);
								break;
							case 3:
								// 3 - Remover Cliente
								System.out.println("Digite o ID do cliente que pretende apagar");
								int identificacao = ler.nextInt();
								opCliente.apagarCliente(clientes, identificacao);
								break;
							case 4:
								// Pesquisar Cliente específico
								System.out.println("Digite o ID do cliente que pretende ver");
								int iD = ler.nextInt();
								int index = opCliente.procuraID(clientes, iD);
								if (index != -1) {
									System.out.println(((Cliente) clientes.get(index)).toString());
								} else {
									System.out.println("Esse ID não existe");
								}
								break;
							case 5:
								// Ver todos os clientes
								opCliente.imprimirTodos(clientes);
								break;
							case 6:
								// Ver conta corrente do Cliente (Tudo que já comprou em valores)
								System.out.println("Insira o codigo de identificacao do cliente:");
								int codigoCl = ler.nextInt();
								//int getCode = opCliente.procuraID(clientes, codigoCl);

								opCliente.verContaCorrente(clientes, codigoCl);/// saiu

								break;
							default:
								break;
							}
						} while (opcaoCliente != 0);// FIM DAS OPERAÇÕES DO CLIENTE

						break;// BREAK PARA OPERAÇÕES DO CLIENTE

					case 2:// OPERAÇÕES PARA OS PRODUTOS
						int opcaoProduto;
						do {
							System.out.println(
									"\n\t-----OPERACOES PRODUTO-----\n1. Encomendar produto\n2. Actualizar Produto\n3. Remover Produto\n4. Pesquisar Produto\n5. Emitir Relatorios do Stock\n6. Ver todos os produtos\n0. SAIR E SALVAR ALTERACOES\n>>>");
							opcaoProduto = ler.nextInt();
							switch (opcaoProduto) {
							case 0:

								boolean gravou = opVitais.gravarObjecto(produtos, caminhoProduto);

								break;
							case 1:
								// Adicionar produtos no Stock
								// !AO ENCOMENDAR O PRODUTO PODE DEVE/PODE ESCOLHER A QUANTIDADE!
								int codigo = produtos.size()+1;
								System.out.println("Quantidade da encomenda: ");
								int qtd = ler.nextInt();
								ler.nextLine();

								System.out.println("Preço do produto: ");
								double preco = ler.nextDouble();
								ler.nextLine();

								System.out.println("Nome do produto que pretende encomendar: ");
								String nomeProduto = ler.nextLine().toUpperCase();

								Produto prod = new Produto(codigo, nomeProduto, qtd, preco);
								stock.adicionarNovoProduto(produtos, prod);
								break;
							case 2:

								System.out.println("ID do produto que pretende actualizar:");
								id = ler.nextInt();
								stock.editarDadoProduto(produtos, id);
								break;
							case 3:
								System.out.println("ID do produto que pretende remover:");
								id = ler.nextInt();
								stock.removerProduto(produtos, id);
								break;
							case 4:
								// Pesquisar Produto
								System.out.println("ID do produto que pretende pesquisar: ");
								id = ler.nextInt();
								int indice = stock.procurarCodigo(produtos, id);
								if (indice != -1) {
									System.out.println(((Produto) produtos.get(indice)).toString());
								} else {
									System.out.println("Produto inexistente");
								}

								break;
							case 5:
								System.out.println("OS PRODUTOS ABAIXO DE 5 UNIDADES SÃO:");
								stock.abaixoDe5(produtos);

								System.out
										.println("\nListagem de quantos produtos mais vendidos(EM ORDEM CRESCENTE): ");
								stock.maisVendidos(produtos);
								break;
							case 6:
								stock.imprimirTodos(produtos);
								break;
							default:
								System.out.println("OPCAO INVALIDA! TENTE DE NOVO");
								break;
							}
						} while (opcaoProduto != 0);// FIM DA OPERAÇÕES DE PRODUTOS

						break;
					case 3:
						for (int i = 0; i < clientes.size(); i++) {
							for (int j = 0; j < ((Cliente) clientes.get(i)).getCompras().size(); j++) {
//								
							}

						}

						break;
					}
				} while (opcoes != 0);
				break;
			case 0:

				System.out.println("VOLTE SEMPRE");
				break;
			}

		} while (operacao != 0);// FIM DA TELA PRINCIPAL

	}

}

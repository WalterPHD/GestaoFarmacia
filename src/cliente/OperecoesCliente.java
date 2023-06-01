package cliente;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import carrinho.Carrinho;
import produto.Produto;
import compras.Compras;

public class OperecoesCliente {

	public Vector adicionarCliente(Vector lista, Cliente cl) {
		int index = procuraBI(lista, cl.getBi());
		if (index == -1 || lista.size() == 0) {
			lista.add(cl);
			return lista;
		} else {
			System.out.println("Cliente com este BI ja existe");
			return lista;
		}
	}
	public int procuraBI(Vector lista, String bi) {
		for (int i = 0; i < lista.size(); i++) {
			if ((((Cliente) lista.get(i)).getBi()).equalsIgnoreCase(bi)) {
				return i;
			}
		}
		return -1;
	}
	public int procuraEmail(Vector lista, String email) {
		for (int i = 0; i < lista.size(); i++) {
			if ((((Cliente) lista.get(i)).getEmail()).equalsIgnoreCase(email)) {
				return i;
			}
		}
		return -1;
	}

	public int procuraID(Vector lista, int id) {
		for (int i = 0; i < lista.size(); i++) {
			if ((((Cliente) lista.get(i)).getId()) == id) {
				return i;
			}
		}
		return -1;
	}

	public void apagarCliente(Vector lista, int id) {
		int index = procuraID(lista, id);
		if (index != -1) {
			lista.remove(index);
			System.out.println("Removido com sucesso");
		} else {
			System.out.println("ID NAO EXISTE");
		}
	}
	public void editarDadoCliente(Vector clientes, int id) {
		int index = procuraID(clientes, id);

		if (index != -1) {
			for (int i = 0; i < clientes.size(); i++) {
				Scanner input = new Scanner(System.in);
				int escolha;
				do {
					System.out.println("***Menu de Edição de Dados do Cliente***");
					System.out.println("\nModifique dados do Cliente" + ((Cliente) clientes.get(index)).toString()
							+ "\n1-Nome do Cliente \n2-E-mail \n3-Numero de telefone \n0 - Sair");
					escolha = input.nextInt();
					switch (escolha) {
					case 1:
						System.out.println("Insira o nome do cliente:");
						String nome = input.nextLine();
						((Cliente) clientes.get(index)).setNome(nome);
						System.out.println("Nome atualizado para: " + ((Cliente) clientes.get(index)).getNome());
						break;
					case 2:
						System.out.println("Insira o novo E-mail para o cliente:");
						String email =input.nextLine();
						int indice = procuraEmail(clientes, email);
						if(indice!=-1) {
							((Cliente) clientes.get(index)).setEmail(email);
							System.out.println("O E-mail foi actualizado atualizado para: " + ((Cliente) clientes.get(index)).getEmail());
								break;
						}else {
							System.out.println("O E-mail nao existe");
						}
						break;
					case 3:
						System.out.println("Insira o novo número de telefone do cliente:");
						String telefone =input.nextLine();
						((Cliente) clientes.get(index)).setNumeroTel(telefone);
						System.out
								.println("Telefone atualizado para: " + ((Cliente) clientes.get(index)).getNumeroTel());
						break;
					default:
						System.out.println("Opção Invalida!\nInsira novamente:");

						break;
					}
				} while (escolha != 0);

			}
		} else {
			System.out.println("Cliente nao encontrado!");
		}
	}

	public void imprimirTodos(Vector lista) {
		if (lista.size() > 0) {
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(((Cliente) lista.get(i)).toString());
			}

		} else {
			System.out.println("SEM CLIENTES!");
		}
	}
	public void verContaCorrente(Vector clientes, int id) {
		Scanner input = new Scanner(System.in);
		double valorTotal = 0;

		int index = procuraID(clientes, id);

		if (index != -1) {
			Vector compras = ((Cliente) clientes.get(index)).getCompras();
			for (int j = 0; j < compras.size(); j++) {
				System.out.println(((Compras) compras.get(j)).toString());
				valorTotal += ((Compras) compras.get(j)).getTotal();
			}
			System.out.println(((Cliente) clientes.get(index)).curtoString()+" ja gastou "+valorTotal+" MT");
		} else {
			System.out.println("Este Cliente nao existe");
		}

	}
}

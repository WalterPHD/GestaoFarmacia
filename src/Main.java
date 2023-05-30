import java.io.File;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Vector;

import classes.Cliente;
import classes.Operacoes;
import classes.Produto;

public class Main {
    public static void main(String[] args) {
        Operacoes operacoes = new Operacoes();
        String path = "src/data/Data.txt";
        String client = "src/data/Client.txt";
        String product = "src/data/Product.txt";
        Calendar data = Calendar.getInstance();
        // SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy");
        // sdf.format(data.getTime());
        // data = sdf.format(data.getTime());
        data.set(2023, 2, 26);
        // data.set(2023, 2, 26);

        Vector recuperarProdutos = new Vector();
        Vector recuperarClientes = new Vector();

        File fCliente = new File(client);
        if (fCliente.length() != 0) {
            recuperarClientes = (Vector) operacoes.recuperarObj(client);
        }

        File fProduto = new File(product);
        if (fProduto.length() != 0) {
            recuperarProdutos = (Vector) operacoes.recuperarObj(product);
        }

        Vector v = new Vector();
        Scanner input = new Scanner(System.in);
        int op, oc, p, n;
        System.out.println("===============Seja bem vindo a Farmacia 5===============");
        do {
            System.out.println("Onde deseja aceder?");
            System.out.print(
                    "1 - Area de clientes\n2 - Area de produtos\n3 - Efectuar venda\n4 - Emitir relatorio!\n5 - Sair\nInsira a sua opcao: ");
            op = input.nextInt();

            switch (op) {

                case 1:
                    System.out.println("Area do cliente!");
                    System.out.println(
                            "Qual operacao deseja fazer?\n1 - Registrar Cliente\n2 - Listar todos os clientes\n3 - Atualizar um cliente\n4 - Remover um cliente");
                    oc = input.nextInt();
                    switch (oc) {
                        case 1:
                            System.out.println("Insira o...:");
                            System.out.println("Codigo do cliente");
                            int cod = input.nextInt();
                            input.nextLine();
                            System.out.println("Nome completo do cliente");
                            String nome = input.nextLine();

                            System.out.println("Idade");
                            int idade = input.nextInt();

                            System.out.println("Sexo");
                            char s = input.next().charAt(0);
                            input.nextLine();

                            System.out.println("Numero de celular");
                            String cell = input.nextLine();

                            System.out.println("Nuit");
                            int nuit = input.nextInt();

                            Cliente c = new Cliente(cod, nome, idade, s, cell, nuit);

                            operacoes.adicionarCliente(v, c);
                            boolean ficheiro = operacoes.gravarObj(v, client);

                            break;

                        case 2:
                            operacoes.listarCliente(recuperarClientes);
                            break;

                        case 3:
                            operacoes.listarCliente(recuperarClientes);
                            System.out.println("Insira o ID do cliente que deseja atualizar:");
                            n = input.nextInt();
                            operacoes.atualizarCliente(recuperarClientes, n);
                            operacoes.listarCliente(recuperarClientes);
                            break;

                        case 4:
                            operacoes.listarCliente(recuperarClientes);
                            System.out.println("Insira o ID do cliente a ser removido:");
                            n = input.nextInt();
                            operacoes.apagarCliente(recuperarClientes, n);
                            operacoes.listarCliente(recuperarClientes);
                            break;

                        default:
                            System.out.println("Opcao invalida");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Area de produtos!");
                    System.out.println(
                            "Qual operacao deseja fazer?\n1 - Registrar produto\n2 - Listar todos os produtos\n3 - Atualizar um produto\n4 - Remover um produto");
                    p = input.nextInt();
                    switch (p) {

                        case 1:
                            System.out.println("Insira o...:");
                            System.out.println("Codigo do Produto");
                            int cod = input.nextInt();
                            input.nextLine();
                            System.out.println("Nome do produto");
                            String nome = input.nextLine();
                            System.out.println("Categoria do produto");
                            String cate = input.nextLine();

                            System.out.println("Quantidade");
                            int idade = input.nextInt();
                            input.nextLine();

                            System.out.println("Preco");
                            double preco = input.nextDouble();

                            Produto prod = new Produto(cod, nome, cate, data, idade, preco);

                            operacoes.adicionarProduto(v, prod);
                            boolean ficheiro = operacoes.gravarObj(v, product);
                            break;

                        case 2:

                            operacoes.listarProduto(recuperarProdutos);
                            break;

                        case 3:
                            break;

                        case 4:
                            break;

                        default:
                            System.out.println("Opcao invalida");
                            break;
                    }
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        } while (op != 5);

        System.out.println("Muito obrigado!");

    }
}

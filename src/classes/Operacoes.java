package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import interfaces.GestaoOperacoes;

public class Operacoes implements GestaoOperacoes {
    // Metodos do Cliente
    public void adicionarCliente(Vector v, Cliente c) {
        // metodo aqui!
    }

    public void atualizarCliente(Vector v, Cliente c) {
        // metodo aqui!
    }

    public void listarCliente(Vector v) {
        // metodo aqui!
    }

    public void apagarCliente(Vector v, int id) {
        // metodo aqui!
    }

    // Metodos do Produto
    public void adicionarProduto(Vector v, Produto p) {
        // metodo aqui!
    }

    public void atualizarProduto(Vector v, Produto p) {
        // metodo aqui!
    }

    public void listarProduto(Vector v) {
        // metodo aqui!
    }

    public void apagarProduto(Vector v, int id) {
        // metodo aqui!
    }

    public void novaVenda(Vector v, Cliente c, Produto p) {
        // metodo aqui!
    }

    public void todasVendasCliente(int id, Vector v) {
        // metodo aqui!
    }

    @Override
    public boolean gravarObj(Object obj, String path) {
        File arquivo = new File(path);

        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        try {

            FileOutputStream fileOut = new FileOutputStream(arquivo);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            objOut.writeObject(obj);

            objOut.flush();
            fileOut.flush();

            objOut.close();
            fileOut.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object recuperarObj(String path) {
        File arquivo = new File(path);
        try {
            FileInputStream fileIn = new FileInputStream(arquivo);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            Object retorno = objIn.readObject();

            objIn.close();
            fileIn.close();

            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

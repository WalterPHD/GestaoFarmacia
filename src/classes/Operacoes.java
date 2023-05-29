package classes;

import java.util.Vector;

import interfaces.GestaoOperacoes;

public class Operacoes implements GestaoOperacoes {
    // Metodos do Cliente
    public void adicionarCliente(Vector v, Cliente c) {
    	v.add(c);
    }

    public void atualizarCliente(Vector v, Cliente c) {
       
    }

    public void listarCliente(Vector v) {
        for(int i=0;i<v.size();i++) {
        	System.out.println((Cliente)v.get(i));
        }
    }

    public void apagarCliente(Vector v, int idC) {
        for(int i=0;i<v.size();i++) {
        	if(((Cliente)v.get(i)).getIdC()==idC) {
        		v.remove(i);
        	}
        }
    }

    // Metodos do Produto
    public void adicionarProduto(Vector v, Produto p) {
        v.add(p);
    }

    public void atualizarProduto(Vector v, Produto p) {
        // metodo aqui!
    }

    public void listarProduto(Vector v) {
    	for(int i=0;i<v.size();i++) {
        	System.out.println((Produto)v.get(i));
        }    }

    public void apagarProduto(Vector v, int idP) {
    	 for(int i=0;i<v.size();i++) {
         	if(((Produto)v.get(i)).getIdP()==idP) {
         		v.remove(i);
         	}
         }
    }

    public void novaVenda(Vector v, Cliente c, Produto p) {
    	for(int i=0;i<v.size();i++) {	
    		if(((Cliente)v.get(i)==c)&&((Produto)v.get(i)==p)) {
    			
    		}
          }
    }
    public void todasVendasCliente(int id, Vector v) {
        // metodo aqui!
    }
}

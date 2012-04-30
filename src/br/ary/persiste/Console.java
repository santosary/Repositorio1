
package br.ary.persiste;

import br.ary.Cliente;
import br.ary.Produto;
import br.ary.Venda;
import java.util.List;
import javax.persistence.*;

/**
 * @author Ary
 * @version 1.0
 */
public class Console {
    /**
     * @param args 
     */
    public static void main (String [] args) {
        //instaciando objetos do tipo referencia das classes
        EntityManagerFactory f = Persistence.createEntityManagerFactory("VendasPU");
        EntityManager manager = f.createEntityManager();
               
        /*Cliente c = new Cliente(); //instancia objeto do tipo Cliente               
        c.setNome("Ary");   //seta valor para o objeto
        c.setDtAninv(null);*/
        
        /*Produto p = new Produto();
        p.setNome("Milho");
        p.setValor(1);
        p.setEstoque(1);*/
        
        Venda v = new Venda();
        v.setCliente(v.getCliente());
        v.setData(v.getData());
                                
        EntityTransaction tran = manager.getTransaction();//instacia objeto tran
        tran.begin();
        
        //tratamento de excessões        
        /*try {
            manager.persist(c);
            tran.commit();
        }
        catch (Exception e) {
            tran.rollback();            
        }*/
        try {
            manager.persist(v);
            tran.commit();
        }
        catch (Exception e) {
            tran.rollback();
        }
        
        System.out.println(v.getCodigo());
        /*System.out.println(c.getCodigo()); //imprime o codigo do objeto c
        
        Cliente c2 = manager.find(Cliente.class, 2);
        System.out.println(c2.getNome());
        
        Query consulta = manager.createQuery("select c from Cliente c");
        List<Cliente> rs = consulta.getResultList();
        
        for (Cliente x : rs){
            System.out.println("codigo: " + Integer.toString(x.getCodigo())
                    + "\tnome: " + x.getNome() +"\t" + x.getDtAninv() + "\n");
        }*/
        
        /*Query consulta = manager.createQuery("select p from Produto p");
        List<Produto> rs = consulta.getResultList();
        
        for (Produto x : rs) {
            System.out.println("codigo: " + Integer.toString(x.getCodigo()) + "\t"
                    + "Nome: " + x.getNome() + "\tValor: " + x.getValor() 
                    + "\tEstoque: " + x.getEstoque() + "\n");
        }*/
        
        Query consulta = manager.createQuery("select v from Venda v");
        List<Venda> rs = consulta.getResultList();
        
        for (Venda x : rs) {
            System.out.println("codigo: " + Integer.toString(x.getCodigo()) + "\t"
                    + "Nome: " + x.getCliente() + "\tValor: " + x.getData() + "\n");
        }
    }
}

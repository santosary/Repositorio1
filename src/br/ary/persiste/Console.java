package br.ary.persiste;

import br.ary.Cliente;
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
        EntityManagerFactory f = Persistence.createEntityManagerFactory("vandasPU");
        EntityManager manager = f.createEntityManager();
                
        Cliente c = new Cliente(); //instancia objeto do tipo Cliente
        c.setNome("Ary");   //seta valor para o objeto
        
        EntityTransaction tran = manager.getTransaction();//instacia objeto tran
        tran.begin();
        
        //tratamento de excessões        
        try {
            manager.persist(c);
            tran.commit();
        }
        catch (Exception e) {
            tran.rollback();
        }
        
        System.out.println(c.getCodigo()); //imprime o codigo do objeto c
        
        Cliente c2 = manager.find(Cliente.class, 2);
        System.out.println(c2.getNome());
        
        Query consulta = manager.createQuery("select * from Cliente c");
        List<Cliente> rs = consulta.getResultList();
        
        for (Cliente x : rs){
            System.out.println("codigo: " + Integer.toString(x.getCodigo())
                    + "nome: " + x.getNome());
        }
    }
}

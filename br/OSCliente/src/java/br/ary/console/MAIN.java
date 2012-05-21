package br.ary.console;

import br.ary.domainModel.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Ary
 */
public class MAIN {
     public static void main(String[] args) {
        try {
            Context context= new InitialContext();
            ClienteRepositorio ejb =  (ClienteRepositorio) context.lookup("java:global/OS/OS-ejb/ClienteDAO");
            OSRepositorio ej = (OSRepositorio) context.lookup("java:global/OS/OS-ejb/OSDAO");
            ServicoRepositorio e = (ServicoRepositorio) context.lookup("java:global/OS/OS-ejb/ServicoDAO");
            
            Cliente cli = new Cliente();
            
            cli.setNome("Joaninha");
            cli.setCPF("000.000.000.00"); 
            ejb.Salvar(cli);
            
            Servico servico = new Servico();
            servico.setDescricao("MArcelo");
            servico.setValor(10);            
            e.Salvar(servico);
            
            OS os= new OS();
            //os.setCliente(cli);             
            os.setStatus(1);
            Calendar cal = Calendar.getInstance();
            cal.set(1900, 11, 01);
            os.setData(cal.getTime());            
            ej.Salvar(os);
            
        } catch (NamingException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
}
package br.edu.fasa.vendas.domainModel;

/**
 * @author ary
 */
public class Venda {
    private int codigo;
    private Cliente cliente;
     private String data;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }   
}

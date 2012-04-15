package br.ary;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @author ary
 * @version 1.0
 */
@Entity
@Table (name = "Vendas")
public class Venda implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "codigo")
    private int codigo;
    
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "clientes")
    private Cliente cliente;
    
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "venda", targetEntity = ItemVenda.class)
    private List<ItemVenda> itens;
            
    @Temporal (TemporalType.TIMESTAMP)    
    private Date datas;
                
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

    public Date getData() {
        return datas;
    }

    public void setData(Date data) {
        this.datas = data;
    }
    
    public List<ItemVenda> getItens() {
        return itens;
    }
    
    public void removeItens(ItemVenda iv) {
        itens.remove(iv);
    }

    public ItemVenda getItemVenda(int iv) {
        return itens.get(iv);
    }

}

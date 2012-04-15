package br.ary;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author ary
 * @version 1.0
 */
@Entity
@Table (name="ItensVendas")
public class ItemVenda implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "codigo")    
    private int codigo;
    
    @ManyToOne (cascade = CascadeType.ALL,targetEntity = Venda.class)
    @JoinColumn(name = "venda")
    private Venda venda;
    
    @ManyToOne (cascade = CascadeType.ALL, targetEntity = Produto.class)
    @JoinColumn (name = "produto")
    private Produto produto;
    
    @Column (name="quantidades")
    private int quantidade;
    
    @Column (name="ValoresVendas")
    private float valorVenda;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}

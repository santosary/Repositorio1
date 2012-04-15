package br.ary;
/*
As importações abaixo foram substituídas por javax.persistence.*
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
*/
import java.io.Serializable;
import javax.persistence.*;
/**
 * @author ary
 */
@Entity
@Table (name = "Produtos")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "codigo")
    private int codigo;
    
    @Column (name = "nome", length = 255, nullable = false)
    private String nome;
    
    @Column (name = "valor")
    private float valor;
    
    @Column (name = "estoques", nullable = false)
    private int estoque;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }    
}

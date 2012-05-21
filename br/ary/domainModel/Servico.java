package br.ary.domainModel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Ary
 */
@Entity
@Table(name = "servico")
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "descricao")    
    private String descricao;
    
    @Column(name = "valor")
    private float valor;  
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "servico")
    private List<OS> os;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public void addItem (OS o) {
        OSItem it = new OSItem();
        it.setId(id);
        it.setOrdem(o);
        it.setServico(this);
        os.add(o);
    }
    
    public void remove (OS o) {
        os.remove(o);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 71 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 71 * hash + Float.floatToIntBits(this.valor);
        return hash;
    }
    
    @Override
    public String toString() {
        return "br.ary.domainModel.Servico[ id=" + id + " ]";
    }
    
}

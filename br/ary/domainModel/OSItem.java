package br.ary.domainModel;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Ary
 */
@Entity
@Table(name = "OSItem")
public class OSItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private OS ordem;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Servico servico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OS getOrdem() {
        return ordem;
    }

    public void setOrdem(OS ordem) {
        this.ordem = ordem;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OSItem other = (OSItem) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.ordem != other.ordem && (this.ordem == null || !this.ordem.equals(other.ordem))) {
            return false;
        }
        if (this.servico != other.servico && (this.servico == null || !this.servico.equals(other.servico))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 89 * hash + (this.ordem != null ? this.ordem.hashCode() : 0);
        hash = 89 * hash + (this.servico != null ? this.servico.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString() {
        return "br.ary.domainModel.OSItem[ id=" + id + " ]";
    }
    
}

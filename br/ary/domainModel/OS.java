package br.ary.domainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Ary
 */
@Entity
@Table(name = "OS")
public class OS implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne 
    @JoinColumn(name = "cliente")
    private Cliente cliente;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "data")
    private Date data;
    
    @Column(name = "status")
    private int status;
    
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "ordem")//indica qual é a chave estrangeira
    private List<Servico> itens;
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Servico> getItens() {
        return itens;
    }

    public void setItens(List<Servico> itens) {
        this.itens = itens;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void addItem (Servico s) {
        OSItem it = new OSItem();
        it.setOrdem(this);
        it.setId(id);
        it.setServico(s);
        itens.add(s);
    }
    
    public void remove (Servico s) {
        itens.remove(s);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OS other = (OS) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.cliente != other.cliente && (this.cliente == null || !this.cliente.equals(other.cliente))) {
            return false;
        }
        if (this.data != other.data && (this.data == null || !this.data.equals(other.data))) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 37 * hash + (this.cliente != null ? this.cliente.hashCode() : 0);
        hash = 37 * hash + (this.data != null ? this.data.hashCode() : 0);
        hash = 37 * hash + this.status;
        return hash;
    }
    
    @Override
    public String toString() {
        return "br.ary.domainModel.OS[ id=" + id + " ]";
    }    
}

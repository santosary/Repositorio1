package br.ary;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @author ary
 * @version 1.0
 */
@Entity
@Table (name="Clientes")
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "codigo")
    private int codigo;

    @Column (name = "nome",length = 255)
    private String nome;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtAninv;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDtAninv(Date dataAninversario) {
        this.dtAninv = dataAninversario;
    }

    public Date getDtAninv() {
        return dtAninv;
    }
}

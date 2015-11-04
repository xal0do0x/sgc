/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "banco_vecinal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BancoVecinal.findAll", query = "SELECT b FROM BancoVecinal b"),
    @NamedQuery(name = "BancoVecinal.findByIdBancovecinal", query = "SELECT b FROM BancoVecinal b WHERE b.idBancovecinal = :idBancovecinal"),
    @NamedQuery(name = "BancoVecinal.findByNombre", query = "SELECT b FROM BancoVecinal b WHERE b.nombre = :nombre")})
public class BancoVecinal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBancovecinal")
    private Integer idBancovecinal;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "bancoVecinal")
    private List<Credito> creditoList;
    @JoinColumn(name = "representante_dni", referencedColumnName = "num_identificacion")
    @ManyToOne(optional = false)
    private Persona representanteDni;

    public BancoVecinal() {
    }

    public BancoVecinal(Integer idBancovecinal) {
        this.idBancovecinal = idBancovecinal;
    }

    public BancoVecinal(Integer idBancovecinal, String nombre) {
        this.idBancovecinal = idBancovecinal;
        this.nombre = nombre;
    }

    public Integer getIdBancovecinal() {
        return idBancovecinal;
    }

    public void setIdBancovecinal(Integer idBancovecinal) {
        this.idBancovecinal = idBancovecinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Credito> getCreditoList() {
        return creditoList;
    }

    public void setCreditoList(List<Credito> creditoList) {
        this.creditoList = creditoList;
    }

    public Persona getRepresentanteDni() {
        return representanteDni;
    }

    public void setRepresentanteDni(Persona representanteDni) {
        this.representanteDni = representanteDni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBancovecinal != null ? idBancovecinal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BancoVecinal)) {
            return false;
        }
        BancoVecinal other = (BancoVecinal) object;
        if ((this.idBancovecinal == null && other.idBancovecinal != null) || (this.idBancovecinal != null && !this.idBancovecinal.equals(other.idBancovecinal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.BancoVecinal[ idBancovecinal=" + idBancovecinal + " ]";
    }
    
}

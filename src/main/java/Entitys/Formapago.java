/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GabrielRD
 */
@Entity
@Table(name = "formapago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formapago.findAll", query = "SELECT f FROM Formapago f"),
    @NamedQuery(name = "Formapago.findByIdFormaPago", query = "SELECT f FROM Formapago f WHERE f.idFormaPago = :idFormaPago"),
    @NamedQuery(name = "Formapago.findByDescripcion", query = "SELECT f FROM Formapago f WHERE f.descripcion = :descripcion")})
public class Formapago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFormaPago")
    private Integer idFormaPago;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormaPago")
    private List<Credito> creditoList;

    public Formapago() {
    }

    public Formapago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public Formapago(Integer idFormaPago, String descripcion) {
        this.idFormaPago = idFormaPago;
        this.descripcion = descripcion;
    }

    public Integer getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Credito> getCreditoList() {
        return creditoList;
    }

    public void setCreditoList(List<Credito> creditoList) {
        this.creditoList = creditoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormaPago != null ? idFormaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formapago)) {
            return false;
        }
        Formapago other = (Formapago) object;
        if ((this.idFormaPago == null && other.idFormaPago != null) || (this.idFormaPago != null && !this.idFormaPago.equals(other.idFormaPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Formapago[ idFormaPago=" + idFormaPago + " ]";
    }
    
}

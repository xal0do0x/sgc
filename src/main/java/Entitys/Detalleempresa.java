/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GabrielRD
 */
@Entity
@Table(name = "detalleempresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleempresa.findAll", query = "SELECT d FROM Detalleempresa d"),
    @NamedQuery(name = "Detalleempresa.findByIdDetalleEmpresa", query = "SELECT d FROM Detalleempresa d WHERE d.idDetalleEmpresa = :idDetalleEmpresa")})
public class Detalleempresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleEmpresa")
    private Integer idDetalleEmpresa;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;
    @JoinColumn(name = "idPersona", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public Detalleempresa() {
    }

    public Detalleempresa(Integer idDetalleEmpresa) {
        this.idDetalleEmpresa = idDetalleEmpresa;
    }

    public Integer getIdDetalleEmpresa() {
        return idDetalleEmpresa;
    }

    public void setIdDetalleEmpresa(Integer idDetalleEmpresa) {
        this.idDetalleEmpresa = idDetalleEmpresa;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleEmpresa != null ? idDetalleEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleempresa)) {
            return false;
        }
        Detalleempresa other = (Detalleempresa) object;
        if ((this.idDetalleEmpresa == null && other.idDetalleEmpresa != null) || (this.idDetalleEmpresa != null && !this.idDetalleEmpresa.equals(other.idDetalleEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Detalleempresa[ idDetalleEmpresa=" + idDetalleEmpresa + " ]";
    }
    
}

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
 * @author GabrielRD
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Empresa.findByRuc", query = "SELECT e FROM Empresa e WHERE e.ruc = :ruc"),
    @NamedQuery(name = "Empresa.findByNombre", query = "SELECT e FROM Empresa e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empresa.findByDireccion", query = "SELECT e FROM Empresa e WHERE e.direccion = :direccion")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmpresa")
    private Integer idEmpresa;
    @Basic(optional = false)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<Detalleempresa> detalleempresaList;
    @OneToMany(mappedBy = "bancoVecinal")
    private List<Credito> creditoList;
    @JoinColumn(name = "dniRepresentante", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Persona dniRepresentante;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, String ruc, String nombre, String direccion) {
        this.idEmpresa = idEmpresa;
        this.ruc = ruc;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public List<Detalleempresa> getDetalleempresaList() {
        return detalleempresaList;
    }

    public void setDetalleempresaList(List<Detalleempresa> detalleempresaList) {
        this.detalleempresaList = detalleempresaList;
    }

    @XmlTransient
    public List<Credito> getCreditoList() {
        return creditoList;
    }

    public void setCreditoList(List<Credito> creditoList) {
        this.creditoList = creditoList;
    }

    public Persona getDniRepresentante() {
        return dniRepresentante;
    }

    public void setDniRepresentante(Persona dniRepresentante) {
        this.dniRepresentante = dniRepresentante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}

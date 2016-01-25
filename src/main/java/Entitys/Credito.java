/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GabrielRD
 */
@Entity
@Table(name = "credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credito.findAll", query = "SELECT c FROM Credito c"),
    @NamedQuery(name = "Credito.findByIdCredito", query = "SELECT c FROM Credito c WHERE c.idCredito = :idCredito"),
    @NamedQuery(name = "Credito.findByTipoCliente", query = "SELECT c FROM Credito c WHERE c.tipoCliente = :tipoCliente"),
    @NamedQuery(name = "Credito.findByMonto", query = "SELECT c FROM Credito c WHERE c.monto = :monto"),
    @NamedQuery(name = "Credito.findByTiempo", query = "SELECT c FROM Credito c WHERE c.tiempo = :tiempo"),
    @NamedQuery(name = "Credito.findByTasa", query = "SELECT c FROM Credito c WHERE c.tasa = :tasa"),
    @NamedQuery(name = "Credito.findByFechaInicio", query = "SELECT c FROM Credito c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Credito.findByFechaFinal", query = "SELECT c FROM Credito c WHERE c.fechaFinal = :fechaFinal")})
public class Credito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCredito")
    private Integer idCredito;
    @Basic(optional = false)
    @Column(name = "tipo_cliente")
    private String tipoCliente;
    @Basic(optional = false)
    @Column(name = "monto")
    private double monto;
    @Basic(optional = false)
    @Column(name = "tiempo")
    private int tiempo;
    @Basic(optional = false)
    @Column(name = "tasa")
    private double tasa;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCredito")
    private List<Cuota> cuotaList;
    @JoinColumn(name = "id_empresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa idEmpresa;
    @JoinColumn(name = "id_FormaPago", referencedColumnName = "idFormaPago")
    @ManyToOne(optional = false)
    private Formapago idFormaPago;
    @JoinColumn(name = "id_persona", referencedColumnName = "dni")
    @ManyToOne
    private Persona idPersona;
    @JoinColumn(name = "aval", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Persona aval;
    @JoinColumn(name = "colaborador", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Persona colaborador;

    public Credito() {
    }

    public Credito(Integer idCredito) {
        this.idCredito = idCredito;
    }

    public Credito(Integer idCredito, String tipoCliente, double monto, int tiempo, double tasa, Date fechaInicio) {
        this.idCredito = idCredito;
        this.tipoCliente = tipoCliente;
        this.monto = monto;
        this.tiempo = tiempo;
        this.tasa = tasa;
        this.fechaInicio = fechaInicio;
    }

    public Integer getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(Integer idCredito) {
        this.idCredito = idCredito;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @XmlTransient
    public List<Cuota> getCuotaList() {
        return cuotaList;
    }

    public void setCuotaList(List<Cuota> cuotaList) {
        this.cuotaList = cuotaList;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Formapago getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Formapago idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Persona getAval() {
        return aval;
    }

    public void setAval(Persona aval) {
        this.aval = aval;
    }

    public Persona getColaborador() {
        return colaborador;
    }

    public void setColaborador(Persona colaborador) {
        this.colaborador = colaborador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCredito != null ? idCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credito)) {
            return false;
        }
        Credito other = (Credito) object;
        if ((this.idCredito == null && other.idCredito != null) || (this.idCredito != null && !this.idCredito.equals(other.idCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Credito[ idCredito=" + idCredito + " ]";
    }
    
}

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
 * @author Gabriel
 */
@Entity
@Table(name = "credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credito.findAll", query = "SELECT c FROM Credito c"),
    @NamedQuery(name = "Credito.findByIdCredito", query = "SELECT c FROM Credito c WHERE c.idCredito = :idCredito"),
    @NamedQuery(name = "Credito.findByTipoPersona", query = "SELECT c FROM Credito c WHERE c.tipoPersona = :tipoPersona"),
    @NamedQuery(name = "Credito.findByMonto", query = "SELECT c FROM Credito c WHERE c.monto = :monto"),
    @NamedQuery(name = "Credito.findByTiempo", query = "SELECT c FROM Credito c WHERE c.tiempo = :tiempo"),
    @NamedQuery(name = "Credito.findByFormaPago", query = "SELECT c FROM Credito c WHERE c.formaPago = :formaPago"),
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
    @Column(name = "tipo_persona")
    private Character tipoPersona;
    @Basic(optional = false)
    @Column(name = "monto")
    private double monto;
    @Basic(optional = false)
    @Column(name = "tiempo")
    private int tiempo;
    @Basic(optional = false)
    @Column(name = "forma_pago")
    private String formaPago;
    @Basic(optional = false)
    @Column(name = "tasa")
    private double tasa;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @JoinColumn(name = "colaborador_dni", referencedColumnName = "num_identificacion")
    @ManyToOne(optional = false)
    private Persona colaboradorDni;
    @JoinColumn(name = "aval_dni", referencedColumnName = "num_identificacion")
    @ManyToOne(optional = false)
    private Persona avalDni;
    @JoinColumn(name = "cliente_dni", referencedColumnName = "num_identificacion")
    @ManyToOne
    private Persona clienteDni;
    @JoinColumn(name = "banco_vecinal", referencedColumnName = "idBancovecinal")
    @ManyToOne
    private BancoVecinal bancoVecinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCredito")
    private List<Cuota> cuotaList;

    public Credito() {
    }

    public Credito(Integer idCredito) {
        this.idCredito = idCredito;
    }

    public Credito(Integer idCredito, Character tipoPersona, double monto, int tiempo, String formaPago, double tasa) {
        this.idCredito = idCredito;
        this.tipoPersona = tipoPersona;
        this.monto = monto;
        this.tiempo = tiempo;
        this.formaPago = formaPago;
        this.tasa = tasa;
    }

    public Integer getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(Integer idCredito) {
        this.idCredito = idCredito;
    }

    public Character getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(Character tipoPersona) {
        this.tipoPersona = tipoPersona;
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

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
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

    public Persona getColaboradorDni() {
        return colaboradorDni;
    }

    public void setColaboradorDni(Persona colaboradorDni) {
        this.colaboradorDni = colaboradorDni;
    }

    public Persona getAvalDni() {
        return avalDni;
    }

    public void setAvalDni(Persona avalDni) {
        this.avalDni = avalDni;
    }

    public Persona getClienteDni() {
        return clienteDni;
    }

    public void setClienteDni(Persona clienteDni) {
        this.clienteDni = clienteDni;
    }

    public BancoVecinal getBancoVecinal() {
        return bancoVecinal;
    }

    public void setBancoVecinal(BancoVecinal bancoVecinal) {
        this.bancoVecinal = bancoVecinal;
    }

    @XmlTransient
    public List<Cuota> getCuotaList() {
        return cuotaList;
    }

    public void setCuotaList(List<Cuota> cuotaList) {
        this.cuotaList = cuotaList;
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

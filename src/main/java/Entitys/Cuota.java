/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GabrielRD
 */
@Entity
@Table(name = "cuota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuota.findAll", query = "SELECT c FROM Cuota c"),
    @NamedQuery(name = "Cuota.findByIdCuota", query = "SELECT c FROM Cuota c WHERE c.idCuota = :idCuota"),
    @NamedQuery(name = "Cuota.findByMonto", query = "SELECT c FROM Cuota c WHERE c.monto = :monto"),
    @NamedQuery(name = "Cuota.findByFechaVencimiento", query = "SELECT c FROM Cuota c WHERE c.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "Cuota.findByFechaPago", query = "SELECT c FROM Cuota c WHERE c.fechaPago = :fechaPago"),
    @NamedQuery(name = "Cuota.findByMora", query = "SELECT c FROM Cuota c WHERE c.mora = :mora"),
    @NamedQuery(name = "Cuota.findByMontoCobrado", query = "SELECT c FROM Cuota c WHERE c.montoCobrado = :montoCobrado"),
    @NamedQuery(name = "Cuota.findByEstado", query = "SELECT c FROM Cuota c WHERE c.estado = :estado")})
public class Cuota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCuota")
    private Integer idCuota;
    @Basic(optional = false)
    @Column(name = "monto")
    private double monto;
    @Basic(optional = false)
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mora")
    private Double mora;
    @Column(name = "monto_cobrado")
    private Double montoCobrado;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idCredito", referencedColumnName = "idCredito")
    @ManyToOne(optional = false)
    private Credito idCredito;

    public Cuota() {
    }

    public Cuota(Integer idCuota) {
        this.idCuota = idCuota;
    }

    public Cuota(Integer idCuota, double monto, Date fechaVencimiento) {
        this.idCuota = idCuota;
        this.monto = monto;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(Integer idCuota) {
        this.idCuota = idCuota;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getMora() {
        return mora;
    }

    public void setMora(Double mora) {
        this.mora = mora;
    }

    public Double getMontoCobrado() {
        return montoCobrado;
    }

    public void setMontoCobrado(Double montoCobrado) {
        this.montoCobrado = montoCobrado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Credito getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(Credito idCredito) {
        this.idCredito = idCredito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuota != null ? idCuota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuota)) {
            return false;
        }
        Cuota other = (Cuota) object;
        if ((this.idCuota == null && other.idCuota != null) || (this.idCuota != null && !this.idCuota.equals(other.idCuota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Cuota[ idCuota=" + idCuota + " ]";
    }
    
}

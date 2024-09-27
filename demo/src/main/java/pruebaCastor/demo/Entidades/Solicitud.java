package pruebaCastor.demo.Entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nroSolicitud;

    private String solicitante;
    private String fechaSolicitud;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @OneToMany(mappedBy = "solicitud", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SolicitudServicio> servicios;

    // Getters y setters
    public Integer getNroSolicitud() {
        return nroSolicitud;
    }

    public void setNroSolicitud(Integer nroSolicitud) {
        this.nroSolicitud = nroSolicitud;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<SolicitudServicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<SolicitudServicio> servicios) {
        this.servicios = servicios;
    }
}

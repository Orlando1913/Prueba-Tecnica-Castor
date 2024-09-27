package pruebaCastor.demo.Entidades;

import jakarta.persistence.*;

@Entity
@IdClass(SolicitudServicioId.class) // Definir la clave compuesta
@Table(name = "solicitud_servicio")
public class SolicitudServicio {

    @Id
    @ManyToOne
    @JoinColumn(name = "nro_solicitud", nullable = false)
    private Solicitud solicitud;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false)
    private Servicio servicio;

    // Getters y setters

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}

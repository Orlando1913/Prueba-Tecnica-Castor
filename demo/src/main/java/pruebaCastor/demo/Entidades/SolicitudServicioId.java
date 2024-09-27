package pruebaCastor.demo.Entidades;

import java.io.Serializable;
import java.util.Objects;

public class SolicitudServicioId implements Serializable {
    private Integer solicitud;
    private Integer servicio;

    // Getters, setters, equals, hashCode

    public Integer getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Integer solicitud) {
        this.solicitud = solicitud;
    }

    public Integer getServicio() {
        return servicio;
    }

    public void setServicio(Integer servicio) {
        this.servicio = servicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudServicioId that = (SolicitudServicioId) o;
        return Objects.equals(solicitud, that.solicitud) &&
                Objects.equals(servicio, that.servicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(solicitud, servicio);
    }
}

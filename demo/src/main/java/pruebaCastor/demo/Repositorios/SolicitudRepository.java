package pruebaCastor.demo.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pruebaCastor.demo.Entidades.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
    @Query("SELECT s FROM Solicitud s JOIN FETCH s.servicios WHERE s.nroSolicitud = :nroSolicitud")
    Solicitud findSolicitudConServicios(@Param("nroSolicitud") Integer nroSolicitud);

}

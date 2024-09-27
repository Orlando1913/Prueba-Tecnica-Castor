package pruebaCastor.demo.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import pruebaCastor.demo.Entidades.SolicitudServicio;
import pruebaCastor.demo.Entidades.SolicitudServicioId;

public interface SolicitudServicioRepository extends JpaRepository<SolicitudServicio, SolicitudServicioId> {
}

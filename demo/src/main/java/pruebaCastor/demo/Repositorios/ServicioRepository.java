package pruebaCastor.demo.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaCastor.demo.Entidades.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
}

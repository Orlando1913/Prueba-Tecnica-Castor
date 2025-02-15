package pruebaCastor.demo.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaCastor.demo.Entidades.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}

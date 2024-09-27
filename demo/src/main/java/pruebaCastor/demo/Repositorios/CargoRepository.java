package pruebaCastor.demo.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaCastor.demo.Entidades.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}


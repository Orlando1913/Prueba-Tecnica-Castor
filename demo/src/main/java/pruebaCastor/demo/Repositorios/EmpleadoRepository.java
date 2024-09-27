package pruebaCastor.demo.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaCastor.demo.Entidades.Empleado;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {  // Cambiado a Integer
    Optional<Empleado> findByCedula(String cedula);  // Correcto como String
}



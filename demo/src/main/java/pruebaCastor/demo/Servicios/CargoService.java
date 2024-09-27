package pruebaCastor.demo.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebaCastor.demo.Entidades.Cargo;
import pruebaCastor.demo.Repositorios.CargoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    public Optional<Cargo> findById(Integer id) {
        return cargoRepository.findById(id);
    }

    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public void delete(Integer id) {
        cargoRepository.deleteById(id);
    }
}

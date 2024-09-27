package pruebaCastor.demo.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pruebaCastor.demo.Entidades.Cargo;
import pruebaCastor.demo.Servicios.CargoService;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
@CrossOrigin(origins = "http://localhost:4200") // Permitir solicitudes desde el frontend
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public ResponseEntity<List<Cargo>> getAllCargos() {
        List<Cargo> cargos = cargoService.findAll();
        return new ResponseEntity<>(cargos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable Integer id) {
        return cargoService.findById(id)
                .map(cargo -> new ResponseEntity<>(cargo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Cargo> createCargo(@RequestBody Cargo cargo) {
        Cargo savedCargo = cargoService.save(cargo);
        return new ResponseEntity<>(savedCargo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> updateCargo(@PathVariable Integer id, @RequestBody Cargo cargoDetails) {
        return cargoService.findById(id)
                .map(cargo -> {
                    cargo.setNombre(cargoDetails.getNombre());
                    Cargo updatedCargo = cargoService.save(cargo);
                    return new ResponseEntity<>(updatedCargo, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable Integer id) {
        return cargoService.findById(id)
                .map(cargo -> {
                    cargoService.delete(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

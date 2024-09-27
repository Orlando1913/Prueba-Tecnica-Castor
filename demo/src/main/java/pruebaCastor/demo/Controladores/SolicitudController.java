package pruebaCastor.demo.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pruebaCastor.demo.Entidades.Solicitud;
import pruebaCastor.demo.Servicios.SolicitudService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping
    public List<Solicitud> listarSolicitudes() {
        return solicitudService.listarSolicitudes();
    }

    @GetMapping("/{id}")
    public Optional<Solicitud> obtenerSolicitud(@PathVariable Integer id) {
        return solicitudService.obtenerSolicitudPorId(id);
    }

    @PostMapping
    public ResponseEntity<Solicitud> crearSolicitud(@RequestBody Solicitud solicitud) {
        Solicitud nuevaSolicitud = solicitudService.crearSolicitud(solicitud);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSolicitud);
    }

    @DeleteMapping("/{id}")
    public void eliminarSolicitud(@PathVariable Integer id) {
        solicitudService.eliminarSolicitud(id);
    }
}

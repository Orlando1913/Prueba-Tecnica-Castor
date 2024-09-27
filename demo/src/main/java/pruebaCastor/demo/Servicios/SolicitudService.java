package pruebaCastor.demo.Servicios;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebaCastor.demo.Entidades.Solicitud;
import pruebaCastor.demo.Repositorios.SolicitudRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    public Solicitud crearSolicitud(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    public Optional<Solicitud> obtenerSolicitudPorId(Integer id) {
        return solicitudRepository.findById(id);
    }

    public List<Solicitud> listarSolicitudes() {
        return solicitudRepository.findAll();
    }

    public Solicitud actualizarSolicitud(Integer id, Solicitud solicitudActualizada) {
        return solicitudRepository.findById(id)
                .map(solicitud -> {
                    solicitud.setSolicitante(solicitudActualizada.getSolicitante());
                    solicitud.setFechaSolicitud(solicitudActualizada.getFechaSolicitud());
                    solicitud.setEstado(solicitudActualizada.getEstado());
                    return solicitudRepository.save(solicitud);
                })
                .orElseThrow(() -> new EntityNotFoundException("Solicitud no encontrada"));
    }

    public void eliminarSolicitud(Integer id) {
        solicitudRepository.deleteById(id);
    }
}

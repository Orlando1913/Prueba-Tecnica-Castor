package pruebaCastor.demo.Servicios;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile; // Importar para manejar archivos
import pruebaCastor.demo.Entidades.Empleado;
import pruebaCastor.demo.Repositorios.CargoRepository;
import pruebaCastor.demo.Repositorios.EmpleadoRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private CargoRepository cargoRepository;

    private final String UPLOAD_DIR = "src/main/resources/uploads";


    public Empleado crearEmpleado(Empleado empleado, MultipartFile foto) {
        if (foto != null && !foto.isEmpty()) {
            try {

                String fotoNombre = foto.getOriginalFilename();
                Path rutaCompleta = Paths.get(UPLOAD_DIR, fotoNombre);
                Files.copy(foto.getInputStream(), rutaCompleta);


                empleado.setFoto(fotoNombre);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return empleadoRepository.save(empleado);
    }

    public Optional<Empleado> obtenerEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(id);
    }

    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado actualizarEmpleado(Integer id, Empleado empleadoActualizado, MultipartFile foto) {
        return empleadoRepository.findById(id)
                .map(empleado -> {
                    empleado.setNombre(empleadoActualizado.getNombre());
                    empleado.setCedula(empleadoActualizado.getCedula());
                    if (foto != null && !foto.isEmpty()) {
                        try {
                            // Guardar la nueva imagen en el servidor
                            String fotoNombre = foto.getOriginalFilename();
                            Path rutaCompleta = Paths.get(UPLOAD_DIR, fotoNombre);
                            Files.copy(foto.getInputStream(), rutaCompleta);

                            // Actualizar la ruta de la imagen en la entidad empleado
                            empleado.setFoto(fotoNombre); // Guarda solo el nombre o ruta relativa
                        } catch (IOException e) {
                            e.printStackTrace(); // Manejar la excepción según tu lógica
                        }
                    }
                    empleado.setFechaIngreso(empleadoActualizado.getFechaIngreso());
                    empleado.setCargo(empleadoActualizado.getCargo());
                    return empleadoRepository.save(empleado);
                })
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));
    }

    public void eliminarEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}

package pruebaCastor.demo.Controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource; // Asegúrate de importar la clase Resource
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile; // Importar para manejar archivos
import pruebaCastor.demo.Entidades.Empleado;
import pruebaCastor.demo.Servicios.EmpleadoService;

import java.io.File;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestParam("empleado") String empleadoJson,
                                                  @RequestParam("foto") MultipartFile foto) {
        try {
            Empleado empleado = objectMapper.readValue(empleadoJson, Empleado.class);
            Empleado empleadoCreado = empleadoService.crearEmpleado(empleado, foto);
            return ResponseEntity.status(HttpStatus.CREATED).body(empleadoCreado);
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body(null); // Manejo de error de JSON
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Manejo de otros errores
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Integer id) {
        return empleadoService.obtenerEmpleadoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleados() {
        return ResponseEntity.ok(empleadoService.listarEmpleados());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestParam("empleado") Empleado empleado,
                                                       @RequestParam(value = "foto", required = false) MultipartFile foto) {
        Empleado empleadoActualizado = empleadoService.actualizarEmpleado(id, empleado, foto);
        return ResponseEntity.ok(empleadoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Integer id) {
        empleadoService.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/uploads/{filename:.+}")
    public ResponseEntity<Resource> obtenerImagen(@PathVariable String filename) {
        System.out.println("Filename requested: " + filename);

        // Imprime la ruta completa
        File file = new File("src/main/resources/uploads/" + filename);
        System.out.println("Full path: " + file.getAbsolutePath());

        if (file.exists()) {
            return ResponseEntity.ok(new FileSystemResource(file));
        } else {
            System.out.println("File not found: " + file.getAbsolutePath());
            return ResponseEntity.notFound().build();
        }
    }



}

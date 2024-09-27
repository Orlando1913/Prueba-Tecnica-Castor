package pruebaCastor.demo.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo") // Ajustado para que coincida con el nombre de la columna en la base de datos
    private Integer idCargo; // Cambiado a Integer para coincidir con el tipo INT en SQL

    @Column(name = "nombre", nullable = false, length = 50) // Coincide con la definición de la tabla
    private String nombre;

    // Getters y Setters

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

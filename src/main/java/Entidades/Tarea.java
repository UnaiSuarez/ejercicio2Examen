package Entidades;

import java.io.Serializable;

public class Tarea implements Serializable{
    private Persona persona;
    private Urgencia urgencia;
    private String nombre;
    private String descripcion;

    public Tarea() {
    }

    public Tarea(Persona persona, Urgencia urgencia, String nombre, String descripcion) {
        this.persona = persona;
        this.urgencia = urgencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public Urgencia getUrgencia() {
        return urgencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                ", urgencia='" + urgencia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                "persona=" + persona +
                '}';
    }
}

/*package com.t1lean.runlife_api.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publicacionId;
    private Date fecha;
    private float duracion;
    private String descripcion;
    private String asistencia;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "comunidad_id")
    private Comunidad comunidad;

    // Constructor vacío
    public Publicacion() {
    }

    // Constructor con todos los campos excepto publicacionId
    public Publicacion(Date fecha, float duracion, String descripcion, String asistencia, Usuario usuario, Comunidad comunidad) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.asistencia = asistencia;
        this.usuario = usuario;
        this.comunidad = comunidad;
    }

    // Getters y setters de todos los campos

    public int getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(int publicacionId) {
        this.publicacionId = publicacionId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }
}
*/
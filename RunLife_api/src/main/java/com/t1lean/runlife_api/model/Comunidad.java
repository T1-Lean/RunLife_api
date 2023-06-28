/*package com.t1lean.runlife_api.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Comunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comunidadId;

    @OneToMany(mappedBy = "comunidad")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "comunidad")
    private List<Publicacion> publicaciones;

    // Constructor vacío
    public Comunidad() {
    }

    // Constructor con todos los campos excepto comunidadId
    public Comunidad(List<Usuario> usuarios, List<Publicacion> publicaciones) {
        this.usuarios = usuarios;
        this.publicaciones = publicaciones;
    }

    // Getters y setters de todos los campos

    public int getComunidadId() {
        return comunidadId;
    }

    public void setComunidadId(int comunidadId) {
        this.comunidadId = comunidadId;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
}
*/
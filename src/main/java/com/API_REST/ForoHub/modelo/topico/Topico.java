package com.API_REST.ForoHub.modelo.topico;


import com.API_REST.ForoHub.modelo.respuesta.Respuesta;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
//@EqualsAndHashCode(of = "id")
//@JsonInclude(JsonInclude.Include.NON_NULL)

public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idUsuario;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status; // boolean???
    private String autor;
    private String curso;

    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
    @JsonManagedReference // serializar lista?
    private List<Respuesta> respuestas;

    public Topico() {

    }

    public Topico(TopicoDTO DTOdatosTopicoDTO) {
        // .id generado por BD al crear Topico
        this.titulo = DTOdatosTopicoDTO.titulo();
        this.mensaje = DTOdatosTopicoDTO.mensaje();
        this.fechaCreacion = LocalDateTime.now(); // fecha actual
        this.idUsuario = DTOdatosTopicoDTO.idUsuario();
        this.curso = DTOdatosTopicoDTO.curso();
        this.respuestas = new ArrayList<>();
        this.status = "No sé";  // Activo o inactivo
        this.autor = "No sé"; // depende el usuario?
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "Topico{" +
                "autor='" + autor + '\'' +
                ", id=" + id +
                ", idUsuario='" + idUsuario + '\'' +
                ", titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", status='" + status + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }
}

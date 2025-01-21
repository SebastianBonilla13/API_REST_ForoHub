package com.API_REST.ForoHub.modelo.respuesta;

import com.API_REST.ForoHub.modelo.topico.Topico;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "respuestas")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String solucion;
    private LocalDateTime fechaCreacion; // fecha actual

    private String idUsuario;

    @ManyToOne()
    @JsonBackReference
    private Topico topico;

    public Respuesta() {
    }

    public Respuesta(RespuestaDTO DTOdatosRespuestaDTO) {
        this.solucion = DTOdatosRespuestaDTO.solucion();
        this.fechaCreacion = LocalDateTime.now();
        this.idUsuario = DTOdatosRespuestaDTO.idUsuario();
        //this.topico = DTOdatosRespuesta.idTopico(); // Lógica en service
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", solucion='" + solucion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", idUsuario='" + idUsuario + '\'' +
                ", topico=" + topico;
    }
}

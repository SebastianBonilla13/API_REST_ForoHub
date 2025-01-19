package com.API_REST.ForoHub.modelo.topico;

import com.API_REST.ForoHub.modelo.respuesta.Respuesta;

import java.util.List;

public record DatosListadoTopico(String id, String titulo, String mensaje, String fechaCreacion, List<Respuesta> respuestas) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getId().toString(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion().toString(), topico.getRespuestas());
    }
}

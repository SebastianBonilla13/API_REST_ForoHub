package com.API_REST.ForoHub.modelo.topico;

import com.API_REST.ForoHub.modelo.respuesta.Respuesta;

import java.util.List;

public record DatosRespuestaTopico(String id, String titulo, String mensaje, String fechaCreacion, String estado, String idUsuario, String curso, List<Respuesta> respuestas) {

    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId().toString(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion().toString(), topico.getStatus(), topico.getIdUsuario(), topico.getCurso(), topico.getRespuestas());
    }
}

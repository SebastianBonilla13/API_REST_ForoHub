package com.API_REST.ForoHub.modelo.respuesta;

public record DatosListadoRespuesta(String id, String solucion, String fechaCreacion, String idUsuario, String idTopico) {

    public DatosListadoRespuesta(Respuesta respuesta) {
        this(respuesta.getId().toString(), respuesta.getSolucion(), respuesta.getFechaCreacion().toString(), respuesta.getIdUsuario(), respuesta.getTopico().getId().toString());
    }
}

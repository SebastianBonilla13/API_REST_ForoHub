package com.API_REST.ForoHub.modelo.respuesta;

import jakarta.validation.constraints.NotBlank;

public record RespuestaDTO(
        @NotBlank
        String solucion,
        @NotBlank
        String idTopico,
        @NotBlank
        String idUsuario
) {
}



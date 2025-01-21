package com.API_REST.ForoHub.modelo.topico;

import jakarta.validation.constraints.NotBlank;

public record TopicoDTO(
        @NotBlank
        String idUsuario,
        @NotBlank
        String titulo,
        @NotBlank
        String curso,
        @NotBlank
        String mensaje
) {
}
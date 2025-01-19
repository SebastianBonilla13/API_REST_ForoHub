package com.API_REST.ForoHub.modelo.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopicoDTO(@NotNull Long id, String titulo, String mensaje, String estado, String idUsuario, String curso){

}

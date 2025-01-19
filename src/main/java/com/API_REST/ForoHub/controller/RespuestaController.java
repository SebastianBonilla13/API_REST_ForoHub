package com.API_REST.ForoHub.controller;


import com.API_REST.ForoHub.modelo.respuesta.DatosListadoRespuesta;
import com.API_REST.ForoHub.modelo.respuesta.RespuestaDTO;
import com.API_REST.ForoHub.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @PostMapping
    public void registrarRespuesta(@RequestBody @Valid RespuestaDTO respuestaDTO){
        respuestaService.registrarRespuesta(respuestaDTO);
    }

    @GetMapping
    public List<DatosListadoRespuesta> listarRespuesta(){
        return respuestaService.listarRespuesta();
    }

}

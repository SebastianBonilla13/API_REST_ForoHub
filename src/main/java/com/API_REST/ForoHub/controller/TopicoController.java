package com.API_REST.ForoHub.controller;

import com.API_REST.ForoHub.modelo.topico.DatosListadoTopico;
import com.API_REST.ForoHub.modelo.topico.TopicoDTO;
import com.API_REST.ForoHub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid TopicoDTO topicoDTO){
        topicoService.registrarTopico(topicoDTO);
    }

    @GetMapping
    public List<DatosListadoTopico> listarTopicos(){
        return topicoService.listarTopicos();

          // Validando de la BD
//        List<Topico> topicos = topicoRepository.findAll();
//        System.out.println("Cantidad de tópicos en la base de datos: " + topicos.size());
//        topicos.stream().forEach(System.out::println);
//        return topicos;
    }

}

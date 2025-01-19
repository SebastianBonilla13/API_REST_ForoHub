package com.API_REST.ForoHub.controller;

import com.API_REST.ForoHub.modelo.topico.DatosActualizarTopicoDTO;
import com.API_REST.ForoHub.modelo.topico.DatosListadoTopico;
import com.API_REST.ForoHub.modelo.topico.TopicoDTO;
import com.API_REST.ForoHub.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Page<DatosListadoTopico> listarTopicos(@PageableDefault(size = 10) Pageable paginacion){
        return topicoService.listarTopicos(paginacion);
          // Validando de la BD
//        List<Topico> topicos = topicoRepository.findAll();
//        System.out.println("Cantidad de tópicos en la base de datos: " + topicos.size());
//        topicos.stream().forEach(System.out::println);
//        return topicos;
    }

    @GetMapping("/{id}")
    public DatosListadoTopico respuestaTopico(@PathVariable Long id){
        return topicoService.respuestaTopico(id);
    }

    @Transactional
    @PutMapping
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopicoDTO datosActualizarTopicoDTO){
        topicoService.actualizarTopico(datosActualizarTopicoDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        topicoService.eliminarTopico(id);
    }

}

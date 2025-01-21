package com.API_REST.ForoHub.controller;

import com.API_REST.ForoHub.modelo.topico.DatosActualizarTopicoDTO;
import com.API_REST.ForoHub.modelo.topico.DatosRespuestaTopico;
import com.API_REST.ForoHub.modelo.topico.TopicoDTO;
import com.API_REST.ForoHub.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid TopicoDTO topicoDTO,
                                          UriComponentsBuilder uriComponentsBuilder){
        DatosRespuestaTopico respuestaTopico = topicoService.registrarTopico(topicoDTO);

        // URL dinámica, GET topico registrado
        URI url =uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(respuestaTopico.id()).toUri();
        return ResponseEntity.created(url).body(respuestaTopico); // 201 created
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopico>> listarTopicos(@PageableDefault(size = 10) Pageable paginacion){
        return ResponseEntity.ok(topicoService.listarTopicos(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity respuestaTopico(@PathVariable Long id){
        DatosRespuestaTopico respuestaTopico = topicoService.respuestaTopico(id);
        return ResponseEntity.ok(respuestaTopico);
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopicoDTO datosActualizarTopicoDTO){
        DatosRespuestaTopico topicoRespuesta = topicoService.actualizarTopico(datosActualizarTopicoDTO);
        return ResponseEntity.ok(topicoRespuesta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build(); // 204, nada que retornar
    }

}

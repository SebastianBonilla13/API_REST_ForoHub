package com.API_REST.ForoHub.service;

import com.API_REST.ForoHub.modelo.topico.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public DatosRespuestaTopico registrarTopico(TopicoDTO datosTopico){

        Topico topicoRegistrar = topicoRepository.save(new Topico(datosTopico));
        return new DatosRespuestaTopico(topicoRegistrar);
    }

    public Page<DatosRespuestaTopico> listarTopicos(Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosRespuestaTopico::new);
    }

    public DatosRespuestaTopico actualizarTopico(DatosActualizarTopicoDTO datosActualizarTopicoDTO){
        Topico topicoExistente = topicoRepository.findById(datosActualizarTopicoDTO.id())
                .orElseThrow(() -> new EntityNotFoundException("El topico con ID " +
                        datosActualizarTopicoDTO.id() + " no fué encontrado"));

        topicoExistente.actualizarDatos(datosActualizarTopicoDTO);

        // dato a retornar
        return new DatosRespuestaTopico(topicoExistente);
    }

    public DatosRespuestaTopico respuestaTopico(Long id) {

        Topico topicoExistente = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El topico con ID " +
                        id + " no fué encontrado"));

        return new DatosRespuestaTopico(topicoExistente);

//        Optional<Topico> topicoExistente = topicoRepository.findById(id);
//
//        if(topicoExistente.isPresent()){
//            Topico topico = topicoExistente.get();
//            return new DatosRespuestaTopico(topico);
//        }
//        System.out.println("Topico no existe en la BD");
//        return null;
    }

    public void eliminarTopico(Long id) {
        topicoRepository.deleteById(id);
//        Optional<Topico> topicoExistente = topicoRepository.findById(id);
//        if(topicoExistente.isPresent()){
//            Topico topicoEliminar = topicoExistente.get();
//            //topicoEliminar.
//            topicoRepository.delete(topicoEliminar);
//        }
    }

}

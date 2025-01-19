package com.API_REST.ForoHub.service;

import com.API_REST.ForoHub.modelo.topico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public void registrarTopico(TopicoDTO datosTopico){
        topicoRepository.save(new Topico(datosTopico));
    }

    public Page<DatosListadoTopico> listarTopicos(Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }

    public void actualizarTopico(DatosActualizarTopicoDTO datosActualizarTopicoDTO){

        System.out.println("EL ID a buscar esSss: " + datosActualizarTopicoDTO.id());
        System.out.println("EL titulo a buscar esSss: " + datosActualizarTopicoDTO.titulo());

        Optional<Topico> topicoExistente = topicoRepository.findById(datosActualizarTopicoDTO.id());

        if(topicoExistente.isPresent()){
            Topico topicoActualizar = topicoExistente.get();

            topicoActualizar.actualizarDatos(datosActualizarTopicoDTO);
        }
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

    public DatosListadoTopico respuestaTopico(Long id) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);

        if(topicoExistente.isPresent()){
            Topico topico = topicoExistente.get();
            DatosListadoTopico topicoRespuesta = new DatosListadoTopico(topico);
            return topicoRespuesta;
        }
        System.out.println("Topico no existe en la BD");
        return null;
    }
}

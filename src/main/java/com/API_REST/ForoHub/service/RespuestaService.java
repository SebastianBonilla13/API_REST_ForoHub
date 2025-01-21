package com.API_REST.ForoHub.service;

import com.API_REST.ForoHub.modelo.respuesta.DatosListadoRespuesta;
import com.API_REST.ForoHub.modelo.respuesta.Respuesta;
import com.API_REST.ForoHub.modelo.respuesta.RespuestaDTO;
import com.API_REST.ForoHub.modelo.respuesta.RespuestaRepository;
import com.API_REST.ForoHub.modelo.topico.Topico;
import com.API_REST.ForoHub.modelo.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    public void registrarRespuesta(RespuestaDTO respuestaDTO){

        Long idTopico = Long.parseLong(respuestaDTO.idTopico());
        Optional<Topico> topicoExistente = topicoRepository.findById(idTopico);

        if(topicoExistente.isPresent()){
            Topico topicoActualizar = topicoExistente.get();

            Respuesta respuesta = new Respuesta(respuestaDTO);
            respuesta.setTopico(topicoActualizar);
            respuestaRepository.save(respuesta);
        }else{
            System.out.println("NO se encontró el Topico " + idTopico + " en la base de datos ");
        }

    }

    public List<DatosListadoRespuesta> listarRespuesta(){
        return respuestaRepository.findAll().stream().map(DatosListadoRespuesta::new).toList();
    }

}

package com.API_REST.ForoHub.service;

import com.API_REST.ForoHub.modelo.topico.DatosListadoTopico;
import com.API_REST.ForoHub.modelo.topico.TopicoDTO;
import com.API_REST.ForoHub.modelo.topico.Topico;
import com.API_REST.ForoHub.modelo.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public void registrarTopico(TopicoDTO datosTopico){
        topicoRepository.save(new Topico(datosTopico));
    }

    public List<DatosListadoTopico> listarTopicos(){
        return topicoRepository.findAll().stream().map(DatosListadoTopico::new).toList();
    }

}

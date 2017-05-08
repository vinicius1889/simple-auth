package br.com.icarros.service;

import br.com.icarros.dto.UsuarioDTO;
import br.com.icarros.enums.EnumsCollectionsMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LoginService {

    @Autowired
    private HazelCastService hazelService;

    public UsuarioDTO login(String usuario, String senha) throws IOException {
        UsuarioDTO usuarioDTO = this.validaUsuarioSenha(usuario, senha);
        IMap usuariosMap = hazelService.getMap(EnumsCollectionsMap.USUARIOS);
        if(usuariosMap.containsKey(usuario)){
            return (UsuarioDTO) hazelService.get(usuariosMap,usuario,UsuarioDTO.class);
        }
        hazelService.put(usuariosMap,usuario,usuarioDTO);
        return usuarioDTO;
    }

    private UsuarioDTO validaUsuarioSenha(String usuario, String senha) throws JsonProcessingException {
        return new UsuarioDTO(usuario, senha);
    }

}

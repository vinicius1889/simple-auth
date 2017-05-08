package br.com.icarros.web;

import br.com.icarros.dto.UsuarioDTO;
import br.com.icarros.enums.EnumsCollectionsMap;
import br.com.icarros.service.HazelCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.com.icarros.service.LoginService;

import java.io.IOException;

/**
 * Created by vinicius on 07/05/17.
 */

@Controller
public class SimpleAuthController {

        @Autowired
        private LoginService loginService;

        @Autowired
        private HazelCastService hazelService;

        @ResponseBody
        @RequestMapping(value="/{key}",method = RequestMethod.GET)
        public  Object validar(@PathVariable("key") String key){
            return hazelService.getMap(EnumsCollectionsMap.USUARIOS).get(key);
        }

        @ResponseBody
        @RequestMapping(value="/",method = RequestMethod.POST)
        public  Object logar(@RequestBody UsuarioDTO login) throws IOException {
            return  loginService.login(login.getUsuario(),login.getSenha());
        }


}

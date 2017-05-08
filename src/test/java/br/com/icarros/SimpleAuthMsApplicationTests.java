package br.com.icarros;

import br.com.icarros.dto.UsuarioDTO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleAuthMsApplicationTests {

	@Autowired
	private TestRestTemplate rest;


	@Test
	public void loginTest() {
		UsuarioDTO user =  new UsuarioDTO("vinicius", "secret");
		UsuarioDTO usuarioDTO = rest.postForObject("/", user, UsuarioDTO.class);
		System.out.println("usuarioDTO.getUsuario() = " + usuarioDTO.getUsuario());
	}

	@Test
	@Ignore
	public void loginGetTests(){
		UsuarioDTO usuarioDTO = rest.getForObject("/{key}", UsuarioDTO.class, "vinicius");
		System.out.println("usuarioDTO = " + usuarioDTO.getUsuario());
	}


}

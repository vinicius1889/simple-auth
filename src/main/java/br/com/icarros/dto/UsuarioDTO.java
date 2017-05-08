package br.com.icarros.dto;


import java.io.Serializable;

public class UsuarioDTO implements Serializable{

    private String usuario;

    private String senha;


    public UsuarioDTO(){}
    public UsuarioDTO(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

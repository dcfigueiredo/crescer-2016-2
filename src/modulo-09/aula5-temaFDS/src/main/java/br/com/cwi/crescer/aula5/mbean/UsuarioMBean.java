/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.UsuarioBean;
import br.com.cwi.crescer.aula5.entity.Usuario;
import br.com.cwi.crescer.aula5.utils.FacesUtils;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean
@ViewScoped
public class UsuarioMBean implements Serializable {

    @EJB
    private UsuarioBean bean;

    private Usuario usuario;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void cadastrar() {
        if (!FacesUtils.getContext().isValidationFailed()) {
            bean.getDao().insert(usuario);
            init();
        }
    }

}

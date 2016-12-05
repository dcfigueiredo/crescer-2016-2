package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.UsuarioBean;
import br.com.cwi.crescer.aula5.dao.UsuarioDao;
import br.com.cwi.crescer.aula5.entity.Usuario;
import static br.com.cwi.crescer.aula5.utils.UserDetails.USER_AUTH;

import br.com.cwi.crescer.aula5.filters.User;
import br.com.cwi.crescer.aula5.utils.CriptografiaUtils;
import br.com.cwi.crescer.aula5.utils.FacesUtils;
import br.com.cwi.crescer.aula5.utils.UserDetails;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class LoginMBean extends AbstractMBean<Usuario, Long, UsuarioDao, UsuarioBean> {

    @EJB
    private UsuarioBean bean;

    private User user;

    private String email, password;

    @PostConstruct
    public void init() {
        this.user = new User();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoggedUsername() {
        final UserDetails userDetails;
        userDetails = (UserDetails) FacesUtils.getSession().getAttribute(USER_AUTH);
        return userDetails == null ? null : userDetails.getUsername();
    }

    public String login() {
        String senhaCriptografada = CriptografiaUtils.converterStringParaMd5(password);
        Usuario usuarioLogado = bean.getDao().encontrarUsuarioLogado(email, senhaCriptografada);
        if (usuarioLogado != null) {
            FacesUtils.getSession().setAttribute(USER_AUTH, this.user);
            return "index";
        }
        return "login";
    }

    public String logout() {
        FacesUtils.getSession().invalidate();
        return "logout";
    }

    @Override
    public UsuarioBean getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpar() {
        this.setEntity(new Usuario());
        this.setList(this.getBean().findAll());
    }
}

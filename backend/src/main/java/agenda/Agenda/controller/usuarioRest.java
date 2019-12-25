package agenda.Agenda.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import agenda.Agenda.model.entity.Usuario;
import agenda.Agenda.service.usuarioService;

@RestController
@RequestMapping(value = { "/usuarios" })
public class usuarioRest {

    @Autowired
    usuarioService usuarioservice;

    /* Listar todos os usuários */
    @GetMapping({ "", "/" })
    public List<Usuario> getUsuarios(HttpSession httpSession) {

        return usuarioservice.listarUsuarios();
    }

    /* Procurar usuario por Id */
    @GetMapping("/{id}")
    public Usuario getUsuario(HttpSession httpSession, @PathVariable(value = "id") Long id) {

        return usuarioservice.getById(id);
    }

    /* Criar novo usuario */
    @PostMapping({ "", "/" })
    @ResponseStatus(HttpStatus.CREATED)
    public void criarUsuario(@RequestBody Usuario u) {

        usuarioservice.criarUsuario(u);
    }

    /* Excuir usuario por Id */
    @DeleteMapping("/{id}")
    public void excluiUsuario(HttpSession httpSession, @PathVariable(value = "id") long id) {

        usuarioservice.excluirUsuario(id);
    }

}
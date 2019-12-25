package agenda.Agenda.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import agenda.Agenda.model.entity.Contato;
import agenda.Agenda.service.contatoService;

@RestController
@RequestMapping(value = { "/contatos" })
public class contatoRest {

    @Autowired
    contatoService contatoservice;

    /* Listar todos os contatos */
    @GetMapping({ "", "/" })
    public List<Contato> getContatos(HttpSession httpSession) {

        return contatoservice.listarContatos();
    }

    /* Procurar contato por Id */
    @GetMapping("/{id}")
    public Contato getContato(HttpSession httpSession, @PathVariable(value = "id") Long id) {

        return contatoservice.getById(id);
    }

    /* Criar novo contato */
    @PostMapping({ "", "/" })
    @ResponseStatus(HttpStatus.CREATED)
    public void criarContato(@RequestBody Contato u) {

        contatoservice.criarContato(u);
    }

    /* Excuir contato por Id */
    @DeleteMapping("/{id}")
    public void excluiContato(HttpSession httpSession, @PathVariable(value = "id") long id) {

        contatoservice.excluirContato(id);
    }

}
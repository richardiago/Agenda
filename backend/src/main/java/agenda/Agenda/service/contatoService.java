package agenda.Agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agenda.Agenda.model.dao.contatoDAO;
import agenda.Agenda.model.entity.Contato;

@Service
public class contatoService {

    @Autowired
    contatoDAO contatodao;

    /* Listar usuários */
    public List<Contato> listarContatos() {
        return contatodao.findAll();
    }

    /* Procurar contato por Id */
    public Contato getById(Long id) {
        Optional<Contato> result = contatodao.findById(id);
        if (!result.isPresent())
            return null;

        return result.get();
    }

    /* Criar novo contato */
    public void criarContato(Contato u) {
        contatodao.save(u);
    }

    /* Excluir contato por Id */
    public void excluirContato(long id) {
        contatodao.deleteById(id);
    }

}

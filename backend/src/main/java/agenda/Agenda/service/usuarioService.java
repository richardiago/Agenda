package agenda.Agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agenda.Agenda.model.dao.usuarioDAO;
import agenda.Agenda.model.entity.Usuario;

@Service
public class usuarioService {

    @Autowired
    usuarioDAO usuariodao;

    /* Listar usuários */
    public List<Usuario> listarUsuarios() {
        return usuariodao.findAll();
    }

    /* Procurar usuario por Id */
    public Usuario getById(Long id) {
        Optional<Usuario> result = usuariodao.findById(id);
        if (!result.isPresent())
            return null;

        return result.get();
    }

    /* Criar novo usuario */
    public void criarUsuario(Usuario u) {
        usuariodao.save(u);
    }

    /* Excluir usuario por Id */
    public void excluirUsuario(long id) {
        usuariodao.deleteById(id);
    }

}
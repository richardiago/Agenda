package agenda.Agenda.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agenda.Agenda.model.entity.Usuario;

@Repository
public interface usuarioDAO extends JpaRepository<Usuario, Long> {

}
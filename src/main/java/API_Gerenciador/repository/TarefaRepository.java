package API_Gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import API_Gerenciador.model.Tarefa;

@Repository
/**
 * TarefaRepository
 */
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

    
}

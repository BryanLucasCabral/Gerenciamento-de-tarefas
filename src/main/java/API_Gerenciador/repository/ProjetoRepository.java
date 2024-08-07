package API_Gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import API_Gerenciador.model.Projeto;

/**
 * ProjetoRepository
 */
@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    
}
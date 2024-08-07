package API_Gerenciador.model;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping
@Entity(name = "tb_projeto")
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROJETO")
    private Long id;

    @Column(name = "NOME_PROJETO", nullable = false)
    private String nome;

    @Column(name = "DESCRICAO_PROJETO",columnDefinition = "TEXT")
    private String descricao;

    @OneToMany
    @JoinTable(name = "tb_projetos_tarefas",joinColumns = @JoinColumn(name = "ID_PROJETO"), inverseJoinColumns = @JoinColumn(name = "ID_TAREFA"))
    private List<Tarefa> tarefas;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_RESPONSAVEL")
    private Usuario responsavel;
}

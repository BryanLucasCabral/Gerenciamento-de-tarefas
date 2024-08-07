package API_Gerenciador.model;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonFormat;

import API_Gerenciador.constants.Prioriadade;
import API_Gerenciador.constants.StatusTarefa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping
@Entity(name = "tb_tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREFA")
    private Long id;

    @Column(name = "TITULO_TAREFA", nullable = false)
    private String titulo;

    @Column(name = "DESCRICAO_TAREFA", nullable = false)
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DT_CRIACAO_TAREFA", nullable = false)
    private LocalDate dataCriacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DT_CONCLUSAO_TAREFA", nullable = false)
    private LocalDate dataConclusao;

    @Column(name = "PRIORIDADE_TAREFA", nullable = false)
    private Prioriadade prioriadade;

    @Column(name = "STATUS_TAREFA", nullable = false)
    private StatusTarefa status;
}

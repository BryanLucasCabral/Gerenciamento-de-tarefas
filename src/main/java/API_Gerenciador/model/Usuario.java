package API_Gerenciador.model;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonFormat;

import API_Gerenciador.constants.StatusUsuario;
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
@Entity(name = "tb_usuarios")
@RequestMapping
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO", nullable = false)
    private long id;

    
    @Column(name = "NOME_USUARIO", unique = false, nullable = false)
    private String nome;

    @Column(name = "CPF_USUARIO", nullable = false, unique = false)
    private String cpf;

    @Column(name = "EMAIL_USUARIO", nullable = false, unique = false)
    private String email;

    @Column(name = "SENHA_USUARIO", nullable = false, unique = false)
    private String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DATA_NASC_USARIO", nullable = false, unique = false)
    private LocalDate dataNascimento;

    @Column(name = "STATUS_USUARIO", nullable = false, unique = false)
    private StatusUsuario status;
}

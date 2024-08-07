package API_Gerenciador.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import API_Gerenciador.dto.UsuarioDTO;
import API_Gerenciador.exceptions.CpfJaCadastradoException;
import API_Gerenciador.exceptions.EmailJaCadastradoException;
import API_Gerenciador.model.Usuario;
import API_Gerenciador.repository.UsuarioRepository;

@Service
public class UsuarioServices {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario (Usuario usuario){
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCpf(usuario.getCpf());
    
        if (usuarioOpt.isPresent()) {
            throw new CpfJaCadastradoException("Já existe usuário com o cpf cadastrado!");
        }

        usuarioOpt = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioOpt.isPresent()) {
            throw new EmailJaCadastradoException("Já existe usuário com o email cadastrado!");
        }

        return usuarioRepository.save(usuario);
    }

    public Page<UsuarioDTO> listarUsuarios(Pageable paginacao){
       return usuarioRepository.findAll(paginacao).map(usuario -> usuario.toDTO());
    }

    public UsuarioDTO buscarUsuarioPeloId(Long id){
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get().toDTO();
        }

        return null;
    }

    public UsuarioDTO buscarUsuarioPeloCpf(String cpf){
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCpf(cpf);

        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get().toDTO();
        }

        return null;
    }

    public List<UsuarioDTO> filtarUsuariosPeloNome(String nome){
        List<Usuario> usuarios = usuarioRepository.findByNomeContains(nome);

        return usuarios.stream().map(Usuario::toDTO).toList();
    }

    public List<UsuarioDTO> filtrarUsuariosCujoNomeComecamCom(String nome){
        List<Usuario> usuarios = usuarioRepository.findByNomeLike(nome);

        return usuarios.stream().map(Usuario::toDTO).toList();
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario atualizarUsuario(Long id, Usuario dadosUsuario){
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            usuario.setCpf(dadosUsuario.getCpf());
            usuario.setNome(dadosUsuario.getNome());
            usuario.setDataNascimento(dadosUsuario.getDataNascimento());
            usuario.setEmail(dadosUsuario.getEmail());
            usuario.setSenha(dadosUsuario.getSenha());
            usuario.setStatus(dadosUsuario.getStatus());

            return usuarioRepository.save(usuario);
        }

        return null;
    }
}

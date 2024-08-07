package API_Gerenciador.exceptions;

public class CpfJaCadastradoException extends RuntimeException {
    public CpfJaCadastradoException(String mensagem){
        super(mensagem);
    }
}

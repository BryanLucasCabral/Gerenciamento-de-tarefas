package API_Gerenciador.exceptions;

public class EmailJaCadastradoException extends RuntimeException{
    public EmailJaCadastradoException(String mensagem){
        super(mensagem);
    }
}

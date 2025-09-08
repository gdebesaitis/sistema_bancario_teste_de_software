package negocio;

/**
 * Exce��o a ser lan�ada quando a idade de um poss�vel novo cliente n�o for aceita.
 * 
 * 
 */
public class IdadeNaoPermitidaException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String MSG_IDADE_INVALIDA = 
        "A idade do cliente precisa estar entre 18 e 65 anos.";

    // Construtor padrão: usa a mensagem fixa
    public IdadeNaoPermitidaException() {
        super("A idade do cliente precisa estar entre 18 e 65 anos.");
    }

    // Construtor alternativo: aceita mensagem personalizada
    public IdadeNaoPermitidaException(String msg) {
        super(msg);
    }

    // Getter caso alguém precise recuperar a mensagem padrão
    public String getMensagemPadrao() {
        return MSG_IDADE_INVALIDA;
    }
}


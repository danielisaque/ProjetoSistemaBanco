package projetosistemabancario;

public class ContaNaoExisteException extends Throwable {
    public ContaNaoExisteException(String msg) {
        super(msg);
    }
}
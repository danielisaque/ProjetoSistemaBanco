package projetosistemabancario;

import java.util.Collection;
import java.util.List;

public interface SistemaBancario {
    boolean cadastrarConta(String cpf, String numeroConta, String nome,
                           String endereco, double saldo, String chavePix);
    Collection<Conta> pesquisarConta(String numeroConta);
    boolean removerConta(String numeroConta);
    boolean depositar(String numeroConta, double valor);
    boolean transferir(String numeroContaOrigem, String numeroContaDestino, double valor);
    boolean sacar(String numeroConta, double valor);
    boolean pix(String chavePixOrigem, String chavePixDestino, double valor);
    String extrato(String numeroConta);
    public boolean verificarAtividadeConta(String numeroConta);
}


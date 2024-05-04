package projetosistemabancario;

import java.util.ArrayList;

public interface SistemaBancario {
    public void criarConta(String nome, String cpf, String endereco);
    public Conta pesquisarConta(int numeroConta);
    public void encerrarConta(int numeroConta);
    public void deposito(int numeroConta, double valor);
    public void saque(int numeroConta, double valor);
    public ArrayList<String> extrato(int numeroConta);
    public double consultarSaldo(int numeroConta);
}

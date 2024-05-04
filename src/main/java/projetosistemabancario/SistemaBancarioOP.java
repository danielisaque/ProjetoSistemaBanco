package projetosistemabancario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaBancarioOP {
    private Map<String, Conta> contas;

    public SistemaBancarioOP() {
        this.contas = new HashMap<>();
    }

    public boolean cadastrarConta(String cpf, String numeroConta, String nome, String endereco, double saldo, String chavePix) {
        if(!this.contas.containsKey(numeroConta)){
            this.contas.put(numeroConta, (new Conta(cpf, numeroConta, nome, endereco, saldo, chavePix)));
            return true;
        } else {
            return false;
        }
    }

    public List<Conta> pesquisarConta(String numeroConta){
        List<Conta> contasExistentes = new ArrayList<>();
        for(Conta conta : this.contas.values()) {
            if(conta.getNumeroConta().equals(numeroConta)) {
                contasExistentes.add(conta);
            }
        }
        return contasExistentes;
    }

    public boolean removerConta(String numeroConta){
        Conta contaRemovida = this.contas.remove(numeroConta);
        return contaRemovida != null;
    }

    public boolean depositar(String numeroConta, double valor) {
        Conta conta = this.contas.get(numeroConta);
        if(conta != null){
            conta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean transferir(String numeroContaOrigem, String numeroContaDestino, double valor) {
        Conta contaOrigem = this.contas.get(numeroContaOrigem);
        Conta contaDestino = this.contas.get(numeroContaDestino);

        if (contaOrigem != null && contaDestino != null) {
            return contaOrigem.transferir(contaDestino, valor);
        } else {
            return false;
        }
    }

    public boolean sacar(String numeroConta, double valor) {
        Conta conta = this.contas.get(numeroConta);
        if (conta != null) {
            return conta.sacar(valor);
        } else {
            return false;
        }
    }

    public boolean pix(String chavePixOrigem, String chavePixDestino, double valor) {
        // Implementação do PIX, pode variar dependendo das regras de negócio específicas
        // Neste exemplo, assumimos que o PIX é apenas uma transferência entre contas utilizando suas chaves PIX como identificadores
        Conta contaOrigem = null;
        Conta contaDestino = null;

        for (Conta conta : this.contas.values()) {
            if (conta.getChavePix().equals(chavePixOrigem)) {
                contaOrigem = conta;
            }
            if (conta.getChavePix().equals(chavePixDestino)) {
                contaDestino = conta;
            }
        }

        if (contaOrigem != null && contaDestino != null) {
            return contaOrigem.transferir(contaDestino, valor);
        } else {
            return false; // Alguma das chaves PIX não corresponde a uma conta válida
        }
    }

    public String extrato(String numeroConta) {
        Conta conta = this.contas.get(numeroConta);
        if (conta != null) {
            return conta.gerarExtrato();
        } else {
            return "Conta não encontrada";
        }
    }

}

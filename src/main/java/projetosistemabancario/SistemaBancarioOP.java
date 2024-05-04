package projetosistemabancario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaBancarioOP implements SistemaBancario {
    private Map<String, Conta> contas;

    public SistemaBancarioOP() {
        this.contas = new HashMap<>();
    }

    @Override
    public boolean cadastrarConta(String cpf, String numeroConta, String nome, String endereco, double saldo, String chavePix) {
        if(!this.contas.containsKey(numeroConta)){
            this.contas.put(numeroConta, new Conta(cpf, numeroConta, nome, endereco, saldo, chavePix));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Conta> pesquisarConta(String numeroConta){
        List<Conta> contasExistentes = new ArrayList<>();
        for(Conta conta : this.contas.values()) {
            if(conta.getNumeroConta().equals(numeroConta)) {
                contasExistentes.add(conta);
            }
        }
        return contasExistentes;
    }

    @Override
    public boolean removerConta(String numeroConta){
        Conta contaRemovida = this.contas.remove(numeroConta);
        return contaRemovida != null;
    }

    @Override
    public boolean depositar(String numeroConta, double valor) {
        Conta conta = this.contas.get(numeroConta);
        if(conta != null){
            conta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean transferir(String numeroContaOrigem, String numeroContaDestino, double valor) {
        Conta contaOrigem = this.contas.get(numeroContaOrigem);
        Conta contaDestino = this.contas.get(numeroContaDestino);

        if (contaOrigem != null && contaDestino != null) {
            return contaOrigem.transferir(contaDestino, valor);
        } else {
            return false;
        }
    }

    @Override
    public boolean sacar(String numeroConta, double valor) {
        Conta conta = this.contas.get(numeroConta);
        if (conta != null) {
            return conta.sacar(valor);
        } else {
            return false;
        }
    }

    @Override
    public boolean pix(String chavePixOrigem, String chavePixDestino, double valor) {
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
            return false;
        }
    }

    @Override
    public String extrato(String numeroConta) {
        Conta conta = this.contas.get(numeroConta);
        if (conta != null) {
            return conta.gerarExtrato();
        } else {
            return "Conta não encontrada";
        }
    }

    public boolean verificarAtividadeConta(String numeroConta) {
        List<Conta> contasEncontradas = pesquisarConta(numeroConta);
        if (contasEncontradas.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}

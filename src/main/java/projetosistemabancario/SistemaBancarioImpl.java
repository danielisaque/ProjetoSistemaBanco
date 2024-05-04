package projetosistemabancario;

import java.util.*;

public class SistemaBancarioImpl implements SistemaBancario {
    private Map<String, Conta> contas;
    private GravadorDeArquivos gravador = new GravadorDeArquivos();

    public SistemaBancarioImpl() {
        this.contas = new HashMap<>();
    }

    public void salvarDados(){
        try {
            this.gravador.salvarConta(this.contas);
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
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
    public Collection<Conta> pesquisarConta(String numeroConta) {
        Collection<Conta> contasExistentes = new ArrayList<>();
        for (Conta c: this.contas.values()){
            if (Objects.equals(c.getNumeroConta(), numeroConta)){
                contasExistentes.add(c);
            }
        }
        return contasExistentes;
    }

    @Override
    public boolean removerConta(String numeroConta) {
        if (this.contas.containsKey(numeroConta)){
            this.contas.remove(numeroConta);
            return true;
        } else{
            return false;
        }
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

    // Método que verifica a situação da conta (ativa ou inativa) com uso de
    // expressão lambda.
    public boolean verificarAtividadeConta(String numeroConta) {
        return !pesquisarConta(numeroConta).isEmpty();
    }


}

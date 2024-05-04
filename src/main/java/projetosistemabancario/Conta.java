package projetosistemabancario;

import java.lang.reflect.GenericDeclaration;
import java.util.Objects;

public class Conta {
    private String cpf;
    private String numeroConta;
    private String nome;
    private String endereco;
    private double saldo;
    private String chavePix;

    public Conta(String cpf, String numeroConta, String nome, String endereco, double saldo, String chavePix){
        this.cpf = cpf;
        this.numeroConta = numeroConta;
        this.nome = nome;
        this.endereco = endereco;
        this.saldo = 0.0;
        this.chavePix = "";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getChavePix() {
        return this.chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String gerarExtrato() {
        return "Extrato da Conta:\nCPF: " + cpf + "\nNúmero da Conta: " + numeroConta + "\nNome: " + nome + "\nEndereço: " + endereco + "\nSaldo: " + saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        if (!Objects.equals(cpf, conta.cpf)) return false;
        if (!Objects.equals(numeroConta, conta.numeroConta)) return false;
        if (!Objects.equals(nome, conta.nome)) return false;
        return Objects.equals(endereco, conta.endereco);
    }

    @Override
    public int hashCode() {
        int result = cpf != null ? cpf.hashCode() : 0;
        result = 31 * result + (numeroConta != null ? numeroConta.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "cpf='" + cpf + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public void depositar(double valor){
        this.saldo = saldo + valor;
    }

    public boolean sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        } else {
            return false; // Saldo insuficiente
        }
    }

    public boolean transferir(Conta destino, double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            destino.depositar(valor);
            return true;
        } else {
            return false; // Saldo insuficiente
        }
    }
}
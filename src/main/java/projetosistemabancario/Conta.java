package projetosistemabancario;

import java.util.Objects;

public class Conta {
    private String tipoConta;
    private int numeroConta;

    public Conta(String tipoConta, int numeroConta){
        this.tipoConta = tipoConta;
        this.numeroConta = numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        if (numeroConta != conta.numeroConta) return false;
        return Objects.equals(tipoConta, conta.tipoConta);
    }

    @Override
    public int hashCode() {
        int result = tipoConta != null ? tipoConta.hashCode() : 0;
        result = 31 * result + numeroConta;
        return result;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "tipoConta='" + tipoConta + '\'' +
                ", numeroConta=" + numeroConta +
                '}';
    }
}

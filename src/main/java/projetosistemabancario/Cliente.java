package projetosistemabancario;

import java.util.Objects;

public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;

    public Cliente(String nome, String cpf, String endereco) {
        this.nome =nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Cliente(){
        this.nome = "";
        this.cpf = "";
        this.endereco = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (!Objects.equals(nome, cliente.nome)) return false;
        if (!Objects.equals(cpf, cliente.cpf)) return false;
        return Objects.equals(endereco, cliente.endereco);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}

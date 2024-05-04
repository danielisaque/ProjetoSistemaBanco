package projetosistemabancario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistirDados {
    private final String ARQUIVO_CONTAS = "contas.txt";

    // Método para adicionar uma conta ao arquivo
    public void cadastrarConta(Conta conta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_CONTAS, true))) {
            writer.write(conta.getCpf() + "," + conta.getNumeroConta() + "," + conta.getNome() + "," + conta.getChavePix() + "," + conta.getSaldo());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obter todas as contas do arquivo
    public List<Conta> obterTodasContas() {
        List<Conta> contas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_CONTAS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String cpf = partes[0];
                String numeroConta = partes[1];
                String nome = partes[2];
                String chavePix = partes[3];
                double saldo = Double.parseDouble(partes[4]);
                Conta conta = new Conta("12332123112", "", "" , "",3412, "chespinho@gmail.com" );
                contas.add(conta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contas;
    }
}
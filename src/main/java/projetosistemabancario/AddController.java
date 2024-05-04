package projetosistemabancario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddController implements ActionListener {
    private SistemaBancario sistema;
    private JFrame janelaPrincipal;

    public AddController(SistemaBancario sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e) {
        String cpf = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o cpf da conta? ");
        String numeroConta = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o número da conta?");
        String nome = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o nome do titular? ");
        String endereco = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o endereco do titular? ");
        double saldo = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual valor deseja depositar inicialmente? "));
        String chavePix = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual a chave pix? ");
        boolean cadastrou = sistema.cadastrarConta(cpf, numeroConta, nome, endereco, saldo, chavePix);
        if (cadastrou){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Conta cadastrado");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Conta não foi cadastrada. " +
                            "Verifique se já não existia");
        }
    }
}
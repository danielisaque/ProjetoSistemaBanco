package projetosistemabancario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddController implements ActionListener {
    private SistemaBancario contas;
    private JFrame janelaPrincipal;

    public AddController(SistemaBancario contas, JFrame janela) {
        this.contas = contas;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e) {
        String cpf = JOptionPane.showInputDialog(janelaPrincipal,
                "INFORME O CPF DO TITULAR: ");
        String numeroConta = JOptionPane.showInputDialog(janelaPrincipal,
                "DIGITE O NÚMERO DA CONTA: ");
        String nome = JOptionPane.showInputDialog(janelaPrincipal,
                "INFORME O NOME DO TITULAR DA CONTA: ");
        String endereco = JOptionPane.showInputDialog(janelaPrincipal,
                "INFORME O ENDEREÇO DO TITULAR: ");
        double saldo = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal,
                "QUAL O VALOR QUE DESEJA DEPOSITAR INICIALMENTE: "));
        String chavePix = JOptionPane.showInputDialog(janelaPrincipal,
                "INFORME A CHAVE PIX: ");
        boolean cadastrou = contas.cadastrarConta(cpf, numeroConta, nome, endereco, saldo, chavePix);
        if (cadastrou){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Conta cadastrada");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Conta não foi cadastrada. " +
                            "Verifique se já não existia");
        }
    }
}
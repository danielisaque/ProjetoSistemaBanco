package projetosistemabancario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveController implements ActionListener {
    private SistemaBancarioImpl sistema;
    private JFrame janelaPrincipal;

    public RemoveController(SistemaBancarioImpl sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e) {
        String contaARemover = JOptionPane.showInputDialog(janelaPrincipal,
                "DIGITE O NUMERO DA CONTA QUE DESEJA REMOVER: ");
        boolean removeu = sistema.removerConta(contaARemover);
        if (removeu) {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "CONTA REMOVIDA COM SUCESSO!");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "A CONTA NÃO FOI ENCONTRADA" +
                            "A OPERAÇÃO NÃO FOI REALIZADA");
        }
    }
}
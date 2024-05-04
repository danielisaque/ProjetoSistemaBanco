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
                "Digite o número da conta que deseja excluir: ");
        boolean removeu = sistema.removerConta(contaARemover);
        if (removeu) {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Conta removida com sucesso");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Conta não foi encontrada. " +
                            "A operação não realizada");
        }
    }
}
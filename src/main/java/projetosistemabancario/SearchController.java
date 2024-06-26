package projetosistemabancario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class SearchController implements ActionListener {
    private SistemaBancario sistema;
    private JFrame janelaPrincipal;

    public SearchController(SistemaBancarioImpl pesquisarConta, JFrame janelaPrincipal) {
        this.sistema = pesquisarConta;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String numeroConta = JOptionPane.showInputDialog(janelaPrincipal,
                "DIGITE O NUMERO DA CONTA QUE DESEJA PESQUISAR: ");
        Collection<Conta> pesquisarConta = sistema.pesquisarConta(numeroConta);
        if (pesquisarConta.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "CONTA ENCONTRADA: ");
            for (Conta c : pesquisarConta){
                JOptionPane.showMessageDialog(janelaPrincipal, c.toString());
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Não foi encontrada nenhuma conta!");
        }
    }
}

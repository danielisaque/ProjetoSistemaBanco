package projetosistemabancario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class SearchController implements ActionListener {
    private SistemaBancarioImpl sistema;
    private JFrame janelaPrincipal;

    public SearchController(SistemaBancarioImpl sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cpf = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o cpf da conta a pesquisar?");
        Collection<Conta> contas = sistema.pesquisarConta(cpf);
        if (contas.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Aniversariantes encontrados:");
            for (Conta c : sistema){
                JOptionPane.showMessageDialog(janelaPrincipal, c.toString());
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Não foi encontrado nenhum aniversariante nesta data");
        }
    }
}

package projetosistemabancario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;

public class SearchController implements ActionListener {
    private SistemaBancarioImpl pesquisarConta;
    private JFrame janelaPrincipal;

    public SearchController(SistemaBancarioImpl pesquisarConta, JFrame janela) {
        this.pesquisarConta = pesquisarConta;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String numeroConta = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o cpf da conta a pesquisar?");
        List<Conta> contasExistentes = pesquisarConta.pesquisarConta(numeroConta);
        if (contasExistentes.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Aniversariantes encontrados:");
            for (Conta c : contasExistentes){
                JOptionPane.showMessageDialog(janelaPrincipal, c.toString());
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Não foi encontrado nenhum aniversariante nesta data");
        }
    }
}

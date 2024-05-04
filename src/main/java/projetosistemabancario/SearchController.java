package projetosistemabancario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;

public class SearchController implements ActionListener {
    private SistemaBancario sistema;
    private JFrame janelaPrincipal;

    public SearchController(SistemaBancario sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e) {
        String contaAProcurar = JOptionPane.showInputDialog(janelaPrincipal,
                "Digite o cpf da conta que você deseja procurar: ");
        Collection<Conta> contasEncontradas = sistema.pesquisarConta(contaAProcurar);
        if (contasEncontradas.size() > 0) {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Conta encontrada: ");
            for (Conta contas : contasEncontradas) {
                JOptionPane.showMessageDialog(janelaPrincipal, contas.toString());
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Não foi encontrada nenhuma conta com esse cpf.");
        }
    }
}

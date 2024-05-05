package projetosistemabancario;

import javax.swing.*;
import java.awt.*;

public class SistemaBancarioGUI extends JFrame {
    JLabel linha1;
    ImageIcon logoImg = new ImageIcon("./imagens/LDDBANK-LOGO.png");
    JButton botaoAdicionar, botaoPesquisar, botaoRemover;
    SistemaBancarioImpl sistema = new SistemaBancarioImpl();

    public SistemaBancarioGUI() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setTitle("LDD Bank");
        setSize(1280, 720);
        int x = (d.width - getWidth()) / 2;
        int y = (d.height - getHeight()) / 2;
        setLocation(x, y);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        linha1 = new JLabel(logoImg, JLabel.CENTER);
        botaoAdicionar = new JButton("CADASTRAR CONTA");
        botaoAdicionar.addActionListener(new AddController(sistema, this));
        botaoPesquisar = new JButton("PESQUISAR CONTA");
        botaoPesquisar.addActionListener(new SearchController(sistema, this));
        botaoRemover = new JButton("REMOVER CONTA");
        botaoRemover.addActionListener(new RemoveController(sistema, this));
        getContentPane().setLayout(new GridLayout(5,1));
        getContentPane().add(linha1);
        getContentPane().add(botaoAdicionar);
        getContentPane().add(botaoPesquisar);
        getContentPane().add(botaoRemover);
    }

    public static void main(String [] args){
        JFrame janela = new SistemaBancarioGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
package projetosistemabancario;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSistemaBancario {

    SistemaBancario sistema;

    @BeforeEach
    public void setup() {
        sistema = new SistemaBancarioImpl();
    }

    @Test
    public void testaCadastrarConta() {
        boolean cadastrou = sistema.cadastrarConta("12345678900", "001", "João", "Rua A, 123", 1000.0, "joao123");
        assertTrue(cadastrou);
    }

    @Test
    public void testaPesquisarConta() {
        sistema.cadastrarConta("65468414772", "2451547",
                "Pedro", "Rua Brigadeiro de lima", 1000.0, "pedro123");
        assertTrue(sistema.pesquisarConta("001").size() == 1);
    }

    @Test
    public void testaRemoverConta() {
        sistema.cadastrarConta("65468414772", "2451547",
                "Pedro", "Rua Brigadeiro de lima", 1000.0, "pedro123");
        boolean removeu = sistema.removerConta("001");
        assertTrue(removeu);
    }

    @Test
    public void testaDepositar() {
        sistema.cadastrarConta("65468414772", "2451547",
                "Pedro", "Rua Brigadeiro de lima", 1000.0, "pedro123");
        boolean depositou = sistema.depositar("001", 500.0);
        assertTrue(depositou);
    }

    @Test
    public void testaSacar() {
        sistema.cadastrarConta("65468414772", "2451547",
                "Pedro", "Rua Brigadeiro de lima", 1000.0, "pedro123");
        boolean sacou = sistema.sacar("001", 500.0);
        assertTrue(sacou);
    }
}

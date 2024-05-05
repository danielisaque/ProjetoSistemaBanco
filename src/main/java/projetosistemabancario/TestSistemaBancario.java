package projetosistemabancario;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class TestSistemaBancario {

    SistemaBancario sistema;

    @BeforeEach
    public void setup() {
        sistema = new SistemaBancarioImpl();
    }

    @Test
    public void testCadastrarConta() {
        boolean cadastrou = sistema.cadastrarConta("12345678900", "001", "João", "Rua A, 123", 1000.0, "joao123");
        assertTrue(cadastrou);
    }

    @Test
    public void testPesquisarConta() {
        sistema.cadastrarConta("12345678900", "001", "João", "Rua A, 123", 1000.0, "joao123");
        Collection<Conta> contas = sistema.pesquisarConta("001");
        assertEquals(1, contas.size());
    }

    @Test
    public void testRemoverConta() {
        sistema.cadastrarConta("12345678900", "001", "João", "Rua A, 123", 1000.0, "joao123");
        boolean removeu = sistema.removerConta("001");
        assertTrue(removeu);
    }

    @Test
    public void testDepositar() {
        sistema.cadastrarConta("12345678900", "001", "João", "Rua A, 123", 1000.0, "joao123");
        boolean depositou = sistema.depositar("001", 500.0);
        assertTrue(depositou);
    }

    @Test
    public void testSacar() {
        sistema.cadastrarConta("12345678900", "001", "João", "Rua A, 123", 1000.0, "joao123");
        boolean sacou = sistema.sacar("001", 500.0);
        assertTrue(sacou);
    }
}

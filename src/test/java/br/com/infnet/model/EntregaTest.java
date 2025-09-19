package br.com.infnet.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntregaTest {

    @Test
    @DisplayName("Deve criar uma Entrega com sucesso quando os dados são válidos")
    void deveCriarEntregaComDadosValidos() {
        assertDoesNotThrow(() -> {
            new Entrega("Rua Teste, 123", 10.0, "EXP", "Destinatário Teste");
        });
    }

    @Test
    @DisplayName("Deve lançar exceção para peso negativo ou zero")
    void deveLancarExcecaoParaPesoInvalido() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Entrega("Rua Teste, 123", -5.0, "EXP", "Destinatário Teste");
        });
        assertEquals("Peso deve ser positivo.", exception.getMessage());

        IllegalArgumentException exceptionZero = assertThrows(IllegalArgumentException.class, () -> {
            new Entrega("Rua Teste, 123", 0.0, "EXP", "Destinatário Teste");
        });
        assertEquals("Peso deve ser positivo.", exceptionZero.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção para endereço nulo ou vazio")
    void deveLancarExcecaoParaEnderecoInvalido() {
        IllegalArgumentException exceptionNull = assertThrows(IllegalArgumentException.class, () -> {
            new Entrega(null, 10.0, "EXP", "Destinatário Teste");
        });
        assertEquals("Endereço não pode ser nulo ou vazio.", exceptionNull.getMessage());

        IllegalArgumentException exceptionEmpty = assertThrows(IllegalArgumentException.class, () -> {
            new Entrega("  ", 10.0, "EXP", "Destinatário Teste");
        });
        assertEquals("Endereço não pode ser nulo ou vazio.", exceptionEmpty.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção para tipo de frete nulo ou vazio")
    void deveLancarExcecaoParaTipoFreteInvalido() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Entrega("Rua Teste, 123", 10.0, null, "Destinatário Teste");
        });
        assertEquals("Tipo de frete não pode ser nulo ou vazio.", exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção para destinatário nulo ou vazio")
    void deveLancarExcecaoParaDestinatarioInvalido() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Entrega("Rua Teste, 123", 10.0, "EXP", " ");
        });
        assertEquals("Destinatário não pode ser nulo ou vazio.", exception.getMessage());
    }
}

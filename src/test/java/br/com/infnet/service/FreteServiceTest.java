package br.com.infnet.service;

import br.com.infnet.model.Entrega;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FreteServiceTest {

    private FreteService freteService;

    @BeforeEach
    void setUp() {
        freteService = new FreteService();
    }

    @Test
    @DisplayName("Deve calcular o frete Expresso corretamente")
    void deveCalcularFreteExpresso() {
        Entrega entrega = new Entrega("Rua Teste", 10.0, "EXP", "Destinatário");
        double valorFrete = freteService.calcularFrete(entrega);
        // 10.0 * 1.5 + 10 = 25.0
        assertEquals(25.0, valorFrete, 0.001);
    }

    @Test
    @DisplayName("Deve calcular o frete Padrão corretamente")
    void deveCalcularFretePadrao() {
        Entrega entrega = new Entrega("Rua Teste", 10.0, "PAD", "Destinatário");
        double valorFrete = freteService.calcularFrete(entrega);
        // 10.0 * 1.2 = 12.0
        assertEquals(12.0, valorFrete, 0.001);
    }

    @Test
    @DisplayName("Deve calcular o frete Econômico corretamente")
    void deveCalcularFreteEconomico() {
        Entrega entrega = new Entrega("Rua Teste", 10.0, "ECO", "Destinatário");
        double valorFrete = freteService.calcularFrete(entrega);
        // 10.0 * 1.1 - 5 = 6.0
        assertEquals(6.0, valorFrete, 0.001);
    }

    @Test
    @DisplayName("Deve lançar exceção para tipo de frete inválido")
    void deveLancarExcecaoParaTipoFreteInvalido() {
        Entrega entrega = new Entrega("Rua Teste", 10.0, "INVALIDO", "Destinatário");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            freteService.calcularFrete(entrega);
        });
        assertEquals("Tipo de frete inválido: INVALIDO", exception.getMessage());
    }

    @Test
    @DisplayName("Deve ser case-insensitive para o tipo de frete")
    void deveSerCaseInsensitiveParaTipoFrete() {
        Entrega entrega = new Entrega("Rua Teste", 10.0, "exp", "Destinatário");
        double valorFrete = freteService.calcularFrete(entrega);
        assertEquals(25.0, valorFrete, 0.001);
    }
}

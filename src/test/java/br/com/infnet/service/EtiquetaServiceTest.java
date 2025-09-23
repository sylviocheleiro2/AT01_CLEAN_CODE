package br.com.infnet.service;

import br.com.infnet.model.Entrega;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EtiquetaServiceTest {

    private EtiquetaService etiquetaService;
    private Entrega entrega;

    @BeforeEach
    void setUp() {
        etiquetaService = new EtiquetaService();
        entrega = new Entrega("Av 01", 5.0, "PAD", "joão silva");
    }

    @Test
    @DisplayName("Deve gerar a etiqueta de envio no formato correto")
    void deveGerarEtiquetaCorretamente() {
        double valorFrete = 6.00;
        String etiquetaEsperada = "Destinatário: joão silva\n" +
                                  "Endereço: Av. Atlântica, 1702\n" +
                                  "Valor do Frete: R$6,00";

        String etiquetaGerada = etiquetaService.gerarEtiqueta(entrega, valorFrete);

        assertEquals(etiquetaEsperada.replace(',', '.'), etiquetaGerada.replace(',', '.'));
    }

    @Test
    @DisplayName("Deve gerar o resumo do pedido no formato correto")
    void deveGerarResumoCorretamente() {
        double valorFrete = 6.00;
        String resumoEsperado = "Pedido para joão silva com frete tipo PAD no valor de R$6,00";

        String resumoGerado = etiquetaService.gerarResumo(entrega, valorFrete);

        assertEquals(resumoEsperado.replace(',', '.'), resumoGerado.replace(',', '.'));
    }

    @Test
    @DisplayName("Deve formatar o valor do frete com duas casas decimais")
    void deveFormatarValorFreteCorretamente() {
        double valorFrete = 12.3;
        String etiqueta = etiquetaService.gerarEtiqueta(entrega, valorFrete);
        assertTrue(etiqueta.contains("R$12,30") || etiqueta.contains("R$12.30"));

        double valorFreteArredondado = 7.999;
        String resumo = etiquetaService.gerarResumo(entrega, valorFreteArredondado);
        assertTrue(resumo.contains("R$8,00") || resumo.contains("R$8.00"));
    }
}

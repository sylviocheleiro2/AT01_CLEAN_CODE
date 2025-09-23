package br.com.infnet;

import br.com.infnet.model.Entrega;
import br.com.infnet.service.EtiquetaService;
import br.com.infnet.service.FreteService;

public class App {
    public static void main(String[] args)
    {
        FreteService freteService = new FreteService();
        EtiquetaService etiquetaService = new EtiquetaService();

        try {
            // Cenário 1: Entrega Válida
            System.out.println("--- Cenário 1: Pedido Válido ---");
            Entrega entregaValida = new Entrega("Rua joão", 6.0, "EXP", "Sylvio");

            // 1. Calcular o frete
            double valorFrete = freteService.calcularFrete(entregaValida);

            // 2. Gerar etiqueta e resumo
            String etiqueta = etiquetaService.gerarEtiqueta(entregaValida, valorFrete);
            String resumo = etiquetaService.gerarResumo(entregaValida, valorFrete);

            // 3. Exibir resultados
            System.out.println(etiqueta);
            System.out.println("\n" + resumo);

            // ------------------------ === ---------------------------- //

            // Cenário 2: Tentativa com tipo de frete inválido
            System.out.println("\n\n--- Cenário 2: Tentativa com Tipo de Frete Inválido ---");
            Entrega entregaInvalida = new Entrega("Av. Principal, 456", 5.0, "INVALIDO", "Carlos Pereira");
            freteService.calcularFrete(entregaInvalida); // Esta linha vai lançar uma exceção

        }
        catch (IllegalArgumentException e) {
            System.err.println("Erro ao processar entrega: " + e.getMessage());
        }


        // ------------------------ === ---------------------------- //
        try {
            System.out.println("\n--- Cenário 3: Tentativa com Peso Inválido ---");
            new Entrega("Praça dois", -2.0, "PAD", "Ana"); // Esta linha vai lançar uma exceção
        }
        catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar entrega: " + e.getMessage());
        }
    }

}///

package br.com.infnet.service.frete;

import br.com.infnet.model.Entrega;

public class CalculadoraFreteExpresso implements CalculadoraFrete {
    private static final double FATOR_PESO = 1.5;
    private static final double TAXA_ADICIONAL = 10.0;

    @Override
    public double calcular(Entrega entrega) {
        return entrega.getPeso() * FATOR_PESO + TAXA_ADICIONAL;
    }
}

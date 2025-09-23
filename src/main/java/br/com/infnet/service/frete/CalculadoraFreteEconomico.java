package br.com.infnet.service.frete;

import br.com.infnet.model.Entrega;

public class CalculadoraFreteEconomico implements CalculadoraFrete
{
    private static final double FATOR_PESO = 1.1;
    private static final double DESCONTO = 5.0;

    @Override
    public double calcular(Entrega entrega) {
        return entrega.getPeso() * FATOR_PESO - DESCONTO;
    }
}

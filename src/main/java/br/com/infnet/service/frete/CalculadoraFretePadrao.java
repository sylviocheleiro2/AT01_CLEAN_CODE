package br.com.infnet.service.frete;

import br.com.infnet.model.Entrega;

public class CalculadoraFretePadrao implements CalculadoraFrete {
    private static final double FATOR_PESO = 1.2;

    @Override
    public double calcular(Entrega entrega) {
        return entrega.getPeso() * FATOR_PESO;
    }
}

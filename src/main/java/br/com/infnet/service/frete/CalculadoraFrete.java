package br.com.infnet.service.frete;

import br.com.infnet.model.Entrega;

public interface CalculadoraFrete {
    double calcular(Entrega entrega);
}

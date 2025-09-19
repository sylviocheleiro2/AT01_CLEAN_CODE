package br.com.infnet.service;

import br.com.infnet.model.Entrega;
import br.com.infnet.service.frete.CalculadoraFrete;
import br.com.infnet.service.frete.CalculadoraFreteEconomico;
import br.com.infnet.service.frete.CalculadoraFreteExpresso;
import br.com.infnet.service.frete.CalculadoraFretePadrao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FreteService {
    private final Map<String, CalculadoraFrete> calculadoras;

    public FreteService() {
        calculadoras = new ConcurrentHashMap<>();
        calculadoras.put("EXP", new CalculadoraFreteExpresso());
        calculadoras.put("PAD", new CalculadoraFretePadrao());
        calculadoras.put("ECO", new CalculadoraFreteEconomico());
    }

    public double calcularFrete(Entrega entrega) {
        CalculadoraFrete calculadora = calculadoras.get(entrega.getTipoFrete().toUpperCase());
        if (calculadora == null) {
            throw new IllegalArgumentException("Tipo de frete inválido: " + entrega.getTipoFrete());
        }
        return calculadora.calcular(entrega);
    }
}


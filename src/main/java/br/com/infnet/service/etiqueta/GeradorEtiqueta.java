package br.com.infnet.service.etiqueta;

import br.com.infnet.model.Entrega;

public interface GeradorEtiqueta {
    String gerar(Entrega entrega);
}

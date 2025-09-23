package br.com.infnet.service.etiqueta;

import br.com.infnet.model.Entrega;

public class GeradorEtiquetaJson implements GeradorEtiqueta {
    @Override
    public String gerar(Entrega entrega) {
        return "{\n" +
               "  \"destinatario\": \"" + entrega.getDestinatario() + "\",\n" +
               "  \"endereco\": \"" + entrega.getEndereco() + "\",\n" +
               "  \"peso\": " + entrega.getPeso() + ",\n" +
               "  \"tipoFrete\": \"" + entrega.getTipoFrete() + "\",\n" +
               "}";
    }
}

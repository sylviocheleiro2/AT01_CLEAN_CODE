package br.com.infnet.service.etiqueta;

import br.com.infnet.model.Entrega;

public class GeradorEtiquetaHtml implements GeradorEtiqueta {
    @Override
    public String gerar(Entrega entrega) {
        return "<html>\n" +
               "  <body>\n" +
               "    <h1>Etiqueta de Envio</h1>\n" +
               "    <p><b>Destinatário:</b> " + entrega.getDestinatario() + "</p>\n" +
               "    <p><b>Endereço:</b> " + entrega.getEndereco() + "</p>\n" +
               "    <p><b>Peso:</b> " + entrega.getPeso() + " kg</p>\n" +
               "    <p><b>Frete:</b> " + entrega.getTipoFrete() + "</p>\n" +
               "  </body>\n" +
               "</html>";
    }
}

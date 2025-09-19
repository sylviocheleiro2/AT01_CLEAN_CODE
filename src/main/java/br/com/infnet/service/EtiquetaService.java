package br.com.infnet.service;

import br.com.infnet.model.Entrega;

public class EtiquetaService {

    public String gerarEtiqueta(Entrega entrega, double valorFrete) {
        return String.format("Destinatário: %s\nEndereço: %s\nValor do Frete: R$%.2f",
                entrega.getDestinatario(),
                entrega.getEndereco(),
                valorFrete);
    }

    public String gerarResumo(Entrega entrega, double valorFrete) {
        return String.format("Pedido para %s com frete tipo %s no valor de R$%.2f",
                entrega.getDestinatario(),
                entrega.getTipoFrete(),
                valorFrete);
    }
}

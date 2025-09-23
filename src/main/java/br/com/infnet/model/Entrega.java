package br.com.infnet.model;

public class Entrega
{
    private final String endereco;
    private final double peso;
    private final String tipoFrete;
    private final String destinatario;

    public Entrega(String endereco, double peso, String tipoFrete, String destinatario)
    {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser nulo ou vazio.");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso deve ser positivo.");
        }
        if (tipoFrete == null || tipoFrete.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo de frete não pode ser nulo ou vazio.");
        }
        if (destinatario == null || destinatario.trim().isEmpty()) {
            throw new IllegalArgumentException("Destinatário não pode ser nulo ou vazio.");
        }

        this.endereco = endereco;
        this.peso = peso;
        this.tipoFrete = tipoFrete;
        this.destinatario = destinatario;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getPeso() {
        return peso;
    }

    public String getTipoFrete() {
        return tipoFrete;
    }

    public String getDestinatario() {
        return destinatario;
    }
}

package algaworks.orientacaoObjetos;

import java.time.LocalDateTime;

public class Carro {

    public static final int VIDA_UTIL_ANOS = 20;
    String fabricante;
    String modelo;
    String cor;
    int anoFabricacao;
    double precoCompra;
    Pessoa proprietario;

    void calcularValorRevenda() {
        int tempoDeUsoEmAnos = LocalDateTime.now().getYear() - anoFabricacao;
        double valorRevenda = (precoCompra / VIDA_UTIL_ANOS) * (20 - tempoDeUsoEmAnos);
        if (valorRevenda < 0) valorRevenda = 0;
        System.out.println("Tempo de uso (anos): " + tempoDeUsoEmAnos);
        System.out.println("Valor de revenda: " + valorRevenda);
    }
}

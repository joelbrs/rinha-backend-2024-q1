package joelf.tech.rinha.dtos.response;

import java.time.*;

public class TransactionDtoResponse {
    private Integer valor;
    private Character tipo;
    private String descricao;
    private Instant realizado_em;

    public TransactionDtoResponse(Integer valor, Character tipo, String descricao, Instant realizado_em) {
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.realizado_em = realizado_em;
    }

    public Integer getValor() {
        return valor;
    }

    public Character getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Instant getRealizado_em() {
        return realizado_em;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setRealizado_em(Instant realizado_em) {
        this.realizado_em = realizado_em;
    }
}

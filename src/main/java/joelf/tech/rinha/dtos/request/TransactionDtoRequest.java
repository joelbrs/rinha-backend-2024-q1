package joelf.tech.rinha.dtos.request;

import jakarta.validation.constraints.*;

import joelf.tech.rinha.enums.TransactionType;

public class TransactionDtoRequest {
    @NotNull
    @Positive
    private Integer valor;

    @NotNull
    private TransactionType tipo;

    @NotNull
    @Max(10)
    private String descricao;

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public TransactionType getTipo() {
        return tipo;
    }

    public void setTipo(TransactionType tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}

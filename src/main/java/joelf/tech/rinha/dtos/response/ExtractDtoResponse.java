package joelf.tech.rinha.dtos.response;

import java.util.*;

public class ExtractDtoResponse {
    private BalanceDtoResponse saldo;
    private List<TransactionDtoResponse> ultimas_transacoes = new ArrayList<>();

    public ExtractDtoResponse(BalanceDtoResponse saldo, List<TransactionDtoResponse> ultimas_transacoes) {
        this.saldo = saldo;
        this.ultimas_transacoes = ultimas_transacoes;
    }

    public BalanceDtoResponse getSaldo() {
        return saldo;
    }

    public List<TransactionDtoResponse> getUltimas_transacoes() {
        return Collections.unmodifiableList(ultimas_transacoes);
    }

    public void setSaldo(BalanceDtoResponse saldo) {
        this.saldo = saldo;
    }

    public void setUltimas_transacoes(List<TransactionDtoResponse> ultimas_transacoes) {
        this.ultimas_transacoes = ultimas_transacoes;
    }
}

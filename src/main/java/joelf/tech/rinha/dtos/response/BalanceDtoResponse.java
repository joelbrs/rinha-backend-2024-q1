package joelf.tech.rinha.dtos.response;

import java.time.*;

public class BalanceDtoResponse {
    private Integer total;
    private Instant data_extrato = Instant.now();
    private Integer limite;

    public BalanceDtoResponse(Integer total, Integer limite) {
        this.total = total;
        this.limite = limite;
    }

    public Integer getTotal() {
        return total;
    }

    public Instant getData_extrato() {
        return data_extrato;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setData_extrato(Instant data_extrato) {
        this.data_extrato = data_extrato;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }
}

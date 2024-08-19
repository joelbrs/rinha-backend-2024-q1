package joelf.tech.rinha.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import joelf.tech.rinha.models.Balance;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

        @Query(nativeQuery = true, value = "SELECT ts.valor, tc.limite, CURRENT_TIMESTAMP as data_atual "
                        + "FROM tb_saldo ts "
                        + "INNER JOIN tb_client tc ON tc.id = ts.client_id "
                        + "WHERE ts.client_id = :id")
        public Balance getBalanceByClientId(Long id);

        @Query(nativeQuery = true, value = "UPDATE tb_saldo ts SET ts.valor = ts.valor + :value "
                        + "FROM (SELECT tc.limite FROM tb_client tc WHERE tc.id = :id) "
                        + "WHERE ts.client_id = :id "
                        + "RETURNING *")
        public Balance sumBalanceByClientId(Long id, Integer value);

        @Query(nativeQuery = true, value = "UPDATE tb_saldo ts SET ts.valor = ts.valor - :value "
                        + "FROM (SELECT tc.limite FROM tb_client tc WHERE tc.id = :id) "
                        + "where ts.client_id = :id and ABS(ts.valor - :value) <= tc.limite "
                        + "RETURNING *")
        public Balance subtractBalanceByClientId(Long id, Integer value);
}

package joelf.tech.rinha.repositories;

import org.springframework.data.jpa.repository.*;

import org.springframework.stereotype.Repository;

import joelf.tech.rinha.models.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(nativeQuery = true, value = "SELECT tt.valor, tt.tipo, tt.descricao, tt.realizado_em FROM tb_transacao tt "
            + "INNER JOIN tb_client tc ON tc.id = tt.client_id "
            + "WHERE tt.client_id = :id "
            + "ORDER BY tt.realizado_em DESC "
            + "LIMIT 10")
    public List<Transaction> getTransactionByClientId(Long id);
}

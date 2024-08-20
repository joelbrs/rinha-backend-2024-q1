package joelf.tech.rinha.models;

import jakarta.persistence.*;
import joelf.tech.rinha.enums.TransactionType;

import java.time.*;

@Entity
@Table(name = "tb_transacao")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo")
    private TransactionType type;

    @Column(name = "descricao")
    private String description;

    @Column(name = "realizado_em")
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "valor")
    private Integer value;

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Client getClient() {
        return client;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction other = (Transaction) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}

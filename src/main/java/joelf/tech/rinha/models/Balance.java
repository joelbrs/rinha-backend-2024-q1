package joelf.tech.rinha.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_saldo")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor")
    private Integer value;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Balance() {
    }

    public Long getId() {
        return id;
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
        Balance other = (Balance) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}

package joelf.tech.rinha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import joelf.tech.rinha.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}

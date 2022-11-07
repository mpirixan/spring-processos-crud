package br.com.georgefms.processosweb.repositories;

import br.com.georgefms.processosweb.models.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {
}

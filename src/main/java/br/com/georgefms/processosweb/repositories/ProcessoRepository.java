package br.com.georgefms.processosweb.repositories;

import br.com.georgefms.processosweb.models.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessoRepository extends JpaRepository<Processo, Long>
{
}

package br.com.georgefms.processosweb.repositories;

import br.com.georgefms.processosweb.models.TipodeProcesso;
import org.springframework.data.jpa.repository.JpaRepository;

//Permite a persistência no Banco de dados
public interface TipodeProcessoRepository extends JpaRepository<TipodeProcesso, Long> {
}

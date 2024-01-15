package org.generation.italy.eserciziostreamnig.repository;


import java.util.List;
import org.generation.italy.eserciziostreamnig.model.contenuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContenutoRepository extends JpaRepository<contenuto, String> {
	List<contenuto> findByGenere(String genere);
    List<contenuto> findByTitoloIgnoreCase(String titolo);
    List<contenuto> findByTipologia(String tipologia);
    List<contenuto>findByTipologiaLike(String titolo);
    List<contenuto>findByannoproduzioneBetween(Integer annoproduzioneinizio, Integer annoproduzionefine );
}


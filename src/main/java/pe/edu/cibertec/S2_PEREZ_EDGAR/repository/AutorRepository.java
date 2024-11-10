package pe.edu.cibertec.S2_PEREZ_EDGAR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.S2_PEREZ_EDGAR.bd.Autor;

@Repository
public interface AutorRepository
        extends JpaRepository<Autor, Integer> {
}

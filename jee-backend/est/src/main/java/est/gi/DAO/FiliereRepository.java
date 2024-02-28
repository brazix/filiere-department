package est.gi.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import est.gi.entities.Filiere;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
}

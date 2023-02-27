package taev.app.repository;

import taev.app.domain.Revision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisionRepository extends JpaRepository<Revision, Integer> {

}

package taev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import taev.app.domain.Coche;

public interface CocheRepository extends JpaRepository<Coche, Integer> {

}

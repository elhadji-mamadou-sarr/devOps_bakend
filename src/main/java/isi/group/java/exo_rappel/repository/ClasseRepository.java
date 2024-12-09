package isi.group.java.exo_rappel.repository;

import isi.group.java.exo_rappel.entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {

}

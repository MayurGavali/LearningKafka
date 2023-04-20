package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiMediaRepository extends JpaRepository<WikimediaData,Long> {
}

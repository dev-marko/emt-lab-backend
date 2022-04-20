package mk.ukim.finki.emtlabbackend.repository;

import mk.ukim.finki.emtlabbackend.domain.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}

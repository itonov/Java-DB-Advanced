package org.softuni.mostwanted.repositories;

import org.softuni.mostwanted.domain.models.RaceEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceEntryRepository extends JpaRepository<RaceEntry, Integer> {

    @Query(value = "SELECT re FROM RaceEntry AS re WHERE re = :raceEntry")
    RaceEntry findRaceEntry(@Param(value = "raceEntry") RaceEntry raceEntry);
}

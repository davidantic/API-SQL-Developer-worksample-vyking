package iGaming.task.domain.tournament.repository;

import iGaming.task.domain.tournament.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    @Modifying
    @Transactional
    @Query(value = "CALL DistributePrizes(:tournamentId)", nativeQuery = true)
    void distributePrizes(@Param("tournamentId") Long tournamentId);
}

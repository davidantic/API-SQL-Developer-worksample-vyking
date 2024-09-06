package iGaming.task.domain.playerTournament.repository;

import iGaming.task.domain.playerTournament.entity.PlayerTournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerTournamentRepository extends JpaRepository<PlayerTournament, Integer> {
}

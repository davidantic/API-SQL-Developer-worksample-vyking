package iGaming.task.domain.player.repository;

import iGaming.task.domain.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query(value = "SELECT * FROM PlayerRanking", nativeQuery = true)
    List<Player> findPlayerRanking();

}

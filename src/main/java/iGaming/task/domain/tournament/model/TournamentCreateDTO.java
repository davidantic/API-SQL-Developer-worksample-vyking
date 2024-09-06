package iGaming.task.domain.tournament.model;

import java.time.LocalDateTime;

public record TournamentCreateDTO(

         Long tournament_id,
         String tournament_name,
         Double prize_pool,
         LocalDateTime start_date,
         LocalDateTime end_date

) {
}

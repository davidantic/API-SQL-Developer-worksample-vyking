package iGaming.task.domain.playerTournament.model;

public record PlayerTournamentCreateDTO(

        Long playerId,
        Long tournamentId,
        Double totalBet

) {}



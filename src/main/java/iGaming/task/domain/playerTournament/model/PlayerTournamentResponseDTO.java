package iGaming.task.domain.playerTournament.model;

public record PlayerTournamentResponseDTO (

        Long playerId,
        Long tournamentId,
        Double totalBet

){
}

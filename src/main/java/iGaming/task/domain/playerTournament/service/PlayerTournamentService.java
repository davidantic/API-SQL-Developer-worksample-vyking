package iGaming.task.domain.playerTournament.service;

import iGaming.task.domain.playerTournament.model.PlayerTournamentCreateDTO;
import iGaming.task.domain.playerTournament.model.PlayerTournamentResponseDTO;

public interface PlayerTournamentService {
    PlayerTournamentResponseDTO create(PlayerTournamentCreateDTO playerTournamentCreateDTO);
}

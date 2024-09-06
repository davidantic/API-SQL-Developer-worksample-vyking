package iGaming.task.domain.playerTournament.service;

import iGaming.task.domain.playerTournament.entity.PlayerTournament;
import iGaming.task.domain.playerTournament.model.PlayerTournamentCreateDTO;
import iGaming.task.domain.playerTournament.model.PlayerTournamentResponseDTO;
import iGaming.task.domain.playerTournament.repository.PlayerTournamentRepository;
import iGaming.task.infrastructure.mapper.PlayerTournamentMapper;

import org.springframework.stereotype.Service;

@Service
public class PlayerTournamentServiceImpl implements PlayerTournamentService {

    private final PlayerTournamentRepository playerTournamentRepository;
    private final PlayerTournamentMapper playerTournamentMapper;

    public PlayerTournamentServiceImpl(PlayerTournamentRepository playerTournamentRepository, PlayerTournamentMapper playerTournamentMapper) {
        this.playerTournamentRepository = playerTournamentRepository;
        this.playerTournamentMapper = playerTournamentMapper;
    }

    @Override
    public PlayerTournamentResponseDTO create(PlayerTournamentCreateDTO playerTournamentCreateDTO) {
        PlayerTournament playerTournament = playerTournamentMapper.toPlayerTournament(playerTournamentCreateDTO);
        PlayerTournament savedPlayerTournament = playerTournamentRepository.save(playerTournament);

        return playerTournamentMapper.toPlayerTournamentResponseDTO(savedPlayerTournament);
    }
}


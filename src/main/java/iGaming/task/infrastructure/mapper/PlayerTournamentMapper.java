package iGaming.task.infrastructure.mapper;

import iGaming.task.domain.playerTournament.entity.PlayerTournament;
import iGaming.task.domain.playerTournament.model.PlayerTournamentCreateDTO;
import iGaming.task.domain.playerTournament.model.PlayerTournamentResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerTournamentMapper {

    @Mapping(source = "playerId", target = "player.id")
    @Mapping(source = "tournamentId", target = "tournament.tournament_id")
    PlayerTournament toPlayerTournament(PlayerTournamentCreateDTO dto);

    @Mapping(source = "player.id", target = "playerId")
    @Mapping(source = "tournament.tournament_id", target = "tournamentId")
    PlayerTournamentResponseDTO toPlayerTournamentResponseDTO(PlayerTournament playerTournament);

}


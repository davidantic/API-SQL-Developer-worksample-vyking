package iGaming.task.infrastructure.mapper;

import iGaming.task.domain.tournament.entity.Tournament;
import iGaming.task.domain.tournament.model.TournamentCreateDTO;
import iGaming.task.domain.tournament.model.TournamentResponseDTO;
import iGaming.task.domain.tournament.model.TournamentUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper (componentModel = "spring")
public interface TournamentMapper {

    TournamentCreateDTO toTournamentCreateDTO(Tournament tournament);

    Tournament toTournament(TournamentCreateDTO tournamentCreateDTO);

    TournamentResponseDTO toTournamentResponseDTO(Tournament tournament);

    void updateTournamentFromDTO(@MappingTarget Tournament tournament, TournamentUpdateDTO tournamentUpdateDTO);

}

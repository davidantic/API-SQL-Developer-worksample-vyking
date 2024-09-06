package iGaming.task.infrastructure.mapper;

import iGaming.task.domain.player.entity.Player;
import iGaming.task.domain.player.model.PlayerCreateDTO;
import iGaming.task.domain.player.model.PlayerResponseDTO;
import iGaming.task.domain.player.model.PlayerUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerCreateDTO toPlayerCreateDTO(Player player);

    Player toPlayer(PlayerCreateDTO playerCreateDTO);

    PlayerResponseDTO toPlayerResponseDTO(Player player);

    void updatePlayerFromDTO(@MappingTarget Player player, PlayerUpdateDTO playerUpdateDTO);

}

package iGaming.task.domain.player.service;

import iGaming.task.domain.player.entity.Player;
import iGaming.task.domain.player.model.PlayerCreateDTO;
import iGaming.task.domain.player.model.PlayerResponseDTO;
import iGaming.task.domain.player.model.PlayerUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlayerService {
    PlayerResponseDTO create(PlayerCreateDTO playerCreateDTO);

    PlayerResponseDTO getById(Long id);

    Page<PlayerResponseDTO> getAll(Pageable pageable);

    void delete(Long id);

    PlayerResponseDTO update(Long id, PlayerUpdateDTO playerUpdateDTO);

    List<Player> getRankingList();
}

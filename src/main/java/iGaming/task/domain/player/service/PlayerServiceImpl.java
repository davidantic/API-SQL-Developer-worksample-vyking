package iGaming.task.domain.player.service;

import iGaming.task.domain.player.entity.Player;
import iGaming.task.domain.player.model.PlayerCreateDTO;
import iGaming.task.domain.player.model.PlayerResponseDTO;
import iGaming.task.domain.player.model.PlayerUpdateDTO;
import iGaming.task.domain.player.repository.PlayerRepository;
import iGaming.task.infrastructure.exception.customException.NotFoundException;
import iGaming.task.infrastructure.mapper.PlayerMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    @Override
    public PlayerResponseDTO create(PlayerCreateDTO playerCreateDTO) {
        Player createdPlayer = playerMapper.toPlayer(playerCreateDTO);
        Player savedPlayer = playerRepository.save(createdPlayer);

        return playerMapper.toPlayerResponseDTO(savedPlayer);
    }

    @Override
    public PlayerResponseDTO getById(Long id) {
      Player player = getPlayerById(id);

      return playerMapper.toPlayerResponseDTO(player);
    }

    @Override
    public Page<PlayerResponseDTO> getAll(Pageable pageable) {
        return playerRepository.findAll(pageable).map(playerMapper::toPlayerResponseDTO);
    }

    @Override
    public void delete(Long id) {
        if (!playerRepository.existsById(id)){
            throw new NotFoundException("Player with id " + id + " not found");
        }
        playerRepository.deleteById(id);
    }

    @Override
    public PlayerResponseDTO update(Long id, PlayerUpdateDTO playerUpdateDTO) {
        Player currentPlayer = getPlayerById(id);

        playerMapper.updatePlayerFromDTO(currentPlayer, playerUpdateDTO);
        playerRepository.save(currentPlayer);

        return playerMapper.toPlayerResponseDTO(currentPlayer);
    }

    @Override
    public List<Player> getRankingList() {
        return playerRepository.findPlayerRanking();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Player with id " + id + " not found"));
    }

}

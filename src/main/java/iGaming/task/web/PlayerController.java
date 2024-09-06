package iGaming.task.web;

import iGaming.task.domain.player.entity.Player;
import iGaming.task.domain.player.model.PlayerCreateDTO;
import iGaming.task.domain.player.model.PlayerResponseDTO;
import iGaming.task.domain.player.model.PlayerUpdateDTO;
import iGaming.task.domain.player.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<PlayerResponseDTO> createPlayer(@RequestBody PlayerCreateDTO playerCreateDTO){
        return ResponseEntity.ok(playerService.create(playerCreateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponseDTO> getPlayer(@PathVariable Long id){
        return ResponseEntity.ok(playerService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<PlayerResponseDTO>> getAllPlayers(Pageable pageable){
        return ResponseEntity.ok(playerService.getAll(pageable));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable Long id){
        playerService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerResponseDTO> updatePlayer(@PathVariable Long id, @RequestBody PlayerUpdateDTO playerUpdateDTO){
        return ResponseEntity.ok().body(playerService.update(id,playerUpdateDTO));
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<Player>> getRankingList() {
        List<Player> rankingList = playerService.getRankingList();
        return ResponseEntity.ok(rankingList);
    }

}

package iGaming.task.web;

import iGaming.task.domain.playerTournament.model.PlayerTournamentCreateDTO;
import iGaming.task.domain.playerTournament.model.PlayerTournamentResponseDTO;
import iGaming.task.domain.playerTournament.service.PlayerTournamentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("api/v1/player-tournament")
    public class PlayerTournamentController {

    private final PlayerTournamentService playerTournamentService;

    public PlayerTournamentController(PlayerTournamentService playerTournamentService) {
        this.playerTournamentService = playerTournamentService;
    }

    @PostMapping
    public ResponseEntity<PlayerTournamentResponseDTO> createPlayerTournament(@RequestBody PlayerTournamentCreateDTO playerTournamentCreateDTO) {
        PlayerTournamentResponseDTO response = playerTournamentService.create(playerTournamentCreateDTO);
        return ResponseEntity.ok(response);
    }

}



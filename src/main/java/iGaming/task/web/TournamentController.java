package iGaming.task.web;

import iGaming.task.domain.tournament.model.TournamentCreateDTO;
import iGaming.task.domain.tournament.model.TournamentResponseDTO;
import iGaming.task.domain.tournament.model.TournamentUpdateDTO;
import iGaming.task.domain.tournament.service.TournamentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService ) {
        this.tournamentService = tournamentService;
    }

    @PostMapping
    public ResponseEntity<TournamentResponseDTO> createTournament(@RequestBody TournamentCreateDTO tournamentCreateDTO){
        return ResponseEntity.ok(tournamentService.create(tournamentCreateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TournamentResponseDTO> getTournament(@PathVariable Long id){
        return ResponseEntity.ok(tournamentService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<TournamentResponseDTO>> getAllTournaments(Pageable pageable){
        return ResponseEntity.ok(tournamentService.getAll(pageable));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTournament(@PathVariable Long id){
        tournamentService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TournamentResponseDTO> updateTournament(@PathVariable Long id, @RequestBody TournamentUpdateDTO tournamentUpdateDTO){
        return ResponseEntity.ok().body(tournamentService.update(id,tournamentUpdateDTO));
    }

    @PostMapping("/distribute-prizes")
    public ResponseEntity<String> distributePrizes(@RequestParam Long tournamentId) {
        tournamentService.distributePrizes(tournamentId);
        return ResponseEntity.ok("Prizes distributed successfully. Check the database!");
    }

}

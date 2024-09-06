package iGaming.task.domain.tournament.service;

import iGaming.task.domain.tournament.model.TournamentCreateDTO;
import iGaming.task.domain.tournament.model.TournamentResponseDTO;
import iGaming.task.domain.tournament.model.TournamentUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TournamentService {
    TournamentResponseDTO create(TournamentCreateDTO tournamentCreateDTO);

    TournamentResponseDTO getById(Long id);

    Page<TournamentResponseDTO> getAll(Pageable pageable);

    void delete(Long id);

    TournamentResponseDTO update(Long id, TournamentUpdateDTO tournamentUpdateDTO);

    void distributePrizes(Long tournamentId);
}

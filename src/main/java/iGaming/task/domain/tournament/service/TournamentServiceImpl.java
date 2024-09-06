package iGaming.task.domain.tournament.service;

import iGaming.task.domain.tournament.entity.Tournament;
import iGaming.task.domain.tournament.model.TournamentCreateDTO;
import iGaming.task.domain.tournament.model.TournamentResponseDTO;
import iGaming.task.domain.tournament.model.TournamentUpdateDTO;
import iGaming.task.domain.tournament.repository.TournamentRepository;
import iGaming.task.infrastructure.exception.customException.NotFoundException;
import iGaming.task.infrastructure.mapper.TournamentMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TournamentServiceImpl implements TournamentService {

    private final TournamentRepository tournamentRepository;
    private final TournamentMapper tournamentMapper;

    public TournamentServiceImpl(TournamentRepository tournamentRepository, TournamentMapper tournamentMapper) {
        this.tournamentRepository = tournamentRepository;
        this.tournamentMapper = tournamentMapper;
    }

    @Override
    public TournamentResponseDTO create(TournamentCreateDTO tournamentCreateDTO) {
        Tournament createdTournament = tournamentMapper.toTournament(tournamentCreateDTO);
        Tournament savedTournament = tournamentRepository.save(createdTournament);

        return tournamentMapper.toTournamentResponseDTO(savedTournament);
    }

    @Override
    public TournamentResponseDTO getById(Long id) {
        Tournament tournament = getTournamentById(id);

        return tournamentMapper.toTournamentResponseDTO(tournament);
    }

    @Override
    public Page<TournamentResponseDTO> getAll(Pageable pageable) {
        return tournamentRepository.findAll(pageable).map(tournamentMapper::toTournamentResponseDTO);
    }

    @Override
    public void delete(Long id) {
    if(!tournamentRepository.existsById(id)) {
        throw new NotFoundException("Tournament with id " + id + " not found");
    }
    tournamentRepository.deleteById(id);
    }

    @Override
    public TournamentResponseDTO update(Long id, TournamentUpdateDTO tournamentUpdateDTO) {
       Tournament currentTournament = getTournamentById(id);

       tournamentMapper.updateTournamentFromDTO(currentTournament, tournamentUpdateDTO);
       tournamentRepository.save(currentTournament);

       return tournamentMapper.toTournamentResponseDTO(currentTournament);
    }

    @Override
    public void distributePrizes(Long tournamentId) {
        if(!tournamentRepository.existsById(tournamentId)) {
            throw new NotFoundException("Tournament with id " + tournamentId + " not found");
        }
        tournamentRepository.distributePrizes(tournamentId);
    }

    public Tournament getTournamentById(Long id){
        return tournamentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Tournament with id " + id + " not found"));
    }

}

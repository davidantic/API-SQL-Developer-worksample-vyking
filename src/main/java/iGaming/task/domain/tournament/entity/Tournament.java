package iGaming.task.domain.tournament.entity;

import iGaming.task.domain.playerTournament.entity.PlayerTournament;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournament_id;

    @Column(nullable = false, name = "tournament_name")
    private String tournament_name;

    @Column(nullable = false)
    private Double prize_pool;

    @Column(nullable = false)
    private LocalDateTime start_date;

    @Column(nullable = false)
    private LocalDateTime end_date;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<PlayerTournament> playerTournaments;

    public Long getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(Long tournament_id) {
        this.tournament_id = tournament_id;
    }

    public String getTournament_name() {
        return tournament_name;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    public Double getPrize_pool() {
        return prize_pool;
    }

    public void setPrize_pool(Double prize_pool) {
        this.prize_pool = prize_pool;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    public Set<PlayerTournament> getPlayerTournaments() {
        return playerTournaments;
    }

    public void setPlayerTournaments(Set<PlayerTournament> playerTournaments) {
        this.playerTournaments = playerTournaments;
    }
}

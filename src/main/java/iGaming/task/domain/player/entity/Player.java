package iGaming.task.domain.player.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iGaming.task.domain.playerTournament.entity.PlayerTournament;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private double account_balance;

    @JsonIgnore
    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PlayerTournament> playerTournaments;

    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    public Set<PlayerTournament> getPlayerTournaments() {
        return playerTournaments;
    }

    public void setPlayerTournaments(Set<PlayerTournament> playerTournaments) {
        this.playerTournaments = playerTournaments;
    }
}

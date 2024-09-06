CREATE DATABASE IF NOT EXISTS igaming;

USE igaming;

CREATE TABLE IF NOT EXISTS players (
    player_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    account_balance DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS tournaments (
    tournament_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tournament_name VARCHAR(255) NOT NULL,
    prize_pool DOUBLE NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS player_tournament (
    id BIGINT AUTO_INCREMENT, 
    player_id BIGINT,
    tournament_id BIGINT,
    total_bet DOUBLE NOT NULL, 
    PRIMARY KEY (id),
    UNIQUE KEY (player_id, tournament_id),
    FOREIGN KEY (player_id) REFERENCES players(player_id),
    FOREIGN KEY (tournament_id) REFERENCES tournaments(tournament_id)
);

DELIMITER $$

DROP PROCEDURE IF EXISTS DistributePrizes$$

CREATE PROCEDURE DistributePrizes(IN tournamentId BIGINT)
BEGIN
    DECLARE prizePool DOUBLE;
    DECLARE firstPrize DOUBLE;
    DECLARE secondPrize DOUBLE;
    DECLARE thirdPrize DOUBLE;
    DECLARE firstPlayerId BIGINT;
    DECLARE secondPlayerId BIGINT;
    DECLARE thirdPlayerId BIGINT;

    SELECT prize_pool INTO prizePool
    FROM tournaments
    WHERE tournament_id = tournamentId;

    SET firstPrize = prizePool * 0.50;
    SET secondPrize = prizePool * 0.30;
    SET thirdPrize = prizePool * 0.20;

    SELECT player_id INTO firstPlayerId
    FROM player_tournament
    WHERE tournament_id = tournamentId
    ORDER BY total_bet DESC
    LIMIT 1;

    SELECT player_id INTO secondPlayerId
    FROM player_tournament
    WHERE tournament_id = tournamentId
    ORDER BY total_bet DESC
    LIMIT 1 OFFSET 1;

    SELECT player_id INTO thirdPlayerId
    FROM player_tournament
    WHERE tournament_id = tournamentId
    ORDER BY total_bet DESC
    LIMIT 1 OFFSET 2;

    UPDATE players
    SET account_balance = account_balance + firstPrize
    WHERE player_id = firstPlayerId;

    UPDATE players
    SET account_balance = account_balance + secondPrize
    WHERE player_id = secondPlayerId;

    UPDATE players
    SET account_balance = account_balance + thirdPrize
    WHERE player_id = thirdPlayerId;
END$$

DELIMITER ;

CREATE VIEW PlayerRanking AS
SELECT player_id, name, email, account_balance,
       RANK() OVER (ORDER BY account_balance DESC) AS player_rank
FROM players;

CALL DistributePrizes(1);
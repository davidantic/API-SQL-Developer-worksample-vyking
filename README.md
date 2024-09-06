# iGAMING

## Overview

Welcome to the iGAMING platform! This project provides a setup for managing players and tournaments, and includes functionality for distributing prizes based on player placement and tournament prize pool.

## Database Setup

To get started, you need to set up the database. The necessary SQL script for database setup is located in the `db.sql` file. Follow these steps:

1. **Initialize the Database Environment:**
   - Ensure you have MySQL or your preferred database management system installed and running.
   - Create a new database in your database management system.

2. **Run the Database Setup Script:**
   - Execute the `db.sql` script in your database to set up the required tables and stored procedures.

## Running the Application

Once the database is set up, you can run the application. Follow these steps:

1. **Start the Application:**
   - Make sure your development environment is properly configured.
   - Run the application using your preferred IDE or command line.

2. **Test CRUD Operations:**
   - You can test CRUD operations on two entities: Player and Tournament.

## Additional Features

### Distributing Prizes

To distribute prizes, please do the following:

1. **Add Players to Tournaments:**
   - Send a POST request to `http://localhost:8080/api/v1/player-tournament` with the following payload:
     ```json
     {
       "playerId": 1,
       "tournamentId": 1,
       "totalBet": 500.0
     }
     ```
   - This request connects players to the tournament.

2. **Distribute Prizes:**
   - Send a GET request to `http://localhost:8080/api/v1/tournaments/distribute-prizes?tournamentId=1`.
   - This endpoint will execute the stored procedure to distribute prizes based on the tournament and player data.

### Viewing the Ranking List

To view the player ranking list:

- Send a GET request to `http://localhost:8080/api/v1/players/ranking`.

---

Feel free to adjust the URLs and other details according to your specific implementation and environment setup.

package iGaming.task.domain.player.model;

public record PlayerUpdateDTO(

        String name,
        String email,
        Double account_balance

) {
}

package iGaming.task.domain.player.model;

public record PlayerCreateDTO(

        Long id,
        String name,
        String email,
        Double account_balance

) {
}

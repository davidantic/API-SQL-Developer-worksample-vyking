package iGaming.task.domain.player.model;

public record PlayerResponseDTO(

        Long id,
        String name,
        String email,
        Double account_balance

) {
}

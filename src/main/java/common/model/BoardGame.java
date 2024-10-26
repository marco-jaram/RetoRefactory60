package common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BoardGame extends Product {
    private int minPlayers;
    private int maxPlayers;
    private int recommendedAge;
    private int playingTimeMinutes;
    private String designer;
    private GameCategory category; // Ej: LOGIC, STRATEGY, PHILOSOPHY_THEMED
}
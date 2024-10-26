package common.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EReader extends Product {
    private String brand;
    private String model;
    private double screenSize;
    private int storageGB;
    private boolean hasBacklight;
}
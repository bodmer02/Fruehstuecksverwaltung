package de.muenchen.refarch.rest.breakfast;

import de.muenchen.refarch.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
// Definition of getter, setter, ...
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BreakfastEntity extends BaseEntity {

    @Column(nullable = false, length = 50)
    @NotNull @Size(min = 1, max = 50) private String name;

    @Column(nullable = false, length = 50)
    @NotNull @Size(min = 1, max = 50) private String product;

    @NotNull private double price;
}

package de.muenchen.refarch.rest.breakfast;


import com.fasterxml.jackson.annotation.JsonIgnore;
import de.muenchen.refarch.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;


@Entity
// Definition of getter, setter, ...
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserEntity extends BaseEntity {

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<BreakfastEntity> breakfastEntities;

    @Column(nullable = false, length = 50)
    @NotNull @Size(min = 1, max = 50) private String name;

    @Column(nullable = false, length = 50)
    @NotNull @Size(min = 1, max = 50) private String id;

}



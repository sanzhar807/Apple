package org.example.gorest.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Users extends BaseModel{

    Integer id;
    String name;
    String email;
    String gender;
    String status;
}

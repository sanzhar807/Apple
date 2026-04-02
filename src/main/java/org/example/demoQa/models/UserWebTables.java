package org.example.demoQa.models;

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
public class UserWebTables {
    String firstName;
    String lastName;
    String email;
    String age;
    String salary;
    String department;
}

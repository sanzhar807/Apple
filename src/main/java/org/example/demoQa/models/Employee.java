package org.example.demoQa.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Employee {
    String firstName;
    String lastName;
    int age;
    String email;
    int salary;
    String department;
}

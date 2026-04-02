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
public class Todo extends BaseModel {
    Integer id;
    Integer user_id;
    String title;
    String due_on;
    String status;
}
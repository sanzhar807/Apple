package org.example.gorest.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Comment extends BaseModel {

    private Integer id;
    private Integer post_id;
    private String name;
    private String email;
    private String body;
}
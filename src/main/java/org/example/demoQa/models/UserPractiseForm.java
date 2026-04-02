package org.example.demoQa.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserPractiseForm {
     String firsName;
     String LastName;
     String email;
     String gender;
     String phoneNumber;
     List<String> subject = List.of("Accounting","Arts","Biology","Chemistry","Civics","Commerce",
             "Computer Science","Economics","English","Hindi","History","Maths","Physics",
             "Social Studies");
     String hobbies;
     String currentAddress;
}

package com.sqc.academy.exc2;

import com.sqc.academy.exc1.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ex2_1 {public class Employee {
     UUID id;
     String name;
     LocalDate dob;
     Gender gender;
     Double salary;
     String phone;


}
}

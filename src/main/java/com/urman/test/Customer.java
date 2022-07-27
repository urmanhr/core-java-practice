package com.urman.test;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    private String name;
    private String email;
    private List<String> phoneNumbers;
}

package org.example.jsp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {

   private String id;
    private String name;
    private String address;
    private String email;


}

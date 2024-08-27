package com.apifiltering.RestAPIFiltering.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@JsonIgnoreProperties({"city","mobile"}) // Static Filtering
@JsonFilter("StudentFilter")      // Dynamic Filtering
public class Student {

    private String name;   // Field that will always be included during serialization
    private String city;   // Field that can be conditionally included/excluded
    //    @JsonIgnore  // Static Filtering
    private String mobile; // Field that can be conditionally included/excluded
}

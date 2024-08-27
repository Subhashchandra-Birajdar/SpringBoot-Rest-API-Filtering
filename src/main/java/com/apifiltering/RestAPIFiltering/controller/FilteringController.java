package com.apifiltering.RestAPIFiltering.controller;

import com.apifiltering.RestAPIFiltering.entity.Student;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        // Create a Student object with all fields populated
        Student student = new Student("Paras Bagga", "Gurgaon", "8437861802");
        // Apply dynamic filtering to include only 'name' and 'city' properties
        return applyFiltering(student, "name", "city");
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        // Create a list of Student objects
        List<Student> list = Arrays.asList(
                new Student("Paras Bagga", "Gurgaon", "8437861802"),
                new Student("Twinkle Mahajan", "Amritsar", "9000001234"),
                new Student("Aarushi Mahajan", "Gurgaon", "9999991234")
        );
        // Apply dynamic filtering to include only 'name' and 'mobile' properties
        return applyFiltering(list, "name", "mobile");
    }

    // Dynamic Filtering
    private MappingJacksonValue applyFiltering(Object object, String... properties) {
        MappingJacksonValue jacksonValue = new MappingJacksonValue(object);
        // Create a filter that only includes the specified properties
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(properties);
        // Create a FilterProvider that adds the filter for the "StudentFilter"
        FilterProvider filters = new SimpleFilterProvider().addFilter("StudentFilter", filter);
        // Create a FilterProvider that adds the filter for the "StudentFilter"
        jacksonValue.setFilters(filters);
        return jacksonValue;
    }
}

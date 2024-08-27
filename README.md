# Filtering API

* This project demonstrates how to implement dynamic filtering in a Spring Boot REST API using Jackson. It showcases how to control the serialization of JSON data based on runtime criteria, allowing flexible responses depending on user needs or request parameters.
* This API demonstrates how to perform filtering on JSON responses in Spring Boot using both static and dynamic serialization.

## Static Filtering

Static filtering involves excluding certain fields from the JSON response at either the class level or the field level. This means that these fields will always be excluded from the JSON serialization, regardless of the context.

### Class-level Static Filtering

At the class level, static filtering can be applied using Jackson's `@JsonIgnoreProperties` annotation. This annotation allows you to specify fields to be ignored during serialization for all instances of the class.

### Field-level Static Filtering
dynamic filtering in a Spring Boot REST API using Jackson. It showcases how to control the serialization of JSON data based on runtime criteria, allowing flexible responses depending on user needs or request parameters.
At the field level, static filtering can be applied using Jackson's `@JsonIgnore` annotation. This annotation allows you to specify individual fields to be ignored during serialization.

### Note:
Make sure to uncomment the `@JsonIgnoreProperties` or `@JsonIgnore` annotations as needed in the `Student` class to apply the desired static filtering behavior.

## Dynamic Filtering

Dynamic filtering involves excluding certain fields from the JSON response based on runtime conditions. This allows for more flexibility as filtering can be applied selectively based on the request or other factors.

## Features

- **Dynamic JSON Filtering**: Use Jackson's `@JsonFilter` to include or exclude fields dynamically based on runtime conditions.
- **Spring Boot Integration**: Integrates with Spring Boot to provide a RESTful API for managing and filtering `Student` data.
- **Flexible Configuration**: Customize JSON responses based on user roles or specific requirements.
  
## Endpoints

### `/filtering`

- GET request to this endpoint returns a single `Student` object with filtering applied.
- Filtering is applied to include only the "name" and "city" fields in the response.

### `/filtering-list`

- GET request to this endpoint returns a list of `Student` objects with filtering applied.
- Filtering is applied to include only the "name" and "mobile" fields in the response.

This README provides detailed explanations of both static and dynamic filtering mechanisms in the API and how to use the provided endpoints. Adjust the content as needed for your specific project documentation.

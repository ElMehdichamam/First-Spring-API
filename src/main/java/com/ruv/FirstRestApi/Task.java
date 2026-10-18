package com.ruv.FirstRestApi;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Future;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter
@Setter 
public class Task {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title Is Required")
    @Size(min = 3, max = 100 , message = "The Title must be between 3 and 100")
    private String title;

    @NotBlank(message = "Status Is Required")
    @Size(min = 3, max = 100 , message = "The Status must be between 3 and 100")
    private String status;
    @Future
    private LocalDate DueDate;
}

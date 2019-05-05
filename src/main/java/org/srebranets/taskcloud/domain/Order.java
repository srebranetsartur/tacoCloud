package org.srebranets.taskcloud.domain;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Name is required")
    private String street;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank
    private String zip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Date is expired")
    private LocalDate ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Incorrect CVV number")
    private String ccCVV;

    private LocalDateTime placedAt;

    @ManyToOne
    private User user;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos;

    public void addDesign(@NotNull Taco taco) {
        if(Objects.isNull(tacos))
            tacos = new ArrayList<>();

        tacos.add(taco);
    }
}

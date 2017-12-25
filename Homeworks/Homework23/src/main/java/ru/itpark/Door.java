package ru.itpark;

import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "doors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "doors")
@ToString(exclude = "doors")
@Builder
public class Door {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Для постгреста и hsql подходит
    private Long id;

    //@Column (name = "model")
    private String model;

   // @Column (name = "price")
    private Float price;
}

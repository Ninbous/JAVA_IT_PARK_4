package ru.itpark;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Door {
    private Long id;
    private String name;
    private int price;

}
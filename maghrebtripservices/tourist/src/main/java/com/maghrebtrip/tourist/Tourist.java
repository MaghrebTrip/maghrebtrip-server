package com.maghrebtrip.tourist;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tourist {

    @Id
    @SequenceGenerator(
            name = "tourist_id_sequence",
            sequenceName = "tourist_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tourist_id_sequence"
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String nationality;
    private String[] preferences;
    private String[] tripHistory;
}

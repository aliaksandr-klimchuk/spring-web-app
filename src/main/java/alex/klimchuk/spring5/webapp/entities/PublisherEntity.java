package alex.klimchuk.spring5.webapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "books")
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String addressLine1;

    @NonNull
    private String city;

    @NonNull
    private String state;

    @NonNull
    private String zip;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<BookEntity> books = new HashSet<>();

}

package com.teste.solution.user.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "tb_solti_user")
@Entity(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "solti_user_id")
    private UUID id;

    @Column(name = "solti_user_name", nullable = false, length = 100)
    private String name;

    @Column(name = "solti_user_cpf", nullable = false, length = 20, unique = true)
    private String cpf;

    @Column(name = "solti_user_created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}

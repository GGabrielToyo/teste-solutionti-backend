package com.teste.solution.user.domain;

import com.teste.solution.user.domain.dtos.CreateUserDto;
import com.teste.solution.user.domain.dtos.UpdateUserDto;
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

    @Column(name = "solti_user_password", nullable = false, length = 255)
    private String password;

    @Column(name = "solti_user_created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "solti_user_updated_at", nullable = false)
    private LocalDateTime updatedAt = null;

    public User(CreateUserDto createUserDto) {
        this.name = createUserDto.name();
        this.cpf = createUserDto.cpf();
        this.password = createUserDto.password();
    }

    public void update(UpdateUserDto updateUserDto) {
        this.name = (updateUserDto.name() != null && !updateUserDto.name().isEmpty()) ? updateUserDto.name() : this.name;
        this.cpf = (updateUserDto.cpf() != null && !updateUserDto.cpf().isEmpty()) ? updateUserDto.cpf() : this.cpf;
        this.updatedAt = LocalDateTime.now();
    }

}

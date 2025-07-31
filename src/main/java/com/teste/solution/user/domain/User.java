package com.teste.solution.user.domain;

import com.teste.solution.user.domain.dtos.CreateUserDto;
import com.teste.solution.user.domain.dtos.UpdateUserDto;
import com.teste.solution.util.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Table(name = "tb_solti_user")
@Entity(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "solti_user_id")
    private UUID id;

    @Column(name = "solti_user_email", length = 100, nullable = false, unique = true)
    private String email;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "solti_user_role")
    private RoleEnum role;

    public User(CreateUserDto createUserDto, RoleEnum role) {
        this.name = createUserDto.name();
        this.email = createUserDto.email();
        this.cpf = createUserDto.cpf();
        this.password = encryptPassword(createUserDto.password());
        this.role = role;
    }

    public void update(UpdateUserDto updateUserDto) {
        this.name = (updateUserDto.name() != null && !updateUserDto.name().isEmpty()) ? updateUserDto.name() : this.name;
        this.email = (updateUserDto.email() != null && !updateUserDto.email().isEmpty()) ? updateUserDto.email() : this.email;
        this.cpf = (updateUserDto.cpf() != null && !updateUserDto.cpf().isEmpty()) ? updateUserDto.cpf() : this.cpf;
        if (updateUserDto.password() != null && !updateUserDto.password().isEmpty()) {
            this.password = encryptPassword(updateUserDto.password());
        }
        this.updatedAt = LocalDateTime.now();
    }

    protected String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.role.toString().toUpperCase()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

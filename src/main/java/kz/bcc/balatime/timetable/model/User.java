package kz.bcc.balatime.timetable.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Table(name = "b_user", schema = "public")

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "user_id_seq",
            sequenceName = "user_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_id_seq")
    @Column(name = "id")
    private Integer id;

    //    @Column(name = "role_id")
//    private Integer roleId;
    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;

    @Column(name = "login", unique = true)

    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "arcfl")
    private Integer arcfl;
    @Column(name = "role_id") //
    private Integer roleId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
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


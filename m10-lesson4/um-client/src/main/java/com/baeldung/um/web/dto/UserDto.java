package com.baeldung.um.web.dto;

import com.baeldung.common.interfaces.INameableDto;
import com.baeldung.common.persistence.model.INameableEntity;
import com.baeldung.um.persistence.model.Principal;
import com.baeldung.um.persistence.model.Role;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class UserDto implements INameableEntity, INameableDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    private String password;

    private Set<Role> roles;

    private String status;

    public UserDto() {
        super();
    }

    public UserDto(final String name, final String email, final String password, final Set<Role> roles) {
        super();

        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UserDto(final Principal principal) {
        super();

        name = principal.getName();
        roles = principal.getRoles();
        email = principal.getEmail();
        id = principal.getId();
        status = principal.getStatus();
    }

    // API

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long idToSet) {
        id = idToSet;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(final String nameToSet) {
        name = nameToSet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String passwordToSet) {
        password = passwordToSet;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(final Set<Role> rolesToSet) {
        roles = rolesToSet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserDto other = (UserDto) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", roles=" + roles + ", status=" + status + "]";
    }

}

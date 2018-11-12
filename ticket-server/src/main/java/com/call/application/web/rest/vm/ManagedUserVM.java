package com.call.application.web.rest.vm;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Size;

import com.call.application.service.model.UserDTO;

/**
 * View Model extending the UserDTO, which is meant to be used in the user management UI.
 */
public class ManagedUserVM extends UserDTO {

    public static final int PASSWORD_MIN_LENGTH = 2;

    public static final int PASSWORD_MAX_LENGTH = 100;

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    public ManagedUserVM() {
    }

    public ManagedUserVM(Long id, String username, String password, String firstname, String lastname,
                         String email, boolean activated, String imageUrl, String langKey,
                         String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate,
                         Set<String> roles, Set<String> authorities) {

        super(id, username, firstname, lastname, email, activated, imageUrl, langKey,
            createdBy, createdDate, lastModifiedBy, lastModifiedDate, roles, authorities);

        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "ManagedUserVM{" +
            "} " + super.toString();
    }
}

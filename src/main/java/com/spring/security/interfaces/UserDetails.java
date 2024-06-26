package com.spring.security.interfaces;

import java.io.Serializable;

public interface UserDetails extends Serializable {

    String getUsername();

    String getPassword();
}

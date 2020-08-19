package com.wisely.highlight_springmvc4.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by dujiayong on 2020/4/5.
 */
@Getter
@Setter
@NoArgsConstructor
public class User {

    public String username;

    public String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}

package com.wisely.springmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dujiayong
 * @date 2020/06/03
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String username;

    private String password;

    private String email;

    private Integer age;

}

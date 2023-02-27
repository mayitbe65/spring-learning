package com.spring.demo.jdk;


import com.spring.demo.bean.User;

import java.util.Optional;

public class OptionalTest {


    public static void main(String[] args) {

        User user = new User();

        Optional<User> optional = Optional.ofNullable(user);
        System.out.println(optional.isPresent());
        System.out.println(Optional.of(user));

        Optional<User> empty = Optional.empty();
//        System.out.println(empty.get());

//        Optional<User> optOrNull = Optional.ofNullable(null);
        Optional<User> optOrNull = Optional.ofNullable(user);
        System.out.println(optOrNull);
        System.out.println(optOrNull == empty);
    }
}

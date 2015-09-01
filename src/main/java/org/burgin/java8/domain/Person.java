package org.burgin.java8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by jonburgin on 8/24/15.
 */
@Data
@AllArgsConstructor
public class Person {

    private String name;
    private Integer age;

}

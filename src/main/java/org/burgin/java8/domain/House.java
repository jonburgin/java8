package org.burgin.java8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonburgin on 8/24/15.
 */
@Data
@AllArgsConstructor
public class House {
    List<Person> persons = new ArrayList<>();
}

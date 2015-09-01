package org.burgin.java8.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by jonburgin on 8/24/15.
 */
@Data
public class Street {

    public Street(){}
    public Street(List<House> houses){
        this.houses = houses;
    }
    List<House> houses;
}

package org.burgin.java8.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by jonburgin on 8/24/15.
 */
@Data
public class City {

    public City(){}
    public City(List<Street> streets){
        this.streets = streets;
    }

    List<Street> streets;

}

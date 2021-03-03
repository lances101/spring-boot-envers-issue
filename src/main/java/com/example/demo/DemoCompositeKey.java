package com.example.demo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class DemoCompositeKey implements Serializable {
    Integer one;
    Integer two;
}

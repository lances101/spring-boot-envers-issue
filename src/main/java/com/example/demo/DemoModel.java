package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Audited
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DemoModel {
    @EmbeddedId
    private DemoCompositeKey id;

    @ElementCollection
    @CollectionTable(name="demo_model_collection", joinColumns = {
            @JoinColumn(name="demo_one", referencedColumnName = "one"),
            @JoinColumn(name="demo_two", referencedColumnName = "two")
    })
    @MapKeyColumn(name = "key_thing")
    @Column(name = "value_thing")
    @EqualsAndHashCode.Exclude()
    private Map<String, String> someCollection = new HashMap<>();
}

package com.kornasiowa.appetize.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class Step implements Serializable {

    private int step;
    private String description;
    private int duration;

    public Step() {
    }

    public Step(int step, String description, int duration) {
        this.step = step;
        this.description = description;
        this.duration = duration;
    }

}

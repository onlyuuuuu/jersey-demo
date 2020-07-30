package com.onlyu.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@XmlRootElement
public class Greet {

    private String to;
    private NameType type = NameType.FIRST_NAME;
    private String message;
    private List<String> details = new ArrayList<>();

    public Greet(String to, String message) {
        this.to = to;
        this.message = message;
    }

}

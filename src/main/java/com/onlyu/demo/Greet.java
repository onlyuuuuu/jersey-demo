package com.onlyu.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Greet {

    private String to = "";
    private String toNull = null;
    private NameType type = NameType.FIRST_NAME;
    private String message = "";
    private String messageNull = null;
    private List<String> details = new ArrayList<>();
    private GreetDetails greetDetails;

    public Greet(String to, String message) {
        this.to = to;
        this.message = message;
    }

    public Greet(List<String> details) {
        this.details = details;
    }

}

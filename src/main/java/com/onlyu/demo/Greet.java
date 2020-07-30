package com.onlyu.demo;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class Greet {

    private String to;
    private String message;

}

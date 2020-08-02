package com.onlyu.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SimpleGreetJson {

    private String code;
    private String to;
    private String message = "";
    private List<String> details = new ArrayList<>();

}

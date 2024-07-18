package com.study.ssr.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Dvd {
    private String title;
    private String producer;
    private String publisher;
}

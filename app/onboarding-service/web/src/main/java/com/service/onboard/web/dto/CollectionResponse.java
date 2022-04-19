package com.service.onboard.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CollectionResponse<T> {
    List<T> data;
}

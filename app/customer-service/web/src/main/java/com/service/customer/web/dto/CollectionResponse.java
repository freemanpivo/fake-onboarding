package com.service.customer.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CollectionResponse<T> {
    List<T> data;
}

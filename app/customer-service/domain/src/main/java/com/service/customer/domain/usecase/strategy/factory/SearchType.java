package com.service.customer.domain.usecase.strategy.factory;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum SearchType {
    ID("id"), DOCUMENT_ID("document_id");

    private final String value;

    private static final Map<String, SearchType> SEARCH_TYPES;
    static {
        Map<String,SearchType> map = new ConcurrentHashMap<>();
        for (SearchType type : SearchType.values()) {
            map.put(type.getValue().toLowerCase(),type);
        }
        SEARCH_TYPES = Collections.unmodifiableMap(map);
    }

    SearchType(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public static SearchType from(String value) {
        return SEARCH_TYPES.get(value.toLowerCase());
    }
}

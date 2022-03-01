package com.service.customer.domain.util;

public class RegexPatternStore {
    public static final String PATTERN_ID = "^[0-9a-fA-F]{8}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{12}$";
    public static final String PATTERN_DOCUMENT = "^(\\d{11})$";

    private RegexPatternStore() {}
}

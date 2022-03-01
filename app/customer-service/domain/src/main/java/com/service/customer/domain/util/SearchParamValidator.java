package com.service.customer.domain.util;

import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class SearchParamValidator {
    private static final String ID_PARAM = "id";
    private static final String DOCUMENT_PARAM = "document_id";

    private static final Set<String> VALID_SEARCH_PARAM_KEY;
    static {
        VALID_SEARCH_PARAM_KEY = Set.of(ID_PARAM, DOCUMENT_PARAM);
    }

    public boolean checkKeyValue(Map<String, String> queryParam) {
        if (!hasValidKeySet(queryParam.keySet())) {
            return false;
        }

        final var key = queryParam.keySet().stream().findFirst();
        if (key.isEmpty()) return false;

        final var value = queryParam.get(key.get());
        if (value == null || value.isBlank()) return false;

        if (key.get().equals(ID_PARAM)) {
            return checkIdValue(value);
        }
        return checkDocumentIdValue(value);
    }

    public boolean hasValidKeySet(Set<String> params) {
        if (params == null || params.size() != 1) {
            return false;
        }

        return VALID_SEARCH_PARAM_KEY.contains(params.stream().findFirst().get());
    }

    protected boolean checkIdValue(String query) {
        return Pattern.matches(RegexPatternStore.PATTERN_ID, query.toUpperCase());
    }

    protected boolean checkDocumentIdValue(String query) {
        return Pattern.matches(RegexPatternStore.PATTERN_DOCUMENT, query);
    }
}

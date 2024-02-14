package com.home.steps;

import java.util.HashMap;
import java.util.Map;

public class StepContext {
    private final Map<String, Object> namedStoredValues = new HashMap<>();

    public void storeValue(String name, Object value) {
        this.namedStoredValues.put(name, value);
    }

    public void storeValues(Map<String, Object> namedStoredValues) {
        this.namedStoredValues.putAll(namedStoredValues);
    }

    public <T> T getStoredValue(String name) {
        Object value = namedStoredValues.get(name);
        if (value == null) {

            return null;
        }
        return (T) value;
    }

    public void clear() {
        namedStoredValues.clear();
    }

    public Map<String, Object> getNamedStoredValues() {
        return namedStoredValues;
    }
}

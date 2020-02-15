package org.mcknight.wicker.commons.fs;

import java.util.Map;

public class Schema {
    private Map<String, Field> fields;

    public void addField(Field field) {       
        fields.put(field.getName(), field);
    }

    public Field getField(String fieldName) {
        return fields.get(fieldName);
    }

}

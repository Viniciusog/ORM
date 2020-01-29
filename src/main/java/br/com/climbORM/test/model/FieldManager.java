package br.com.climbORM.test.model;

import br.com.climbORM.framework.interfaces.DynamicFields;

import java.util.HashMap;
import java.util.Map;

public class FieldManager implements DynamicFields {

    private Class type;

    private Map<String, Class> newFields;
    private Map<String, Object> valueFields;

    {
        newFields = new HashMap<>();
        valueFields = new HashMap<>();
    }


    private FieldManager(Class type) {
        this.type = type;
    }

    public static DynamicFields create(Class type) {
        return new FieldManager(type);
    }

    @Override
    public Object getValue(String fieldName) {
        return this.valueFields.get(fieldName);
    }

    @Override
    public void createField(String name, Class type) {
        this.newFields.put(name, type);
    }

    @Override
    public void addValue(String name, Object value) {
        this.valueFields.put(name, value);
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public Map<String, Class> getNewFields() {
        return newFields;
    }

    public void setNewFields(Map<String, Class> newFields) {
        this.newFields = newFields;
    }

}

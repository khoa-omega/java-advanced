package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DepartmentTypeConvert implements AttributeConverter<Type, Character> {
    @Override
    public Character convertToDatabaseColumn(Type type) {
        return type.getCode();
    }

    @Override
    public Type convertToEntityAttribute(Character code) {
        return Type.toType(code);
    }
}

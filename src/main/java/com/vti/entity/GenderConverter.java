package com.vti.entity;

import javax.persistence.AttributeConverter;

public class GenderConverter implements AttributeConverter<Gender, Character> {
    @Override
    public Character convertToDatabaseColumn(Gender gender) {
        return gender.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Character code) {
        return Gender.toGender(code);
    }
}

package com.harrison.enums;

import javax.persistence.AttributeConverter;

public class IrisEnumConverter implements AttributeConverter<IrisSpeciesEnum, String> {

    @Override
    public String convertToDatabaseColumn(IrisSpeciesEnum attribute) {
        switch (attribute) {
        case SETOSA:
            return "setosa";
        case VERSICOLOR:
            return "versicolor";
        case VIRGINICA:
            return "virginica";
        default:
            throw new IllegalArgumentException("Unknown Iris Species: " + attribute); 
    }
    }

    @Override
    public IrisSpeciesEnum convertToEntityAttribute(String dbData) {
        switch (dbData) {
        case "setosa":
            return IrisSpeciesEnum.SETOSA;
        case "versicolor":
            return IrisSpeciesEnum.VERSICOLOR;
        case "virginica":
            return IrisSpeciesEnum.VIRGINICA;
        default:
            throw new IllegalArgumentException("Unknown Iris Species: " + dbData); 
    }
    }

}

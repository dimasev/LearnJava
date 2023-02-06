package by.itacademy.array.validator.impl;

import by.itacademy.array.validator.NumberValidator;

public class NumberValidatorImpl implements NumberValidator {
    private static final String NUMBER_REGEX = "[-+]?\\d{1,5}";
    @Override
    public boolean numberValidate(String stringNumber) {
        boolean match = stringNumber.matches(NUMBER_REGEX);
        return match;
    }
}

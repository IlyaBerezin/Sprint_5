package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LionTestParameterized {

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void shouldSetHasManeCorrectly(String sex, boolean expectedHasMane) throws Exception {
        // Arrange
        Lion lion = new Lion(sex, feline);
        // Act
        boolean actualHasMane = lion.doesHaveMane();
        // Assert
        assertEquals(expectedHasMane, actualHasMane,
                "Пол '" + sex + "' должен давать hasMane = " + expectedHasMane);
    }
}

package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
//import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionParameterizedTest {

    @Mock
    private Feline feline;
    //Проверяем, что конструктор правильно устанавливает hasMane
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
//тест исключения
    @ParameterizedTest
    @ValueSource(strings = {
            "Мужчина",
            "Женщина",
            "Male",
            "Female",
            "''",
            "   "
    })
    void shouldThrowException_whenInvalidSex(String invalidSex) {

        Exception exception = assertThrows(Exception.class,
                () -> new Lion(invalidSex, feline), "Должно выбрасывать исключение для некорректного пола"
        );
        // Проверяем сообщение
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}

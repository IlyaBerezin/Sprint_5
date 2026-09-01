package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
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

    // Проверяем getFood() с разными рационами
 /*   @ParameterizedTest
    @CsvSource(value = {
            "Трава|Различные растения",
            "Животные|Птицы|Рыба"
    }, delimiter = '\u0000')
    void getFood_shouldReturnGivenDiet(String foodItems) throws Exception {
        // Arrange
        List<String> expectedFood = List.of(foodItems);
        Mockito.doReturn(expectedFood).when(feline).getFood("Хищник");
        Lion lion = new Lion("Самец", feline);
        // Act
        List<String> actualFood = lion.getFood();
        // Assert
        assertEquals(expectedFood, actualFood,
                "Lion должен возвращать точно такой же рацион, как и Feline");
        Mockito.verify(feline).getFood("Хищник");
    }*/
}

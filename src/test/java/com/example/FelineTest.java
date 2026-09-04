package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    void eatMeat_shouldCallGetFoodWithPredatorAndReturnResult() throws Exception {
        // Arrange подменяем вызов getFood("Хищник")
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.doReturn(expectedFood).when(feline).getFood("Хищник");
        // Act вызываем eatMeat()
        List<String> actualFood = feline.eatMeat();
        // Assert
        Mockito.verify(feline).getFood("Хищник"); //проверяем, что вызвали с правильным аргументом
        assertEquals(expectedFood, actualFood, "eatMeat() должен возвращать результат getFood(\"Хищник\")");
    }

    @Test
    void getFamily_shouldReturnCorrectFamilyName() {
        // Arrange
        Feline feline = new Feline();
        // Act
        String family = feline.getFamily();
        // Assert
        assertEquals("Кошачьи", family, "Семейство должно быть 'Кошачьи'");
    }

    @Test
    void getKittens_withoutParameters_shouldCallGetKittensWithOne() throws Exception {
        // Arrange подменяем поведение getKittens(int)
        // Чтобы контролировать результат
        Mockito.doReturn(1).when(feline).getKittens(1);
        // Act вызываем метод без параметров
        int result = feline.getKittens();
        // Assert
        Mockito.verify(feline).getKittens(1); //проверяем, что вызвали с аргументом 1
        assertEquals(1, result, "getKittens() должен возвращать результат getKittens(1)");
    }

    @Test
    void getKittens_withValidCount_shouldReturnValue() {
        // Arrange
        int expectedKittens = 5;
        // Act
        int actualKittens = feline.getKittens(expectedKittens);
        // Assert
        assertEquals(expectedKittens, actualKittens, "Метод должен вернуть переданное количество котят");
    }

}

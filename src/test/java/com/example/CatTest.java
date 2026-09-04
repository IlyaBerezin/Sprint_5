package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getSound_shouldReturnMeow() {
        // Arrange
        Cat cat = new Cat(null);
        // Act
        String sound = cat.getSound();
        // Assert
        assertEquals("Мяу", sound, "Метод getSound() должен возвращать 'Мяу'");
    }

    @Test
    public void getFood_shouldReturnFoodFromFeline_andCallEatMeat() throws Exception {
        // Arrange
        Cat cat = new Cat(feline);
        List<String> expectFood = List.of("Хищник");
        Mockito.when(feline.eatMeat()).thenReturn(expectFood);
        // Act
        List<String> actualFood = cat.getFood();
        // Assert
        Mockito.verify(feline).eatMeat();
        assertEquals(expectFood, actualFood, "Должно быть 'Хищник'");
    }
}
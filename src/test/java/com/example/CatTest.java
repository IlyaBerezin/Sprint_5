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
        assertAll(
                () -> assertEquals("Мяу", sound, "Метод getSound() должен возвращать 'Мяу'"),
                () -> assertNotNull(sound, "Звук не должен быть null"),
                () -> assertFalse(sound.isEmpty(), "Звук не должен быть пустой строкой"),
                () -> assertTrue(sound.trim().equals("Мяу"), "Звук не должен содержать лишних пробелов")
                );
    }

    @Test
    public void getFood_shouldReturnFoodFromFeline_andCallEatMeat() throws Exception {
        // Arrange
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Хищник"));
        // Act
        List<String> food = cat.getFood();
        // Assert
        Mockito.verify(feline).eatMeat();
        assertEquals(List.of("Хищник"), food, "Должно быть 'Хищник'");
    }
}
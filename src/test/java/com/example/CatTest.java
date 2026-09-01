package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    void getSound_shouldReturnMeow() {
        // Arrange
        Cat cat = new Cat(feline);
        // Act
        String sound = cat.getSound();
        // Assert
        assertEquals("Мяу", sound, "Метод getSound() должен возвращать 'Мяу'");
        assertNotNull(sound, "Звук не должен быть null");
        assertFalse(sound.isEmpty(), "Звук не должен быть пустой строкой");
    }



}

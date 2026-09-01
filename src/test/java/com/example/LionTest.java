package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    void getKittens_shouldReturnFelinesKittens() throws Exception {
        // Arrange
        // когда вызовут feline.getKittens(), верни 3
        Mockito.when(feline.getKittens()).thenReturn(3);
        // Создаём Lion, передавая мок в конструктор
        Lion lion = new Lion("Самка", feline);
        // Act
        int kittens = lion.getKittens();
        // Assert
        assertEquals(3, kittens, "Lion должен вернуть количество котят от Feline");
    }

    @Test
    void doesHaveMane_shouldReturnTrue_whenSexIsMale() throws Exception {
        // Arrange
        Lion lion = new Lion("Самец", feline);
        // Act
        boolean hasMane = lion.doesHaveMane();
        // Assert
        assertTrue(hasMane, "Самец должен иметь гриву");
    }

    @Test
    void getFood_shouldReturnDiet() throws Exception {
        // Arrange
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", feline);
        // Act
        List<String> actualFood = lion.getFood();
        // Assert
        assertEquals(expectedFood, actualFood, "Lion должен возвращать рацион хищника");
        Mockito.verify(feline).getFood("Хищник"); //проверяем, что вызвали с правильным аргументом
    }

}

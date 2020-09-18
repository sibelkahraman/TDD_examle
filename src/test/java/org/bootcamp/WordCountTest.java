package org.bootcamp.w3;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTest {

    WordCount sut = new WordCount();
    @BeforeEach
    public void setup(){    }


    @Test
    public void shouldReturn_2_WhenGiven_Hello_World(){
        //Arrange

        //Act
        String sentence = "Hello, World";
        int result = sut.counter(sentence);

        //Assert
        assertEquals(result,2);

    }

    @ParameterizedTest
    @MethodSource("return2TestSource")
    public void shouldReturn_2_WhenGivenSentenceHas_TwoUniqueWords(String sentence, int expectedResult){
        //Arrange

        //Act
        int result = sut.counter(sentence);

        //Assert
        assertEquals(result, expectedResult);
    }
    private static Stream<Arguments> return2TestSource() {
        return Stream.of(
                Arguments.of("I I I i robot Robot roBot roboT", 2),
                Arguments.of("Test Success success test success", 2),
                Arguments.of("two words words two Two Two two", 2));
    }

    @Tag(value="important")
    @Test
    public void shouldReturn_2_WhenGiven_CapitalAndLowerCaseOfTwoWolds(){
        //Arrange

        //Act
        String sentence = "Sibel kahraman Kahraman sibel";
        int result = sut.counter(sentence);

        //Assert
        assertEquals(result,2);
    }
    @Test
    public void shouldReturn_1_WhenGiven_OneWorldAndPunctuations(){
        //Arrange

        //Act
        String sentence = "Hello,,,,......";
        int result = sut.counter(sentence);

        //Assert
        assertEquals(result,1);

    }

}

package org.avilio;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogicTest {



    @ParameterizedTest
    @ValueSource(ints = {11,10000000,10,Integer.MAX_VALUE})
    public void checkForNumbersWhenCorrectPositiveInput(int number){
        String str = String.valueOf(number);
        String result = Logic.checkForNumber(str);
        assertEquals("Привет",result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-11,-10000000,-10,0,7,Integer.MIN_VALUE})
    public void checkForNumbersWhenCorrectNegativeInput(int number){
        String str = String.valueOf(number);
        String result = Logic.checkForNumber(str);
        assertEquals("",result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"23sd","@#%%^@  ","","+++  ?  325"})
    public void checkForNumbersWhenUncorrectInput(String str){
        String result = Logic.checkForNumber(str);
        assertEquals("Пожалуйста, введите корректные данные",result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Вячеслав","вячеслав","ВЯЧЕСЛАВ","ВяЧеСлАВ"})
    public void checkForNamePositive(String str){
        assertEquals("Привет, Вячеслав",Logic.checkForName(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Александр","Max","Naruto","Меченый"})
    public void checkForNameFail(String str){
        assertEquals("Нет такого имени",Logic.checkForName(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"","234ыв","%%;!","    "})
    public void checkForNameUncorrect(String str){
        assertEquals("Пожалуйста, введите корректные данные",Logic.checkForName(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,3 %-33 99 222","5 ^5 7 @   9    12","42 18 << 7  6   11"})
    public void checkForMulti3Negative(String str){
        assertEquals("Пожалуйста, введите корректные данные",Logic.outputMultiplesOf3(str));
    }

}
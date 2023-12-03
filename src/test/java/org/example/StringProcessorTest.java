package org.example;


import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class StringProcessorTest extends TestCase {
    StringProcessor sp;
    @Before
    public void initialize(){
        sp = new StringProcessor();
    }
//    correct
    @Test
    public void test1Password(){
        sp = new StringProcessor();
        assertTrue(sp.isStrongPassword("wertG4%f"));
    }
//    length is less than 8 char
    @Test
    public void test2Password(){
        sp = new StringProcessor();
        assertEquals(true, sp.isStrongPassword("wertG4%"));
    }
//    do not have a number
    @Test
    public void test3Password(){
        sp = new StringProcessor();
        assertEquals(true, sp.isStrongPassword("wertG%f_"));
    }
//    do not have uppercase letter
    @Test
    public void test4Password(){
        sp = new StringProcessor();
        assertEquals(true, sp.isStrongPassword("werti4%f"));
    }
//    do not have lowercase letter
    @Test
    public void test5Password(){
        sp = new StringProcessor();
        assertEquals(true, sp.isStrongPassword("WERTG4%0"));
    }

//    count number of digits in a sentence
    @Test
    public void test1Digit(){
        sp = new StringProcessor();
        assertEquals(6, sp.calculateDigits("In 2023, 5 adventurous explorers traveled to 3 different countries, discovering new cultures and landscapes."));
    }
    @Test
    public void test2Digit(){
        sp = new StringProcessor();
        assertEquals(4, sp.calculateDigits("new 2024th year"));
    }
    @Test
    public void test3Digit(){
        sp = new StringProcessor();
        assertEquals(1, sp.calculateDigits("we have 5 dogs"));
    }
    @Test
    public void test4Digit(){
        sp = new StringProcessor();
        assertEquals(10, sp.calculateDigits("1234567890"));
    }
    @Test
    public void test5Digit(){
        sp = new StringProcessor();
        assertEquals(10, sp.calculateDigits("1 2 3 4 5 6 7 8 9 0"));
    }

//    count number of words in a sentence
    @Test
    public void test1Words(){
        sp = new StringProcessor();
        assertEquals(6, sp.calculateWords("The sun sets beyond the horizon."));
    }
    @Test
    public void test2Words(){
        sp = new StringProcessor();
        assertEquals(9, sp.calculateWords("She danced gracefully under the moonlight on the beach."));
    }
    @Test
    public void test3Words(){
        sp = new StringProcessor();
        assertEquals(10, sp.calculateWords("The old, towering oak tree stood majestically in the garden."));
    }
    @Test
    public void test4Words(){
        sp = new StringProcessor();
        assertEquals(8, sp.calculateWords("Frothy waves crashed against the rugged cliffs relentlessly."));
    }
    @Test
    public void test5Words(){
        sp = new StringProcessor();
        assertEquals(10, sp.calculateWords("In the quiet forest, birds chirped merrily amidst rustling leaves."));
    }
//    solves an expression
    @Test
    public void test1Expression(){
        sp = new StringProcessor();
        assertEquals(2.5, sp.calculateExpression("10 / 4"));
    }
    @Test
    public void test2Expression(){
        sp = new StringProcessor();
        assertEquals(24.0, sp.calculateExpression("(15 - 3) * 2"));
    }
    @Test
    public void test3Expression(){
        sp = new StringProcessor();
        assertEquals(6.0, sp.calculateExpression("30 / (4 + 1)"));
    }
    @Test
    public void test4Expression(){
        sp = new StringProcessor();
        assertEquals(1.5, sp.calculateExpression("(9 + 3) / (2 * 4)"));
    }
    @Test
    public void test5Expression(){
        sp = new StringProcessor();
        assertEquals(2.6, sp.calculateExpression("((7 * 3) - (4 * 2)) / 5"));
    }

}

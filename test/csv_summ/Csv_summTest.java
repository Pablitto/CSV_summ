/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv_summ;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Lipa
 */
public class Csv_summTest {
    
    
    public static final String INCORRECT_INPUT = "INCORRECT_INPUT";
    
    private static Csv_summ testObject;
    
    public Csv_summTest() {
    }
    

    @Before
    public void beforeTest(){
        testObject = new Csv_summ();
    }
    
    @After
    public void afterTest(){
        testObject = null;
    }
    
    
    @Test
    public void shouldReturnNullForNull(){    
        assertEquals(null, testObject.figureOutSumm(null));        
    }
    
    @Test
    public void shouldReturnNullForEmptyString(){
        assertEquals(null, testObject.figureOutSumm(""));
    }
    
    
    @Test
    public void shouldReturnNullForNotNumericSingleValue(){
        String notNumeric = "jeoj3kjs2334";
        assertEquals(null, testObject.figureOutSumm(notNumeric));
    }
    
    @Test
    public void shouldReturnSingleValueForSingleValue(){
        
        String numeric = "23143";
        assertTrue(testObject.figureOutSumm(numeric).equals(Integer.valueOf(numeric)));
    }
    
    @Test
    public void shouldReturnSummOfTwoNumerics(){
        Integer num1 = 4242;
        Integer num2 = 12345;
        
        Integer summ = num1 + num2;
        
        assertEquals(summ, testObject.figureOutSumm("" + num1 + ", " + num2));
    }
    
    
    @Test 
    public void shouldReturnSummForNumberOfNumerics(){
        
        int number = 100;
        int maxValue = 100000;
        
        String string = "";
        Integer summ = 0;
        
        for (int i = 0; i < number; i++) {
            
            Integer randomValue = (int)(Math.random() * maxValue);
            summ += randomValue;
            string += randomValue;
            if (i < number - 1){
                string += ",";
            }
        }
        
        assertEquals(summ, testObject.figureOutSumm(string)); 
    }
    
    
    @Test
    public void shouldReturnNullForNotNumericInput(){
        assertEquals(null, testObject.figureOutSumm("kjhkgjhgow"));
        assertEquals(null, testObject.figureOutSumm("kjhkgjhgow sfeqwfq"));
        assertEquals(null, testObject.figureOutSumm("kjhkgj2312h13gow"));
        assertEquals(null, testObject.figureOutSumm("kjhkgjhgow ewqr 12212"));
        assertEquals(null, testObject.figureOutSumm("1213,12313,e,123133"));
        
    }
    
    
    @Test
    public void shouldReturnNullForIncorrectSymbol(){
        assertEquals(null, testObject.figureOutSumm("313131.12313.12313"));
        assertEquals(null, testObject.figureOutSumm("313131,12313.12313"));
        assertEquals(null, testObject.figureOutSumm("313131;12313:12313"));
    }
    
    
    @Test
    public void shouldReturnNullForIncorrectSpaceInput(){        
        assertEquals(null, testObject.figureOutSumm("1212, , 21121"));
        assertEquals(null, testObject.figureOutSumm("1212, 1212 1212, 21121"));
    }
    
    
}

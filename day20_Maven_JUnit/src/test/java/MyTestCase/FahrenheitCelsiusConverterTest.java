package MyTestCase;

import com.JUnit.FahrenheitCelsiusConverter;


import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FahrenheitCelsiusConverterTest {
    @Test
    public void toCelsius(){
        //calling the class bu creating new object from it
        FahrenheitCelsiusConverter fahrenheitCelsiusConverter = new FahrenheitCelsiusConverter();
//        Double result = fahrenheitCelsiusConverter.toCelsius( -40.0);
        Object result = fahrenheitCelsiusConverter.toCelsius( -40.0);
        assertEquals(-40.0,result);
//        Double result1 = fahrenheitCelsiusConverter.toCelsius(3668.0);
        Object result1 = fahrenheitCelsiusConverter.toCelsius(3668.0);
        assertEquals(2020.0,result1);
        assertNull(fahrenheitCelsiusConverter.toCelsius(null));
    }

    @Test
    public void toFahrenheit(){
        //calling the class bu creating new object from it
        FahrenheitCelsiusConverter fahrenheitCelsiusConverter = new FahrenheitCelsiusConverter();
        assertNull(fahrenheitCelsiusConverter.toCelsius(null));
//        Double result = fahrenheitCelsiusConverter.toCelsius( -40.0);
        Object result = fahrenheitCelsiusConverter.toFahrenheit( -40.0);
        assertEquals(-40.0,result);
//        Double result1 = fahrenheitCelsiusConverter.toCelsius(3668.0);
        Object result1 = fahrenheitCelsiusConverter.toFahrenheit(2020.0);
        assertEquals(3668.0,result1);

    }



}

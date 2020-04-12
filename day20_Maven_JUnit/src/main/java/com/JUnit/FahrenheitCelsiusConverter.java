package com.JUnit;

public class FahrenheitCelsiusConverter {

        //create FahrenheitCelsiusConverter (class + test class)
            //F=(C*(9/5))+32
                //Double toCelsius(Double fahrenheit)
                //Double toFahrenheit(Double celsius)
                //return null for null inputs

    public Double toCelsius(Double fahrenheit){
        return fahrenheit==null? null: ((fahrenheit-32.0)*5.0)/9.0;
    }

    public Double toFahrenheit(Double celsius){
        return celsius==null? null: (celsius*(9.0/5.0))+32.0;
    }

}

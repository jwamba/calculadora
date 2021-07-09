/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wit.calculadoraapi.calculadora;
 
import java.math.BigDecimal;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author IT
 */

@Service
public class Operacoes {
    private BigDecimal a,b;
    private BigDecimal result;

    public Operacoes() {
    }

    public Operacoes(BigDecimal a, BigDecimal b) {
        this.a = a;
        this.b = b;
    }

    
    

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }
    
    
    
    public BigDecimal soma(){
        result =a.add(b);
        return result;
    }
    
    public BigDecimal subtracao(){
        result=a.subtract(b);
        return result;
    }
    
    public BigDecimal multiplicacao(){
        result=a.multiply(b);
        return result;
    }
    
    public BigDecimal divisao(){
        result=a.divide(b);
        return result;
    }

    @Override
    public String toString() {
        return "{\n"+"a: "+a+",\n b: "+b+",\n reuslt: "+result+" \n }"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

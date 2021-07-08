/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wit.calculadoraapi.controller;

import com.wit.calculadoraapi.calculadora.Operacoes;
import com.wit.calculadoraapi.services.RabbitMQReceiver;
import com.wit.calculadoraapi.services.RabbitMQSender;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author IT
 */
@RestController
@RequestMapping("/api")
public class OperacoesRest {
   
   @Autowired
   RabbitMQSender rabbitMQSender;

    
    @GetMapping("/soma")
    @ResponseBody
    public void somar(@RequestParam("a") BigDecimal a,@RequestParam("b") BigDecimal b){
        
        Operacoes op=new Operacoes(a, b);
       
        rabbitMQSender.send(op.toString());
        
    }
    
    @GetMapping("/subtrai")
    @ResponseBody
    public BigDecimal subtrair(@RequestParam("a") BigDecimal a,@RequestParam("b") BigDecimal b){
       
        rabbitMQSender.send(new Operacoes(a, b).toString());
        
        return new Operacoes(a, b).subtracao(); 
    }
    
    @GetMapping("/mutiplica")
    @ResponseBody
    public BigDecimal multiplicar(@RequestParam("a") BigDecimal a,@RequestParam("b") BigDecimal b){
       
        rabbitMQSender.send(new Operacoes(a, b).toString());
        
        return new Operacoes(a, b).multiplicacao(); 
    }
    
    @GetMapping("/divide")
    @ResponseBody
    public BigDecimal dividir(@RequestParam("a") BigDecimal a,@RequestParam("b") BigDecimal b){
       
        rabbitMQSender.send(new Operacoes(a, b).toString());
        
        return new Operacoes(a, b).divisao(); 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wit.calculadoraapi.controller;

import com.wit.calculadoraapi.calculadora.Operacoes;
import com.wit.calculadoraapi.services.RabbitMQSender;
import java.math.BigDecimal;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
   private static String rabbitmq ="";
    
    
    
    @GetMapping("/soma")
    @ResponseBody
    public String somar(@RequestParam("a") BigDecimal a,@RequestParam("b") BigDecimal b){
        
        Operacoes op=new Operacoes(a, b);
        op.soma();
       
        rabbitMQSender.send(op.toString());
        return rabbitmq;
        
    }
    
    @GetMapping("/subtrai")
    @ResponseBody
    public String subtrair(@RequestParam("a") BigDecimal a,@RequestParam("b") BigDecimal b){
       
        Operacoes op=new Operacoes(a, b);
        op.subtracao();
       
        rabbitMQSender.send(op.toString());
        return rabbitmq;
    }
    
    @GetMapping("/multiplica")
    @ResponseBody
    public String multiplicar(@RequestParam("a") BigDecimal a,@RequestParam("b") BigDecimal b){
       Operacoes op=new Operacoes(a, b);
        op.multiplicacao();
       
        rabbitMQSender.send(op.toString());
        return rabbitmq;
    }
    
    @GetMapping("/divide")
    @ResponseBody
    public String dividir(@RequestParam("a") BigDecimal a,@RequestParam("b") BigDecimal b){
       Operacoes op=new Operacoes(a, b);
        op.divisao();
       
        rabbitMQSender.send(op.toString());
        return rabbitmq; 
    }
    
    @RabbitListener(queues = "javainuse.queue")
    public void receive(String in) {
        rabbitmq=in;
        System.out.println("'" + in + "'");
    }
   
}

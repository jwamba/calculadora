/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wit.calculadoraapi.services;

/**
 *
 * @author IT
 */

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {
    
    @RabbitListener(queues = "javainuse.queue")
    public void receive(String in) {
        
        System.out.println("'" + in + "'");
    }
   

}

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

import com.wit.calculadoraapi.calculadora.Operacoes;
import java.math.BigDecimal;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(String msg) {
		rabbitTemplate.convertAndSend(exchange, routingkey, msg);
		System.out.println("sucesso");
                
	    
	}
}

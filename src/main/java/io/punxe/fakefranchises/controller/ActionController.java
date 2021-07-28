package io.punxe.fakefranchises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import io.punxe.fakefranchises.model.Action;
import io.punxe.fakefranchises.model.ActionType;
import io.punxe.fakefranchises.model.GameManager;

@Controller
public class ActionController {

    private GameManager gameManager;
    
    @Autowired
    public ActionController(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @MessageMapping("/game.action")
    @SendTo("/topic/public")
    public Action sendAction(@Payload Action action){

        return action;
    }
    @MessageMapping("/game.newUser")
    @SendTo("/topic/public")
    public Action registerNewUser(@Payload Action action){
        if(action.getType() == ActionType.CONNECT){
            System.out.println(action.getSender() + " connected");
        }
        return action;
    }
}
package io.punxe.fakefranchises.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private String code;
    private String host;
    private boolean gameStarted;
    private HashMap<String, Player> players = new HashMap<String, Player>();

    public Room(String code, String host){
        this.code = code;
        this.host = host;
        gameStarted = false;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }
    public String getHost(){
        return host;
    }
    public String getCode(){
        return code;
    }
    public HashMap<String, Player> getPlayers(){
        return players;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public void addPlayer(Player p){
        players.put(p.getName(), p);
    }

    public void removePlayer(String name){
        players.remove(name);
        if(host.equals(name)){
            if(players.size() == 0){
                host = "";
            }else{
                host = players.keySet().iterator().next();
            }
        }
        
    }

}

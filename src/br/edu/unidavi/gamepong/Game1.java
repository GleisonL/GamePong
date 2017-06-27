package br.edu.unidavi.gamepong;
import java.io.IOException;
import javaPlay.GameEngine;


public class Game1 {
     
    public static void main(String[] args) throws IOException {
         
        GameEngine.getInstance().addGameStateController(0, new Player());
        GameEngine.getInstance().setStartingGameStateController(0);
        GameEngine.getInstance().run();
        
    }
    
}

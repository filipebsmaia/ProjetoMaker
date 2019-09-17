package br.com.sevinhu.projetomaker;

import br.com.sevinhu.projetomaker.game.Game;
import br.com.sevinhu.projetomaker.led.LedAPI;

public class ProjetoMaker {

    private static Game game;
    private static LedAPI ledAPI;



    public static void setGame(Game g){
        game = g;
    }

    public static Game getGame(){
        return game;
    }

    public static void setLedAPI(LedAPI api){
        ledAPI = api;
    }

    public static LedAPI getLedAPI(){
        return ledAPI;
    }
}

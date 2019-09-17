package br.com.sevinhu.projetomaker.game;

public abstract class Game {

    private String name;
    private String desc;
    protected boolean inGame = false;

    public Game(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getGameName(){
        return name;
    }

    public abstract int getRes();

    public String getDescription(){
        return desc;
    }

}

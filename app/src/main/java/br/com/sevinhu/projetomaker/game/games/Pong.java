package br.com.sevinhu.projetomaker.game.games;

import br.com.sevinhu.projetomaker.R;
import br.com.sevinhu.projetomaker.game.Game;

public class Pong extends Game {

    public Pong() {
        super("pong", "o famoso jogo de pingpong.\npuzzle\n2 jogadores");

    }

    @Override
    public int getRes() {
        return R.drawable.pong;
    }
}

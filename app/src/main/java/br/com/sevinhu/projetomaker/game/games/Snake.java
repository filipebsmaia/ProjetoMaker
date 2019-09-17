package br.com.sevinhu.projetomaker.game.games;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

import br.com.sevinhu.projetomaker.ProjetoMaker;
import br.com.sevinhu.projetomaker.R;
import br.com.sevinhu.projetomaker.game.Game;
import br.com.sevinhu.projetomaker.led.LedAPI;

public class Snake extends Game {

    public Snake() {
        super("snake", "o famoso jogo da cobrinha.\npuzzle\n1 jogador");

    }

    @Override
    public int getRes() {
        return R.drawable.snake;
    }
}

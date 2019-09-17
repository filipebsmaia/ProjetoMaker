package br.com.sevinhu.projetomaker.game.games;

import br.com.sevinhu.projetomaker.R;
import br.com.sevinhu.projetomaker.game.Game;

public class Idle extends Game {

    public Idle() {
        super("Idle", "Apenas uma tela de espera.");

    }

    @Override
    public int getRes() {
        return R.drawable.idle;
    }
}

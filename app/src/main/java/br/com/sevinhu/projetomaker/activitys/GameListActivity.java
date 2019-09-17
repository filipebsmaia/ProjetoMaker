package br.com.sevinhu.projetomaker.activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.sevinhu.projetomaker.R;
import br.com.sevinhu.projetomaker.adapters.GameListAdapter;
import br.com.sevinhu.projetomaker.game.Game;
import br.com.sevinhu.projetomaker.game.games.Idle;
import br.com.sevinhu.projetomaker.game.games.Pong;
import br.com.sevinhu.projetomaker.game.games.Snake;

public class GameListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        ListView lv = findViewById(R.id.gamelist);

        List<Game> games = new ArrayList<>();
        games.add(new Snake());
        games.add(new Pong());
        games.add(new Idle());

        GameListAdapter adapter = new GameListAdapter(games, this);
        lv.setAdapter(adapter);
    }

}

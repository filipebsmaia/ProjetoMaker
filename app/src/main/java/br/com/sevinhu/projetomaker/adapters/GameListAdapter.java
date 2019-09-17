package br.com.sevinhu.projetomaker.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.sevinhu.projetomaker.ProjetoMaker;
import br.com.sevinhu.projetomaker.R;
import br.com.sevinhu.projetomaker.game.Game;
import br.com.sevinhu.projetomaker.util.BluetoothAPI;

public class GameListAdapter extends BaseAdapter {

    private final List<Game> games;
    private final Activity activity;

    public GameListAdapter(List<Game> games, Activity activity) {
        this.games = games;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return games.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.layout_gamelist, parent, false);
        Game game = games.get(position);

        TextView title = view.findViewById(R.id.game_title);
        TextView desc = view.findViewById(R.id.game_desc);
        ImageView logo = view.findViewById(R.id.game_image);

        title.setText(game.getGameName());
        desc.setText(game.getDescription());
        logo.setImageResource(game.getRes());

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() != MotionEvent.ACTION_DOWN){
                    return false;
                }
                ProjetoMaker.setGame(game);
                BluetoothAPI.getThread().send("Game: " + game.getGameName().toLowerCase());
                Log.d("[Game-ProjetoMaker]","Você selecionou o jogo " + game.getGameName() + "!");
                Toast.makeText(view.getContext(), "Você selecionou: " + game.getGameName(), Toast.LENGTH_LONG).show();

                return false;
            }
        });
        return view;
    }


}
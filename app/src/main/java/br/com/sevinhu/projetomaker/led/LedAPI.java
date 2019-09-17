package br.com.sevinhu.projetomaker.led;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.sevinhu.projetomaker.ProjetoMaker;
import br.com.sevinhu.projetomaker.util.BluetoothAPI;

public class LedAPI {

    private HashMap<Integer, List<Led>> leds = new HashMap<>();

    private int matriz = 1;

    public LedAPI(int matriz, int linhas, int colunas) {
        this.matriz = matriz;


        int current = 0;
        for (int i = 0; i < matriz; i++) {
            List<Led> mLeds = new ArrayList<>();
            for (int j = 0; j < linhas * colunas; j++) {
                mLeds.add(new Led(current));
                Log.d("[Led-ProjetoMaker]", "Led " + (current + 1) + " ->  " + j + " da matriz " + i);
                current++;
            }
            leds.put(i, mLeds);
        }

        ProjetoMaker.setLedAPI(this);
    }

    public Led getLed(int matriz, int led){
        return leds.get(matriz).get(led);
    }


}

package br.com.sevinhu.projetomaker.led;

import java.util.Collection;
import java.util.HashMap;

import br.com.sevinhu.projetomaker.util.BluetoothAPI;

public class Led {

    private static HashMap<Integer, Led> leds = new HashMap<>();


    private int pos;
    private LedColor color;

    public Led(int pos){
        this.pos = pos;
        this.color = new LedColor(255, 255, 255);
    }

    public int getPos(){
        return pos;
    }

    public int getR(){
        return this.color.getRed();
    }

    public int getG(){
        return this.color.getGreen();
    }

    public int getB(){
        return this.color.getBlue();
    }

    public Led off(){
        this.color.setRGB(0, 0 ,0);
        return this;
    }

    public Led setColor(LedColor color){
        this.color.setRGB(color.getRed(), color.getGreen(), color.getBlue());
        color = null;
        return this;
    }
    public Led setColor(int r, int g, int b){
        this.color.setRGB(r, g, b);
        return this;
    }

    public void show() {
        BluetoothAPI.sendData(this);
    }


    public static Collection<Led> getLeds(){
        return leds.values();
    }

    public static Led getLed(int pos){
        return leds.get(pos);
    }


}

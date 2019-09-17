package br.com.sevinhu.projetomaker.led;

public class LedColor {

    private int r = 0, g = 0, b = 0;

    public LedColor(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getRed(){ return r; }
    public int getGreen(){ return g; }
    public int getBlue(){ return b; }

    public void setRGB(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }
}

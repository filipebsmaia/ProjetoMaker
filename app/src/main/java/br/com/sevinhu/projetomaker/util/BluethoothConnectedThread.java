package br.com.sevinhu.projetomaker.util;

import android.bluetooth.BluetoothSocket;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import br.com.sevinhu.projetomaker.ProjetoMaker;
import br.com.sevinhu.projetomaker.game.games.Snake;

public class BluethoothConnectedThread extends Thread {

    private BluetoothSocket socket;
    private InputStream is;
    private OutputStream os;
    private BufferedReader br;

    public BluethoothConnectedThread(BluetoothSocket socket) {
        this.socket = socket;
        try {
            this.is = socket.getInputStream();
            this.os = socket.getOutputStream();
            this.br = new BufferedReader(new InputStreamReader(is));
        } catch (Exception e) {
            e.printStackTrace();
        }

        write("Hello World");
    }

    public void run() {
        if(socket == null || BluetoothAPI.getBluetoothSocket() == null || BluetoothAPI.getBluetoothSocket() != socket){
            cancel();
            Log.d("BluetoothSocket-ProjetoMaker", "O processo foi finalizado");
            return;
        }
        try {

            String message = br.readLine();
            if(message != null) {
                Log.d("BluetoothSocket-ProjetoMaker", "Menssagem recebida: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void write(byte[] bytes) {
        try {
            os.write(bytes);
        } catch (Exception e) {
        }
    }

    private void write(String message) {
        write((message).getBytes());
        Log.d("BluetoothSocket-ProjetoMaker", "Enviado: " + message);
    }

    public void send(String data){
        write(data);
    }

    public void cancel() {
        try {
            socket.close();
        } catch (Exception e) {
        }
    }
}
package br.com.sevinhu.projetomaker.util;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import br.com.sevinhu.projetomaker.led.Led;

public class BluetoothAPI {

    public static BluetoothAdapter bluetoothAdapter;
    public static UUID bluetoothUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    private static List<BluetoothDevice> paired = new ArrayList<>();
    private static BluetoothSocket socket;
    private static BluethoothConnectedThread socketThread;

    private static Gson gson = new Gson();


    public static List<BluetoothDevice> getPaired() {
        Set<BluetoothDevice> pairedDevices = BluetoothAPI.bluetoothAdapter.getBondedDevices();

        if (paired.size() != pairedDevices.size()) {
            paired.clear();
            pairedDevices.forEach(b -> {
                paired.add(b);
            });
        }

        return paired;
    }

    public static void setSocket(BluetoothSocket bluetoothSocket){
        socket = bluetoothSocket;
    }

    public static void setThread(BluethoothConnectedThread thread){
        socketThread = thread;
    }

    public static BluethoothConnectedThread getThread(){
        return socketThread;
    }

    public static BluetoothSocket getBluetoothSocket(){
        return socket;
    }



    public static void sendData(Led led) {
        socketThread.send(led.getPos() + ";" + led.getR() + ";" + led.getG() + ";" + led.getB());
    }
}

package br.com.sevinhu.projetomaker.activitys;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import br.com.sevinhu.projetomaker.R;
import br.com.sevinhu.projetomaker.game.Game;
import br.com.sevinhu.projetomaker.util.BluethoothConnectedThread;
import br.com.sevinhu.projetomaker.util.BluetoothAPI;

public class MainActivity extends AppCompatActivity {

    private final static int REQUEST_ENABLE_BT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BluetoothAPI.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (BluetoothAPI.bluetoothAdapter == null) {
            Toast.makeText(this, "Seu dispositivo não suporta bluetooth!",Toast.LENGTH_LONG);
            return;
        }

        checkBluetooth();
        loadMainScreenList();
    }


    public void goToApp(){
        Intent app = new Intent(this, GameListActivity.class);
        startActivity(app);
    }

    public void loadMainScreenList(){

        ListView lv = findViewById(R.id.gamelist);
        BaseAdapter ba = new BaseAdapter() {
            @Override
            public int getCount() {
                return BluetoothAPI.getPaired().size();
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
                View view = MainActivity.this.getLayoutInflater().inflate(R.layout.layout_bluetoothlist, parent, false);

                BluetoothDevice bd = BluetoothAPI.getPaired().get(position);
                TextView name = view.findViewById(R.id.device_name);
                TextView desc = view.findViewById(R.id.device_id);

                name.setText(bd.getName());
                desc.setText(bd.getAddress());

                LinearLayout back = (LinearLayout) view.findViewById(R.id.background);

                back.setOnTouchListener(new View.OnTouchListener() {

                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction() != MotionEvent.ACTION_DOWN){
                            return false;
                        }
                        try {
                            Toast.makeText(MainActivity.this, "Tentando fazer conexão com " + bd.getName() +  " (" + bd.getAddress() + "!", Toast.LENGTH_SHORT).show();
                            Thread.sleep(200);
                            Log.d("[Bluethooth-ProjetoMaker]","Tentando fazer conexão com " + bd.getName() + "!");

                            BluetoothDevice dev = BluetoothAPI.bluetoothAdapter.getRemoteDevice(bd.getAddress());
                            BluetoothAPI.setSocket(dev.createRfcommSocketToServiceRecord(BluetoothAPI.bluetoothUUID));
                            BluetoothAPI.bluetoothAdapter.cancelDiscovery();
                            BluetoothAPI.getBluetoothSocket().connect();
                            Log.d("[Bluethooth-ProjetoMaker]","A dispositivo se conectou com " + bd.getName() + "!");

                            if(BluetoothAPI.getBluetoothSocket().isConnected()){
                                Log.d("[Bluethooth-ProjetoMaker]","Tentando iniciar SocketThread...");
                                BluetoothAPI.setThread(new BluethoothConnectedThread(BluetoothAPI.getBluetoothSocket()));
                                Log.d("[Bluethooth-ProjetoMaker]","SocketThread iniciado com sucesso!");
                            }
                            BluetoothAPI.getThread().start();
                            Log.d("[Bluethooth-ProjetoMaker]","O modulu bluetooth foi corretamente inicializado!");
                            Toast.makeText(MainActivity.this, "A conexão com " + bd.getName() +  " (" + bd.getAddress() + ") foi bem sucedida!", Toast.LENGTH_SHORT).show();
                            goToApp();
                            return false;

                        } catch (Exception e){
                            Log.d("[Bluethooth-ProjetoMaker]","Conexão com " + bd.getName() + " falhou!");
                            //e.printStackTrace();
                            Toast.makeText(MainActivity.this, "A conexão com " + bd.getName() + " falhou!", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    }
                });
                return view;
            }
        };
        lv.setAdapter(ba);
    }


    private void checkBluetooth() {
        if (!BluetoothAPI.bluetoothAdapter.isEnabled()) {
            Intent req = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(req, REQUEST_ENABLE_BT);
        } else {
            loadMainScreenList();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ENABLE_BT) {
            switch (resultCode) {
                case Activity.RESULT_OK: {
                    loadMainScreenList();
                }
                break;
                case Activity.RESULT_CANCELED: {
                    checkBluetooth();
                }
                break;
                default: {
                    break;
                }
            }
        }
    }
}

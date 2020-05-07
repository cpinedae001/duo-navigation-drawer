package nl.psdcompany.duonavigationdrawer.example;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import Utiliti.ConnectedThread;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {

    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;
    private TextView mBluetoothStatus;
    private Button onBtn, offBtn, discover, pairedBtn;
    private CheckBox checkboxLED1;
    private ListView listViewDevices;
    private ArrayAdapter<String> mBTArrayAdapter;

    private Handler mHandler; // Our main handler that will receive callback notifications
    private ConnectedThread mConnectedThread; // bluetooth background worker thread to send and receive data
    private BluetoothSocket mBTSocket = null; // bi-directional client-to-client data path

    BluetoothAdapter mBTAdapter;

    public Settings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        view.setVerticalScrollBarEnabled(true);
        onBtn = view.findViewById(R.id.onBtn);
        offBtn = view.findViewById(R.id.offBtn);
        discover = view.findViewById(R.id.discover);
        pairedBtn = view.findViewById(R.id.pairedBtn);
        listViewDevices = view.findViewById(R.id.devicesListView);
        mBluetoothStatus = view.findViewById(R.id.bluetoothStatus);


        return view;
    }

    private void bluetoothOn(View view){
        if (!mBTAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            mBluetoothStatus.setText("Bluetooth enabled");
            Toast.makeText(getContext(),"Bluetooth turned on",Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getContext(),"Bluetooth is already on", Toast.LENGTH_SHORT).show();
        }
    }

}

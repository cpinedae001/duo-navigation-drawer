package nl.psdcompany.duonavigationdrawer.example;


import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {


    private Button scan;
    private Button off;
    private Button PairedBtn;
    private Button discover;
    private CheckBox checkboxLED1;
    private ListView devicesListView;

    public Settings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        view.setVerticalScrollBarEnabled(true);


        return view;
    }

}

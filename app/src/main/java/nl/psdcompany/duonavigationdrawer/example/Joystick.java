package nl.psdcompany.duonavigationdrawer.example;


import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Joystick extends Fragment {


    public Joystick() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


       //getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        View view = inflater.inflate(R.layout.fragment_joystick, container, false);
        view.setVerticalScrollBarEnabled(true);
        view.findViewById(R.id.buttonON).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Esta encendido", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}

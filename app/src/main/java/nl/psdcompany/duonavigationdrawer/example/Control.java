package nl.psdcompany.duonavigationdrawer.example;


import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import io.github.controlwear.virtual.joystick.android.JoystickView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Control extends Fragment {

    private TextView mTextViewAngleLeft;
    private TextView mTextViewStrengthLeft;
    private TextView mTextViewAngleRight;
    private TextView mTextViewStrengthRight;
    private TextView mTextViewCoordinateRight;

    public Control() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        View view = inflater.inflate(R.layout.fragment_control, container, false);

        mTextViewAngleLeft =  view.findViewById(R.id.textView_angle_left);
        mTextViewStrengthLeft = view.findViewById(R.id.textView_strength_left);

        JoystickView joystickLeft = view.findViewById(R.id.joystickView_left);
        joystickLeft.setOnMoveListener(new JoystickView.OnMoveListener() {
            @Override
            public void onMove(int angle, int strength) {
                mTextViewAngleLeft.setText(angle + "°");
                mTextViewStrengthLeft.setText(strength + "%");
                if(angle >=  45 && angle <= 135){
                    //Toast.makeText(getContext(), "adelante", Toast.LENGTH_SHORT).show();
                    System.out.println("adelante");
                }

                if(angle >= 225 && angle <= 315){
                    //Toast.makeText(getContext(), "atras", Toast.LENGTH_SHORT).show();
                    System.out.println("atras");
                }
            }
        });
        mTextViewAngleRight = view.findViewById(R.id.textView_angle_right);
        mTextViewStrengthRight = view.findViewById(R.id.textView_strength_right);


        final JoystickView joystickRight = view.findViewById(R.id.joystickView_right);
        joystickRight.setOnMoveListener(new JoystickView.OnMoveListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onMove(int angle, int strength) {
                mTextViewAngleRight.setText(angle + "°");
                mTextViewStrengthRight.setText(strength + "%");

                if(angle >=  135 && angle <= 225){
                    //Toast.makeText(getContext(), "adelante", Toast.LENGTH_SHORT).show();
                    System.out.println("izquierda");
                }

                if(angle >= 0 && angle<=45 || angle >=315){
                    //Toast.makeText(getContext(), "atras", Toast.LENGTH_SHORT).show();
                    System.out.println("derecha");
                }
            }
        });

        return view;
    }

}

package com.example.cdummy.ui.Programs;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cdummy.R;
import com.example.cdummy.result;

import java.io.IOException;
import java.io.InputStream;

public class Programs extends Fragment {
    public static int increment=1;
    private ProgramsViewModel mViewModel;
    public static Programs newInstance() {
        return new Programs();
    }

    void btn(Button button,String sno){
        String fname="ProgramName"+increment;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),result.class);
                intent.putExtra("key",sno);
                startActivity(intent);
            }
        });
        increment++;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.programs_fragment,container,false);

        btn(view.findViewById(R.id.button1), "1");
        btn(view.findViewById(R.id.button2), "2");
        btn(view.findViewById(R.id.button3), "3");
        btn(view.findViewById(R.id.button4), "4");
        btn(view.findViewById(R.id.button5), "5");
        btn(view.findViewById(R.id.button6), "6");
        btn(view.findViewById(R.id.button7), "7");
        btn(view.findViewById(R.id.button8), "8");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProgramsViewModel.class);
        // TODO: Use the ViewModel

    }
}
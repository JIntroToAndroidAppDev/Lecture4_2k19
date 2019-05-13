package com.myfirstandroidapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment {
    @BindView(R.id.textViewBlankFragment1)
    TextView textView;

    public BlankFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
        ButterKnife.bind(this,v);
        Bundle bundle = getArguments();
        String dataFromOtherFragment;
        try {
            dataFromOtherFragment =
                    bundle.getString("DATA");
        } catch (NullPointerException e){
            dataFromOtherFragment = "";
        }
        if (dataFromOtherFragment.length() > 1) {
            textView.setText(dataFromOtherFragment);
        }
        return v;
    }

}

package com.myfirstandroidapp;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {
    private PassInformationToActivity activityInstance;

    @BindView(R.id.button_goto_fragment1)
    Button buttonGoToFragment1;

    @OnClick(R.id.button_goto_fragment1)
    void onClickGoToFragmentOne() {
        /*
        NEVER DO THIS!!!!!!!!!!! LIKE EVER!!!!!!!!!
        BlankFragment1 blankFragment1 = new BlankFragment1();
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layoutForShowingFragment,
                        blankFragment1,
                        null)
                .commit();*/
        try {
            this.activityInstance
                    .changeToAnotherFragment("Hello From the Other Side");
        } catch (NullPointerException e) {
            Log.e(this.getClass().getName(), "Some other class other than the exact class that we" +
                    " want, has been passed in");
        }
    }

    public BlankFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            if (context instanceof FragmentCreatorActivity) {
                this.activityInstance =
                        (PassInformationToActivity) context;
            } else {
                this.activityInstance = null;
            }
        } catch (ClassCastException e) {
            Log.e(this.getClass().getName(), "Sorry Class doesn't implement the required " +
                    "interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        ButterKnife.bind(this,v);

        return v;
    }

    public interface PassInformationToActivity {
        void changeToAnotherFragment(String someDataToBePassed);
    }
}
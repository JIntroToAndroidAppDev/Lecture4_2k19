package com.myfirstandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class FragmentCreatorActivity extends AppCompatActivity
implements BlankFragment2.PassInformationToActivity {

    @BindView(R.id.switchToFragment)
    Button buttonSwitchToFragment;

    @OnClick(R.id.switchToFragment)
    void switchToFragmentOnButtonClick(){
        BlankFragment2 blankFragment2 = new BlankFragment2();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction
                .add(R.id.layoutForShowingFragment,
                        blankFragment2,
                        null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_creator);
        ButterKnife.bind(this);
        /*Bundle bundle = new Bundle();
        bundle.putString("DATA_KEY","Data to Be Sent");
        Intent intent =
                new Intent(this, MainActivity.class);
        intent.putExtra("DATA_KEY","Data to Be Sent");
        intent.putExtras(bundle);
        startActivity(intent);*/
    }

    @Override
    public void changeToAnotherFragment(String dataToBePassed) {
        BlankFragment1 blankFragment1 = new BlankFragment1();
        Bundle bundle = new Bundle();
        bundle.putString("DATA", dataToBePassed);
        blankFragment1.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction
                .add(R.id.layoutForShowingFragment,
                        blankFragment1,
                        null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
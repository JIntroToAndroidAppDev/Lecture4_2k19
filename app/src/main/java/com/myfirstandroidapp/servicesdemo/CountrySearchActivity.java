package com.myfirstandroidapp.servicesdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.myfirstandroidapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountrySearchActivity extends AppCompatActivity implements MyHandler.IUIUpdater {
    @BindView(R.id.btn_get_country_from_webservice)
    Button btnGetCountryFromWebService;

    @BindView(R.id.tv_container_country_name)
    EditText countryNameEntryField;

    @BindView(R.id.tv_obtained_country)
    TextView resultingCountry;

    private void getCountryFromWebService() {
        String countryNameForGetting = countryNameEntryField
                .getText()
                .toString();
        Handler handler = new MyHandler(this);

        Intent intent = new Intent(getApplicationContext(),
                MyRESTRequestService.class);
        intent.putExtra("COUNTRY_NAME", countryNameForGetting);
        intent.putExtra("HANDLER", new Messenger(handler));
        startService(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_search);
        ButterKnife.bind(this);

        btnGetCountryFromWebService.setOnClickListener(v ->
                getCountryFromWebService());
    }

    @Override
    public void updateTheUi(Message message) {
        resultingCountry.setText((String)message.obj);
    }
}
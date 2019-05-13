package com.myfirstandroidapp.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.myfirstandroidapp.MyApplication;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRESTRequestService extends Service {
    private static final String TAG = "MyRESTRequestService";
    private Country country = null;
    private Message message = new Message();

    public MyRESTRequestService() {}

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String countryName = (String) intent
                .getCharSequenceExtra("COUNTRY_NAME");
        MyApplication myApplication = (MyApplication) getApplication();
        ExecutorService threadPool = myApplication.getThreadPool();

        MyDatabase myDatabase = MyDatabase.getAppDatabase(getApplicationContext());
        CountryDAO countryDAO = myDatabase.getCountryDAO();

        Messenger handlerMessenger = intent
                .getParcelableExtra("HANDLER");

        threadPool.execute(() -> {
            try {
                country = countryDAO.getCountryByName(countryName);

                if (country == null) {
                    country = new HTTPHandler()
                            .getCountryByName(countryName);
                    countryDAO.insertCountryToDb(country);
                }

                message.obj = country.toString();
                handlerMessenger.send(message); // instead of handler.sendMessage(message);
                Log.d(TAG, country.toString());
                stopSelf();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        //---Android---//
        // Activities
        // Fragments
        // Fragment to Activity Communication
        // Fragment to Fragment Communication
        // Room
        // Recycler View (RecyclerView adapter, RecyclerView ItemClickListener)
        // Services (Background services, Passing data from Service to Activity)

        //---Java---//
        // Strings (concatenation, comparison, string cache or interning strings, StringBuilder)
        // Java Wrapper classes
        // Java Collections (Lists(ArrayList, LinkedList), Sets(HashSet), Maps(HashMap,
        // LinkedHashMap))
        // Java Concurrency (Runnable, Thread, ThreadPool, Future)
        // Java IO (Network IO, Reading from and Writing to IOStreams)
        // Making HTTP requests and reading HTTP responses using Java
        // JSON parsing (you can use your favourite JSON Parsing library. I used FasterXML Jackson)
        return null;
    }
}
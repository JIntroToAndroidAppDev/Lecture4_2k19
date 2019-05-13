package com.myfirstandroidapp.servicesdemo;

import android.os.Handler;
import android.os.Message;

public class MyHandler extends Handler {

    IUIUpdater iuiUpdater;

    public MyHandler(IUIUpdater iuiUpdater) {
        this.iuiUpdater = iuiUpdater;
    }

    @Override
    public void handleMessage(Message msg) {
        iuiUpdater.updateTheUi(msg);
    }

    public interface IUIUpdater {
        void updateTheUi(Message message);
    }
}
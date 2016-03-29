package practicaltest01var05.eim.systems.cs.pub.ro.practicaltest01var05;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Date;

public class PracticalTest01Var05Service extends Service {
    public PracticalTest01Var05Service() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            Thread.sleep(1000);

        }
        catch (Exception e) {

        }
        String seq = intent.getStringExtra("seq");
        Intent intentSend = new Intent();
        intentSend.putExtra("message", new Date(System.currentTimeMillis()) + " " +  seq);
        intentSend.setAction("ANACTION");
        sendBroadcast(intentSend);
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

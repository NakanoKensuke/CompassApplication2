package com.example.admin.myapplication2;

import android.hardware.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

     private SensorManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (SensorManager)getSystemService(SENSOR_SERVICE);
        List sensors = manager.getSensorList(Sensor.TYPE_ORIENTATION);

        if(sensors.size() > 0) {
            Sensor sensor = (Sensor) sensors.get(0);
            manager.registerListener(this,sensor, SensorManager.SENSOR_DELAY_FASTEST);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1){
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        setContentView(new MainView(getApplication(),event.values[0]));
    }

    //@Override
    protected void onPause() {
        super.onPause();
        //センサーマネージャのリスナ登録破棄
        manager.unregisterListener(this);
    }

    private final int MENU_ID1 = Menu.FIRST;

    //@Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);

        MenuItem item0 = menu.add(0, MENU_ID1, 0, R.string.app_name);

        item0.setIcon(android.R.drawable.ic_menu_close_clear_cancel);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ID1:
                // 各ボタンが押されたときの処理を記述
                Toast toast = Toast.makeText(this, "Activity終了", Toast.LENGTH_SHORT);
                toast.show();
                finish();
                return true;
        }
        return true;
    }
}
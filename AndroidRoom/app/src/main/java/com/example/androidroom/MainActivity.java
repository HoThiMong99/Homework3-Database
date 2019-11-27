package com.example.androidroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    UserDatabase db;
    TextView txtuser;
    RecyclerView RV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtuser = findViewById(R.id.text_user);
        RV = findViewById(R.id.rv_display);
        db = Room.databaseBuilder(getApplicationContext(),
                UserDatabase.class, "database_name").build();

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                User user = new User("nam");
                db.userDao().insert(user);

                final List<User> users = db.userDao().getAll();
                Log.i("TAGss", "size" + users.size());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayuser(users);
                    }
                });
                return  null;
            }
        }.execute();
    }
    void  displayuser(List<User> users){
        String str  = new String();
        for (int i = 0; i < users.size(); i++){
            User user = users.get(i);
            str+= user.name + "\n";
        }
        txtuser.setText(str);
    }
}


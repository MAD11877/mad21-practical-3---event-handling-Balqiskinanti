package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";
    User user;
    TextView nameTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUser();
        onFollow();
        changeName();
        Log.v(TAG, "Create");
    }
    private void initUser(){
        user = new User("MAD",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                0,
                false);
        nameTxt = findViewById(R.id.name);
        TextView descTxt = findViewById(R.id.description);
        nameTxt.setText(user.getName());
        descTxt.setText(user.getDescription());
    }
    private void onFollow(){
        Button followBtn = findViewById(R.id.follow);
        followBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(user.isFollowed()) {
                    user.setFollowed(false);
                    followBtn.setText("Follow");
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                }
                else{
                    user.setFollowed(true);
                    followBtn.setText("Unfollow");
                    Toast.makeText(getApplicationContext(),"Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void changeName(){
        Intent receivingEnd = getIntent();
        String randomInt = receivingEnd.getStringExtra("randomInt");
        user.setName(user.getName() + " " + randomInt);
        nameTxt.setText(user.getName());
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG, "Start");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "Resume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "Pause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "Stop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "Destroy");
    }
}
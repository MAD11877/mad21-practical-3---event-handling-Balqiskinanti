package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG = "List Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        alert();
        Log.v(TAG, "Create");
    }
    private void alert() {
        ImageView randomImg = findViewById(R.id.random);
        randomImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(true);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent viewMain = new Intent(ListActivity.this, MainActivity.class);
                        int randomInt = new Random().nextInt();
                        viewMain.putExtra("randomInt", Integer.toString(randomInt));
                        startActivity(viewMain);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
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
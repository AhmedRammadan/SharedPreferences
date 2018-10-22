package comasdfasdf.kamel.www.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView tv_name,tv_age;
    String name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_name=findViewById(R.id.et_name);
        tv_age=findViewById(R.id.et_age);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        age  = intent.getStringExtra("age");

            tv_name.setText(name);
            tv_age.setText(age);

    }
}

package comasdfasdf.kamel.www.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_age;
    String name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.et_name);
        et_age=findViewById(R.id.et_age);
    }

    public void save(View view) {
        name=et_name.getText().toString();
        age=et_age.getText().toString();
        SharedPreferences.Editor editor =  getSharedPreferences("file_save",MODE_PRIVATE).edit();
        editor.putString("name",name);
        editor.putString("age",age);
        editor.apply();
    }

    public void get(View view) {
        SharedPreferences mypreferences=getSharedPreferences("file_save",MODE_PRIVATE);
        String getname = mypreferences.getString("name",null);
        String getage = mypreferences.getString("age",null);
        if (!et_name.getText().toString().equals("") && !et_age.getText().toString().equals("")){
            Intent intent =new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("name",getname);
            intent.putExtra("age",getage);
            startActivity(intent);
        }
        else if (et_name.getText().toString().equals("") && et_age.getText().toString().equals("")){
            Toast.makeText(this, "Pleas Enter Your Name and age", Toast.LENGTH_SHORT).show();
        }
        else  if(et_name.getText().toString().equals("")) {
            Toast.makeText(this, "Pleas Enter Your Name", Toast.LENGTH_SHORT).show();
        }else if(et_age.getText().toString().equals("")) {
            Toast.makeText(this, "Pleas Enter Your age", Toast.LENGTH_SHORT).show();
        }
    }
}

package sg.edu.rp.c346.practicalquiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etname;
    EditText etage;
    Spinner spclass;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = findViewById(R.id.editTextName);
        etage = findViewById(R.id.editTextAge);
        btnSave = findViewById(R.id.buttonsave);
        spclass = findViewById(R.id.spinnerclass);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT);
                toast.show();
            }
        });







    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etname.getText().toString();
        int intAge = Integer.parseInt(etage.getText().toString());
        int Spinner = spclass.getSelectedItemPosition();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", strName);
        prefEdit.putInt("age", intAge);
        prefEdit.putInt("Spinner",Spinner);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String displayName = prefs.getString("name", "");
        int displayAge = prefs.getInt("age", 0);
        int spinner = prefs.getInt("Spinner",0);
        etname.setText(displayName);
        etage.setText(Integer.toString(displayAge));
        spclass.setSelection(spinner);


    }




}

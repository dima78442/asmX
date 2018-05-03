package com.dima.asmx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class compiler_room extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    Button button;
    MyDialog dlg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compiler_room);
        EditText editText1 =(EditText)findViewById(R.id.etMessageBox);
        EditText editText2 =(EditText)findViewById(R.id.etTweetReview);
        button = (Button)findViewById(R.id.theReviewBarButton);
        button.setText("RUN");
        dlg1 = new MyDialog();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dialog

                dlg1.show(getFragmentManager(), "dlg1");
            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.spinnerSort);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
}

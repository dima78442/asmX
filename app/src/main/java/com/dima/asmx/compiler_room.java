package com.dima.asmx;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class compiler_room extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    Button button;
    MyDialog dlg1;
    public Context context = this;
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
               // dlg1.show(getFragmentManager(), "dlg1");
            }
        });

    }
}

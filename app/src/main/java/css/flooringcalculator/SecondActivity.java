// SecondActivity.java
package css.flooringcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    //Written by ChatGPT.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double length = intent.getDoubleExtra("length", 0.0);
        double width = intent.getDoubleExtra("width", 0.0);

        double area = length * width;

        TextView textViewDimensions = findViewById(R.id.textViewDimensions);
        TextView textViewArea = findViewById(R.id.textViewArea);

        String dimensionsText = "Room Dimensions: " + length + " x " + width;
        String areaText = "Area: " + area;

        textViewDimensions.setText(dimensionsText);
        textViewArea.setText(areaText);

        //Optional #1 Coded by me.
        Intent resultIntent = new Intent();
        resultIntent.putExtra("area", area);
        setResult(RESULT_OK, resultIntent);

        Button buttonReturn = findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

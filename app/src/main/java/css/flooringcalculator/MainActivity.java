// MainActivity.java
package css.flooringcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//Written with ChatGPT.
public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SECOND_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateArea(View view) {
        EditText editTextLength = findViewById(R.id.editTextLength);
        EditText editTextWidth = findViewById(R.id.editTextWidth);

        double length = Double.parseDouble(editTextLength.getText().toString());
        double width = Double.parseDouble(editTextWidth.getText().toString());

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("length", length);
        intent.putExtra("width", width);
        startActivityForResult(intent, REQUEST_CODE_SECOND_ACTIVITY);
    }

    //Written by myself for option #1.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SECOND_ACTIVITY && resultCode == RESULT_OK && data != null) {
            double area = data.getDoubleExtra("area", 0.0);
            updateUIWithArea(area);
        }
    }

    //Written by myself for option #1.
    private void updateUIWithArea(double area) {
        TextView textViewAreaResult = findViewById(R.id.textViewAreaResult);
        textViewAreaResult.setText("Final Flooring Area Result: " + "\n" + area);
        Toast.makeText(this, "Flooring Area: " + area, Toast.LENGTH_SHORT).show();
    }
}

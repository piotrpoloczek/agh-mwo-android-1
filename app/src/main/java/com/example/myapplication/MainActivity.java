package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int _counter = 0;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterTextView = findViewById(R.id.counter_text);
        updateCounter();
    }

    public void incrementCounter(View view) {
        _counter++;
        updateCounter();
    }

    public void decrementCounter(View view) {
        _counter--;
        updateCounter();
    }

    public void setCounter(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ustaw wartość licznika");

        final TextView input = new TextView(this);
        final View dialogView = getLayoutInflater().inflate(R.layout.dialog_input, null);
        final TextView inputField = dialogView.findViewById(R.id.input_value);

        builder.setView(dialogView);

        builder.setPositiveButton("OK", (dialog, which) -> {
            try {
                int value = Integer.parseInt(inputField.getText().toString());
                _counter = value;
                updateCounter();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Nieprawidłowa liczba!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Anuluj", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    private void updateCounter() {
        counterTextView.setText(String.valueOf(_counter));
    }
}

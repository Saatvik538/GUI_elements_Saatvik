package com.example.gui_elements_saatvik;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int count = 1;
    int num = 0;
    EditText name;
    Button incrementButton;
    TextView greetingDisplay;
    String[] planets;
    RadioButton leftRadBut, rightRadBut;
    RadioButton multiplyradbut;
    RadioButton divideradbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        multiplyradbut = findViewById(R.id.radio_m);
        divideradbut = findViewById(R.id.radio_d);
        incrementButton = findViewById(R.id.increment_button);
        greetingDisplay = findViewById(R.id.greeting_textview);
        planets = getResources().getStringArray(R.array.planets_array);
        leftRadBut = findViewById(R.id.radio_left);
        rightRadBut = findViewById(R.id.radio_right);
        name = (EditText) findViewById(R.id.edit_name);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.out.println("incrementing"+ ++num);
//                greetingDisplay.setText(getString(R.string.likes_count,num));
                if(rightRadBut.isChecked())
                    num = ++num% planets.length;
                greetingDisplay.setText(planets[num]);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void decrement(View view) {
//        System.out.println("decrementing"+ --count);
//        greetingDisplay.setText(getString(R.string.likes_count,count));
        if(leftRadBut.isChecked())
            if(--num<0) num = planets.length-1;
        greetingDisplay.setText(planets[num]);
    }

    public void push(View view) {
        greetingDisplay.setText(name.getText());
    }

    public void multiply(View view) {
        if(multiplyradbut.isChecked()) {
            count *=Integer.parseInt(String.valueOf(name.getText()));
        }
        greetingDisplay.setText(""+count);
    }

    public void divide(View view) {
        if(divideradbut.isChecked()) {
            if ((count)>1) count /= Integer.parseInt(String.valueOf(name.getText()));
        }
        greetingDisplay.setText(""+count);
    }
}
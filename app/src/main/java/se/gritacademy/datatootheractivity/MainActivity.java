package se.gritacademy.datatootheractivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.editTextText);
        et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    Log.i("alrik", "unfocused");

            }
        });
        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_GO:
                        Log.i("alrik", "go");
                        break;
                    case EditorInfo.IME_ACTION_DONE:
                        Log.i("alrik", "done");
                        break;
                    case EditorInfo.IME_ACTION_NEXT:
                        Log.i("alrik", "next");
                        break;
                    case EditorInfo.IME_ACTION_PREVIOUS:
                        Log.i("alrik", "prev");
                        return true;
                }
                return false;
            }
        });

        btn = findViewById(R.id.button);
        btn.setOnClickListener((e) -> {
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            i.putExtra("Key", et.getText().toString());
            startActivity(i);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
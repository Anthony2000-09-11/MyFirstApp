package pe.edu.tecsup.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private TextView messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        Button searchButton = findViewById(R.id.searchButton);
        messageText = findViewById(R.id.messageText);

        // Asignando un metodo click al boton
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar();
            }
        });

    }

    static List<String> ips = new ArrayList<>();
    static {
        ips.add("192.168.116.100");
        ips.add("192.168.116.10");
        ips.add("192.168.116.200");
    }

    private void buscar(){
        Log.d("MainActivity", "Buscando IP...");
        
        String ip = inputText.getText().toString();
        
        if(ip.isEmpty()){
            Toast.makeText(this, "Debe indicar una IP", Toast.LENGTH_SHORT).show();
            return;
        }

        if(ips.contains(ip)){
            messageText.setText("Ip encontrada!!!");
        }else{
            messageText.setText("IP NO registrada.");
        }

    }
}

package javi.ardid.ejercicio1sp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javi.ardid.ejercicio1sp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnLoginMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.txtUsuarioMain.getText().toString().equalsIgnoreCase("Progresa")
                    && binding.txtContraseA.getText().toString().equals("Alumno")){
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                }else{
                    Toast.makeText(MainActivity.this, "Datos incorrectos",Toast.LENGTH_SHORT);
                }
            }
        });


    }
}
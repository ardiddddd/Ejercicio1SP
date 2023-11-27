package javi.ardid.ejercicio1sp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javi.ardid.ejercicio1sp.configuracion.Constantes;
import javi.ardid.ejercicio1sp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private SharedPreferences sp;//SHARED PREFERENCES : PARA GUARDAR INFO ESCRITA POR EL USUARIO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sp = getSharedPreferences(Constantes.USUARIOS, MODE_PRIVATE);


        comprobarLogin();
        binding.btnLoginMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.txtUsuarioMain.getText().toString().equalsIgnoreCase("Progresa")
                    && binding.txtContrasenya.getText().toString().equals("Alumno")){
                    SharedPreferences.Editor editor = sp.edit();
                    String codificado = codificarContrasenya();
                    editor.putString(Constantes.USUARIO, binding.txtUsuarioMain.getText().toString());
                    editor.putString(Constantes.CONTRASENYA, codificado);
                    editor.apply();
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                    binding.txtUsuarioMain.setText("");
                    binding.txtContrasenya.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "Datos incorrectos",Toast.LENGTH_SHORT);
                }
            }
        });


    }

    private String codificarContrasenya() {
        char[] caracteres = binding.txtContrasenya.getText().toString().toLowerCase().toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            switch (caracteres[i]){
                case 'a':caracteres[i]='r';
                break;
                case 'e':caracteres[i]='t';
                    break;
                case 'i':caracteres[i]='y';
                    break;
                case 'o':caracteres[i]='p';
                    break;
                case 'u':caracteres[i]='j';
                    break;
                default:
                    caracteres[i] += 2;
                    break;
            }

        }
        return String.valueOf(caracteres);
    }

    private void comprobarLogin() {
      /*  if(sp.getString(Constantes.USUARIO, "").equalsIgnoreCase("Progresa")
        && sp.getString(Constantes.CONTRASENYA,"").equals("Alumno")){
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }*/
        if(sp.contains(Constantes.USUARIO) &&
                sp.contains(Constantes.CONTRASENYA)){
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }


    }
}
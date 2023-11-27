package javi.ardid.ejercicio1sp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import javi.ardid.ejercicio1sp.configuracion.Constantes;
import javi.ardid.ejercicio1sp.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sp = getSharedPreferences(Constantes.USUARIOS, MODE_PRIVATE);

        binding.lbUsuarioSecond.setText(sp.getString(Constantes.USUARIO,""));
        String contrasenya=descodificarContrasenya();
        binding.lbContrasenyaSecond.setText(contrasenya);
        binding.btnLogoOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.apply();
                finish();
            }
        });
    }

    private String descodificarContrasenya() {
        char[] caracteres = sp.getString(Constantes.CONTRASENYA,"").toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            switch (caracteres[i]){
                case 'R':caracteres[i]='a';
                    break;
                case 'T':caracteres[i]='e';
                    break;
                case 'Y':caracteres[i]='i';
                    break;
                case 'P':caracteres[i]='o';
                    break;
                case 'J':caracteres[i]='u';
                    break;
                default:
                    caracteres[i] -= 2;
                    break;
            }

        }
        return String.valueOf(caracteres);
    }
}
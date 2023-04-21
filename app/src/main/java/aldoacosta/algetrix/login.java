package aldoacosta.algetrix;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText inputNameUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setTheme(R.style.AppTheme);
        inputNameUsuario = (EditText) findViewById(R.id.editUsuario);
        SharedPreferences datos = getSharedPreferences("misDatos", MODE_PRIVATE);

        if(!datos.getString("Usuario", " ").equals(" ")){
            Intent app = new Intent(this, app.class);
            startActivity(app);
            finish();
        }

    }

    public void iniciar(View v){
        String usuario = inputNameUsuario.getText().toString();

        if (!usuario.isEmpty() && usuario.length() >= 4){
            Toast.makeText(login.this, "¡Bienvenido " + usuario + "!", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = getSharedPreferences("misDatos", MODE_PRIVATE).edit();
            editor.putString("Usuario", usuario);
            editor.apply();
            Intent app = new Intent(this, app.class);
            app.putExtra("Usuario",usuario);
            startActivity(app);
        }else{
            Toast.makeText(login.this, "Usuario invalido", Toast.LENGTH_SHORT).show();
        }
    }

}

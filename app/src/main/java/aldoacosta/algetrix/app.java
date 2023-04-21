package aldoacosta.algetrix;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class app extends AppCompatActivity {
    TextView lblUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        lblUsuario = (TextView) findViewById(R.id.lblUsuario);
        SharedPreferences datos = getSharedPreferences("misDatos", MODE_PRIVATE);
        String usuario = datos.getString("Usuario", null);
        lblUsuario.setText(usuario);

    }

    public void cerrarSesion(View v){
        final AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("Si cierras sesión perderas sus datos, ¿Desea continuar?")
                .setCancelable(false)
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent login = new Intent(getBaseContext(), aldoacosta.algetrix.login.class);
                        SharedPreferences.Editor editor = getSharedPreferences("misDatos", MODE_PRIVATE).edit();
                        editor.putString("Usuario", " ");
                        editor.apply();
                        startActivity(login);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog titulo = alerta.create();
        titulo.setTitle("Cerrar Sesión");
        titulo.show();
    }
}

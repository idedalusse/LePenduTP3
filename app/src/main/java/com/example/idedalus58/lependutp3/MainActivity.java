package com.example.idedalus58.lependutp3;
/*
By Ben senouci Nidhal 2018
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

//===================================== Declaration des variable =================================//

    private LinearLayout container;
    private Button btn_send;
    private TextView lettres_tapees;
    private ImageView imageView;
    private EditText letter;
    //********$************//
    private  Socket socket;
    private String mottemporaire;
    private String mot;
    int nombreErreur;
    //============================================================================================//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // new ClientConnexion(this).execute();

    //============================= récupérer des éléments du XML avec les id ====================//

        container = findViewById(R.id.mot_container);
        btn_send = findViewById(R.id.btn_send);
        letter =  findViewById(R.id.letre);
        imageView =  findViewById(R.id.pendu);
        lettres_tapees = findViewById(R.id.lettres_tapees);
        //lettres_tapees.setText("ssss");

    //==================== Pour le click du bouton après avoir écrit la lettre ===================//

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mottemporaire = mot;
               // new ClientComunication(MainActivity.this,socket).execute(letter.getText().toString());
            }
        });
    }
    //======================= Retour les donner du serveur =======================================//

    public void retourConnexion (String s, Socket socket){
        lettres_tapees.setText(s);
        mot = s;
        this.socket = socket;
    }
    //= Comparaison des lettres entre et affichage de morceau du pondu en cas de mauvaises réponses=//

    public void retourClientComunication (String s ){

        lettres_tapees.setText(s);
        mot = s;
        if(mot.equalsIgnoreCase(mottemporaire)){
            nombreErreur++;
            switch (nombreErreur){
                case 1:{
                    imageView.setImageResource(R.drawable.pendu2);
                    break;
                }
                case 2:{
                    imageView.setImageResource(R.drawable.pendu3);
                    break;
                }
                case 3:{
                    imageView.setImageResource(R.drawable.pendu4);
                    break;
                }
                case 4:{
                    imageView.setImageResource(R.drawable.pendu5);
                    break;
                }
                case 5:{
                    imageView.setImageResource(R.drawable.pendu6);
                    break;
                }
                case 6:{
                    lettres_tapees.setText("Vous avez perdus");
                    imageView.setImageResource(R.drawable.pendu7);
                    break;
                }
            }
        }
    }
    //============================================================================================//
}

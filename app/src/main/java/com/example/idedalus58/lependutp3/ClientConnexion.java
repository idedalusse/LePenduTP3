package com.example.idedalus58.lependutp3;

/*
By Ben senouci Nidhal 2018
 */
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientConnexion extends AsyncTask<String,Void,String> {

    //============================= Declaration des variables ====================================//

    private MainActivity mainActivity;
    private Socket socket;
    //**********$**********//
    public ClientConnexion(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }
    //========================== Communication avec le serveur ===================================//
    @Override
    protected String doInBackground(String... strings) {
        try {
            socket = new Socket("10.0.2.2", 123);
            BufferedReader x = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            return x.readLine();
        }catch(IOException e){
            // afficher dans un log les messages d'erreurs
            e.printStackTrace();
        }
        return null;
    }
    //============================= Appelle Quand la methode est complaite  ======================//
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        mainActivity.retourConnexion(s, socket);
    }
    //============================================================================================//

}

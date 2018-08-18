package com.example.idedalus58.lependutp3;
/*
By Ben senouci Nidhal 2018
 */
import android.os.AsyncTask;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientComunication extends AsyncTask <String,Void, String>{

    //============================ Declaration des variables ==================================//

    private MainActivity mainActivity;
    private Socket socket;
    //***************$****************//
    public ClientComunication(MainActivity mainActivity, Socket socket){
        this.mainActivity = mainActivity;
        this.socket= socket;
    }
    //==================== envoyer les lettres au serveur et recevoir la reponse =================//
    @Override
    protected String doInBackground(String... strings) {
        try{
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            out.println(strings[0]);

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    //============================================================================================//
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mainActivity.retourClientComunication(s);
    }
    //============================================================================================//
}

package com.example.ssh;

import com.google.android.gms.common.api.Status;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @POST("/login")
    Call<LoginResult> executeLogin(@Body HashMap<String,String> map);

    @POST("/voti")
    Call<ArrayList<Voto>> executeVoti(@Body HashMap<String,String> map);

    @POST("/note")
    Call<ArrayList<Nota>> executeNote(@Body HashMap<String,String> map);

    @POST("/avvisi")
    Call<ArrayList<Avviso>> executeAvviso(@Body HashMap<String,String> map);

    @POST("/malattie")
    Call<ArrayList<Malattia>> executeMalattia(@Body HashMap<String,String> map);

    @POST("/problemi")
    Call<ArrayList<ProblemaApprendimento>> executeProblema(@Body HashMap<String,String> map);

    @POST("/inserimento_avvisi")
    Call<Void> executeInsAvvisi(@Body HashMap<String,String> map);

    @POST("/inserimento_malattia")
    Call<Void> executeInsMalattia(@Body HashMap<String,String> map);

    @POST("/inserimento_problema")
    Call<Void> executeInsProblema(@Body HashMap<String,String> map);

    @POST("/invia_posizione")
    Call<Void> executeInviaPosizione(@Body HashMap<String,String> map);

    @POST("/ottieni_posizione")
    Call<ArrayList<Posizione>> executeOttieniPosizione(@Body HashMap<String,String> map);

    @POST("/stato")
    Call<ArrayList<StatoSalute>> executeStato(@Body HashMap<String,String> map);

    @POST("/inserimento_stato")
    Call<Void> executeInsStato(@Body HashMap<String,String> map);



}

package com.example.ssh;

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

    @POST("/insegnante")
    Call<ArrayList<Persona>> executeInsegnante();

}

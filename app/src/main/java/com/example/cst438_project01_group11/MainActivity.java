package com.example.cst438_project01_group11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import com.android.volley.Response;
import com.example.cst438_project01_group11.models.Pokemon;
import com.example.cst438_project01_group11.models.PokemonRes;
import com.example.cst438_project01_group11.pokiapi.PokiapiService;

import org.chromium.base.Callback;
import org.chromium.base.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

   private Retrofit retrofit;
    private static final String TAG = "POKIDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       retrofit = new Retrofit.Builder()
               .baseUrl("http://pokeapi.co/api/v2/")
               .addConverterFactory(GsonConverterFactory.create())
               .build();
        obtenerDatos();
    }
    private void obtenerDatos(){
       PokiapiService service = retrofit.create(PokiapiService.class);
       Call<PokemonRes> pokemonResCall = service.obtenerListaPokemon();

       pokemonResCall.enqueue(new Callback<PokemonRes>()){
//           @Override
//           public void onResponse(Call<PokemonRes> call, Response<PokemonRes> response) {
//               if (response.isSuccessful()){
//                   PokemonRes pokemonRes = response.body();
//                   ArrayList<Pokemon> listaPokemon = pokemonRes.getResults();
//
//                   for(int i = 0; i < listaPokemon.size(); i++){
//                       Pokemon p = listaPokemon.get(i);
//                       Log.i(TAG, " Pokemon: " + p.getName());
//                   }
//               } else {
//                   Log.e(TAG, " onResponse: " + response.errorBody());
//               }
//           }
//           @Override
//           public void onFailure(Call<PokemonRes> call, Throwable t){
//               Log.e(TAG, " onFailure: " + t.getMessage())
//           }
//       });


    }
}
package com.moringaschool.myspace.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.myspace.Constants;
import com.moringaschool.myspace.models.Apods;
import com.moringaschool.myspace.R;
import com.moringaschool.myspace.adapters.ApodsListAdapter;
import com.moringaschool.myspace.models.NasaApodSearchResponse;
import com.moringaschool.myspace.network.NasaApi;
import com.moringaschool.myspace.network.NasaClient;
import com.moringaschool.myspace.network.NasaService;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ApodsListActivity extends AppCompatActivity {
    private static final String TAG = ApodsListActivity.class.getSimpleName();

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentDates;

    @BindView(R.id.recyclerview) RecyclerView mRecycleView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private ApodsListAdapter mAdapter;

    public List<Apods> apods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apods_list);
        ButterKnife.bind(this);

       final Intent intent = getIntent();

        String date = intent.getStringExtra("date");

        NasaApi client = NasaClient.getClient();
        // Refer to the client class

        Call<NasaApodSearchResponse> call = client.getApods("today", "true","8RVaXYWs7HPc5GqaGjAhbPrTREKfzezB4YslyNTp");

            call.enqueue(new Callback<NasaApodSearchResponse>() {

                @Override
                public void onResponse(Call<NasaApodSearchResponse> call, Response<NasaApodSearchResponse> response) {
                    if (response.isSuccessful()){
                        Log.e(TAG, "CHECK");
                        hideProgressBar();
                        apods = response.body().getApods();
                        mAdapter = new ApodsListAdapter(ApodsListActivity.this,apods);
                        mRecycleView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ApodsListActivity.this);
                        mRecycleView.setLayoutManager(layoutManager);
                        mRecycleView.setHasFixedSize(true);
                        showApods();
                    }
                    else
                        {
                        showUnsuccessfulMessage();
                    }
                }

                @Override
                public void onFailure(Call<NasaApodSearchResponse> call, Throwable t) {
                    Log.e(TAG, "OnFailure:", t);
                    hideProgressBar();
                    showFailureMessage();
                }
            });

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentDates = mSharedPreferences.getString(Constants.PREFERENCES_DATE_KEY, null);
        if (mRecentDates != null) {
            getApods(mRecentDates);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE); }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE); }

    private void addToSharedPreferences(String date) { mEditor.putString(Constants.PREFERENCES_DATE_KEY, date).apply(); }

    private void showApods() {
        mRecycleView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void getApods(String query) { }
}



//-ish retro
//    final NasaService nasaService = new NasaService();
//
//        nasaService.findApods(date, new Callback() {
//@Override
//public void onFailure( Call call, IOException e) {
//        showFailureMessage();
//        }
//
//@Override
//public void onResponse( Call call, Response response) throws IOException {
//        mApods = nasaService.processResults(response);
//        ApodsListActivity.this.runOnUiThread(new Runnable() {
//@Override
//public void run() {
//        mAdapter= new ApodsListAdapter((ApodsListActivity) getApplicationContext(), mApods);
//        mRecycleView.setAdapter(mAdapter);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ApodsListActivity.this);
//        mRecycleView.setLayoutManager(layoutManager);
//        mRecycleView.setHasFixedSize(true);
//        }
//        });
//        }{
//        showUnsuccessfulMessage();
//        }
//        })

//-ish ish retro
//    public void getApods(String date){
//
//    NasaClient.getClient().getApods("22-10-2020", "true", "8RVaXYWs7HPc5GqaGjAhbPrTREKfzezB4YslyNTp").enqueue(
//
//     new retrofit2.Callback<List<Apods>>() {
//
//      @Override
//      public void onResponse(retrofit2.Call<List<Apods>> call, retrofit2.Response<List<Apods>> response) {
//        if (response.isSuccessful()) {
//        apods = (ArrayList<Apods>) response.body();
//        mAdapter = new ApodsListAdapter(ApodsListActivity.this, apods);
//        mRecycleView.setAdapter(mAdapter);
//        RecyclerView.LayoutManager layoutManager =
//        new LinearLayoutManager(ApodsListActivity.this);
//        mRecycleView.setLayoutManager(layoutManager);
//        mRecycleView.setHasFixedSize(true);
//
//        showApods();
//        } else {
//        showUnsuccessfulMessage();
//        }
//        }
//
//
//        @Override
//              public void onFailure(retrofit2.Call<List<Apods>> call, Throwable t) {
//            hideProgressBar();
//            showFailureMessage();
//              }
//        });
//
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_search, menu);
//        ButterKnife.bind(this);
//
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();
//
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                addToSharedPreferences(query);
//                getApods(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//
//        });
//        return true;
//    }

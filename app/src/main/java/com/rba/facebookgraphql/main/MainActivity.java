package com.rba.facebookgraphql.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import com.rba.facebookgraphql.R;
import com.rba.facebookgraphql.result.ResultActivity;

public class MainActivity extends AppCompatActivity implements MainView {

    private LoginButton lbFacebook;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(isSession()){
            nextActivity();
        }

        callbackManager = CallbackManager.Factory.create();
        lbFacebook = (LoginButton) findViewById(R.id.lbFacebook);

        lbFacebook.setReadPermissions("email");

        lbFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i("z- onSuccess", new Gson().toJson(loginResult));
                if(isSession()){
                    nextActivity();
                }
            }

            @Override
            public void onCancel() {
                Log.i("z- onCancel", "true");
            }

            @Override
            public void onError(FacebookException exception) {
                Log.i("z- onError", new Gson().toJson(exception));
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean isSession() {
        boolean session = false;
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if(accessToken != null){
            if(!accessToken.isExpired()){
                session = true;
            }
        }
        return session;
    }

    @Override
    public void nextActivity() {
        startActivity(new Intent(this, ResultActivity.class));
        finish();
    }
}

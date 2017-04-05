package com.rba.facebookgraphql.result;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.google.gson.Gson;
import com.rba.facebookgraphql.R;
import com.rba.facebookgraphql.model.GraphQLResponse;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity implements
        View.OnClickListener, ResultView {

    private AppCompatCheckBox chkID;
    private AppCompatCheckBox chkName;
    private AppCompatCheckBox chkFirstName;
    private AppCompatCheckBox chkLastName;
    private AppCompatCheckBox chkEmail;
    private AppCompatCheckBox chkGender;
    private AppCompatCheckBox chkCover;
    private AppCompatTextView lblID;
    private AppCompatTextView lblName;
    private AppCompatTextView lblFirstName;
    private AppCompatTextView lblLastName;
    private AppCompatTextView lblEmail;
    private AppCompatTextView lblGender;
    private AppCompatImageView imgCover;
    private LinearLayout linProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        chkID = (AppCompatCheckBox) findViewById(R.id.chkID);
        chkName = (AppCompatCheckBox) findViewById(R.id.chkName);
        chkFirstName = (AppCompatCheckBox) findViewById(R.id.chkFirstName);
        chkLastName = (AppCompatCheckBox) findViewById(R.id.chkLastName);
        chkEmail = (AppCompatCheckBox) findViewById(R.id.chkEmail);
        chkGender = (AppCompatCheckBox) findViewById(R.id.chkGender);
        chkCover = (AppCompatCheckBox) findViewById(R.id.chkCover);
        AppCompatButton btnSearch = (AppCompatButton) findViewById(R.id.btnSearch);
        lblID = (AppCompatTextView) findViewById(R.id.lblID);
        lblName = (AppCompatTextView) findViewById(R.id.lblName);
        lblFirstName = (AppCompatTextView) findViewById(R.id.lblFirstName);
        lblLastName = (AppCompatTextView) findViewById(R.id.lblLastName);
        lblEmail = (AppCompatTextView) findViewById(R.id.lblEmail);
        lblGender = (AppCompatTextView) findViewById(R.id.lblGender);
        imgCover = (AppCompatImageView) findViewById(R.id.imgCover);
        linProgress = (LinearLayout) findViewById(R.id.linProgress);

        btnSearch.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        clear();

        List<String> list = new ArrayList<>();

        if(chkID.isChecked()){
            list.add("id");
        }

        if(chkFirstName.isChecked()){
            list.add("first_name");
        }

        if(chkName.isChecked()){
            list.add("name");
        }

        if(chkLastName.isChecked()){
            list.add("last_name");
        }

        if(chkEmail.isChecked()){
            list.add("email");
        }

        if(chkGender.isChecked()){
            list.add("gender");
        }

        if(chkCover.isChecked()){
            list.add("cover");
        }


        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.i("z- onCompleted", new Gson().toJson(object));

                        GraphQLResponse graphQLResponse = new Gson().fromJson(new Gson().toJson(object), GraphQLResponse.class);

                        if(graphQLResponse.getNameValuePairs().getId() != null){
                            lblID.setText(graphQLResponse.getNameValuePairs().getId());
                            lblID.setVisibility(View.VISIBLE);
                        }else{
                            lblID.setVisibility(View.GONE);
                        }

                        if(graphQLResponse.getNameValuePairs().getName() != null){
                            lblName.setText(graphQLResponse.getNameValuePairs().getName());
                            lblName.setVisibility(View.VISIBLE);
                        }else{
                            lblName.setVisibility(View.GONE);
                        }

                        if(graphQLResponse.getNameValuePairs().getFirst_name() != null){
                            lblFirstName.setText(graphQLResponse.getNameValuePairs().getFirst_name());
                            lblFirstName.setVisibility(View.VISIBLE);
                        }else{
                            lblFirstName.setVisibility(View.GONE);
                        }

                        if(graphQLResponse.getNameValuePairs().getLast_name() != null){
                            lblLastName.setText(graphQLResponse.getNameValuePairs().getLast_name());
                            lblLastName.setVisibility(View.VISIBLE);
                        }else{
                            lblLastName.setVisibility(View.GONE);
                        }

                        if(graphQLResponse.getNameValuePairs().getEmail() != null){
                            lblEmail.setText(graphQLResponse.getNameValuePairs().getEmail());
                            lblEmail.setVisibility(View.VISIBLE);
                        }else{
                            lblEmail.setVisibility(View.GONE);
                        }

                        if(graphQLResponse.getNameValuePairs().getGender() != null){
                            lblGender.setText(graphQLResponse.getNameValuePairs().getGender());
                            lblGender.setVisibility(View.VISIBLE);
                        }else{
                            lblGender.setVisibility(View.GONE);
                        }

                        if(graphQLResponse.getNameValuePairs().getCover() != null){
                            Picasso.with(getApplicationContext())
                                    .load(graphQLResponse.getNameValuePairs().getCover().getNameValuePairs().getSource())
                                    .into(imgCover);
                        }

                        linProgress.setVisibility(View.GONE);

                    }
                });


        String field = "";

        for(int i = 0; i < list.size(); i++){

            if(i == 0){
                field = list.get(i);
            } else {
                field = field.concat(", ").concat(list.get(i));
            }

        }

        Bundle parameters = new Bundle();
        parameters.putString("fields", field);
        request.setParameters(parameters);
        request.executeAsync();

    }

    @Override
    public void clear(){
        linProgress.setVisibility(View.VISIBLE);
        lblGender.setText("");
        lblEmail.setText("");
        lblLastName.setText("");
        lblFirstName.setText("");
        lblName.setText("");
        lblID.setText("");
        imgCover.setImageResource(0);
    }
}

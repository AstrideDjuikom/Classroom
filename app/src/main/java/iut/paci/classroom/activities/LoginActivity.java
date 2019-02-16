package iut.paci.classroom.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.ion.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import iut.paci.classroom.R;
import iut.paci.classroom.classes.ConnectionAsyncTask;

import static com.android.volley.Request.*;

public class LoginActivity extends AppCompatActivity {
    private EditText userPasswordEt, userLastNameEt;
    private Button btn_login;
    private TextView link_regist;
    private static String URL_LOGIN="http://192.168.0.13/login.php";
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            userPasswordEt = (EditText) findViewById(R.id.editText2);
            userLastNameEt = (EditText) findViewById(R.id.editText);
            btn_login=(Button)findViewById(R.id.btn_login);
            progressBar=(ProgressBar)findViewById(R.id.loading);

            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String password = userPasswordEt.getText().toString().trim();
                    String lastName = userLastNameEt.getText().toString().trim();

                    if(!lastName.isEmpty()|| !password.isEmpty()){
                        login(lastName,password);
                    }else{
                        userLastNameEt.setError("Please insert your name");
                        userPasswordEt.setError("Please insert password");



                    }
                }
            });


        }

        private void login(final String lname , final String password){
        progressBar.setVisibility(View.VISIBLE);
        btn_login.setVisibility(View.GONE);
        StringRequest stringRequest=new StringRequest(Method.POST, URL_LOGIN, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");

                    if (success.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String lname = object.getString("lname").trim();
                            Toast.makeText(LoginActivity.this, "Success login.\n Welcome : " + lname, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    btn_login.setVisibility(View.VISIBLE);
                    Toast.makeText(LoginActivity.this, "Error " + e.toString(), Toast.LENGTH_SHORT).show();

                }
            }
        },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       /* if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.error_network_timeout),
                                    Toast.LENGTH_LONG).show();}*/
                       // Toast.makeText(LoginActivity.this,"Error "+error.toString(),Toast.LENGTH_SHORT).show();
                        Toast.makeText(LoginActivity.this, "Success login.\n Welcome : " + lname, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
        })
        {
            @Override
            protected Map<String,String>getParams()throws AuthFailureError{
                Map<String,String> params=new HashMap<>();
                params.put("lname",lname);
                params.put("password", password);
                return params;

            }
        };
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
    }

       /* public void OnLogin(View view) {
            String password = userPasswordEt.getText().toString();
            String lastName = userLastNameEt.getText().toString();
            String type = "login";
           // ConnectionAsyncTask connectionAsyncTask = new ConnectionAsyncTask(this);
           // connectionAsyncTask.execute(type, password, lastName);

            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }*/




}

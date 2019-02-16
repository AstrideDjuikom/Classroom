package iut.paci.classroom.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import iut.paci.classroom.R;

public class FragmentQuiz extends Fragment {
    TextView nomPers1;
    TextView scorePers1;

    TextView nomPers2;
    TextView scorePers2;
    Button btn_arrondissement;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false);

       /* nomPers1=(TextView)findViewById(R.id.nom_pers1_TV);
        nomPers2=(TextView) findViewById(R.id.nom_pers2_TV);
        scorePers1=(TextView)findViewById(R.id.score_pers1_TV);
        scorePers2=(TextView)findViewById(R.id.score_pers2_TV);
        btn_arrondissement=(Button)findViewById(R.id.arrondis);

        nomPers1.setText("Astride");
        nomPers2.setText("Erik");

        scorePers1.setText("1");
        scorePers2.setText("2");*/

        /*btn_arrondissement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(getApplicationContext(),DistrictActivity.class);
                startActivity(i);
            }
        });*/


    }


}

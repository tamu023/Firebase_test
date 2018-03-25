package com.example.bloodline.firebase_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        final Firebase rootRef = new Firebase("https://fir-test-1d013.firebaseio.com/Users");
        final Firebase olvasref = new Firebase("https://fir-test-1d013.firebaseio.com/Users/proba/elsoproba");

        Button btn;
        Button olvasbtn;

        final EditText txt;
        final EditText txt1;
        final EditText txt2;
        final EditText txt3;
        final EditText txt4;
        final EditText txt5;
        final EditText txt6;

        txt = (EditText) findViewById(R.id.edittext);
        txt1 = (EditText) findViewById(R.id.edittext1);
        txt2 = (EditText) findViewById(R.id.edittext2);
        txt3 = (EditText) findViewById(R.id.edittext3);
        txt4 = (EditText) findViewById(R.id.edittext4);
        txt5 = (EditText) findViewById(R.id.edittext5);
        txt6 = (EditText) findViewById(R.id.edittext6);
        btn = (Button) findViewById(R.id.button1);
        olvasbtn = (Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase beszur = rootRef.child("proba").child("elsoproba");
                beszur.child("kulcs").setValue("ez az érték");
                //myRef.child("termekek").child("felkesz").child("tej").setValue("valami");
                //myRef.setValue(33);
            }
        });

        olvasbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Felhasznalok tam = new Felhasznalok("daih saueh", "diausg@asuih.ti", false, true, 63, 72, true);
                rootRef.push().setValue(tam);
            }
        });

        olvasref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //egy adott linken lévő kulcs vagy érték kiiratása
                //txt.setText(dataSnapshot.getKey().toString());
                //kiirja hogy az adott referencia alatt hány kulcs/gyermek található
                txt.setText("There are " + dataSnapshot.getChildrenCount() + " blog posts");
                //adott referencia alatt végigmegy és kiirja a gyermekek értékeit
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    System.out.println(postSnapshot.getValue());
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("Failed");
            }
        });
    }

    private class Felhasznalok {
        String name;
        String email;
        Boolean cbetegseg;
        Boolean tejerzekenyseg;
        Integer testsuly;
        Integer magassag;
        Boolean neme;

        public Felhasznalok(String name, String email, Boolean cbetegseg, Boolean tejerzekenyseg, Integer testsuly, Integer magassag, Boolean neme) {
            this.name = name;
            this.email = email;
            this.cbetegseg = cbetegseg;
            this.tejerzekenyseg = tejerzekenyseg;
            this.testsuly = testsuly;
            this.magassag = magassag;
            this.neme = neme;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Boolean getCbetegseg() {
            return cbetegseg;
        }

        public void setCbetegseg(Boolean cbetegseg) {
            this.cbetegseg = cbetegseg;
        }

        public Boolean getTejerzekenyseg() {
            return tejerzekenyseg;
        }

        public void setTejerzekenyseg(Boolean tejerzekenyseg) {
            this.tejerzekenyseg = tejerzekenyseg;
        }

        public Integer getTestsuly() {
            return testsuly;
        }

        public void setTestsuly(Integer testsuly) {
            this.testsuly = testsuly;
        }

        public Integer getMagassag() {
            return magassag;
        }

        public void setMagassag(Integer magassag) {
            this.magassag = magassag;
        }

        public Boolean getNeme() {
            return neme;
        }

        public void setNeme(Boolean neme) {
            this.neme = neme;
        }

    }
}



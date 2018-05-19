package com.example.bloodline.firebase_test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Firebase-------------------------------------------------------------------------------
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

        txt = findViewById(R.id.edittext);
        txt1 = findViewById(R.id.edittext1);
        txt2 = findViewById(R.id.edittext2);
        txt3 = findViewById(R.id.edittext3);
        txt4 = findViewById(R.id.edittext4);
        txt5 = findViewById(R.id.edittext5);
        txt6 = findViewById(R.id.edittext6);
        btn = findViewById(R.id.button1);
        olvasbtn = findViewById(R.id.button2);

        //Beírás a meghatározott útvonalra
        /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase beszur = rootRef.child("proba").child("elsoproba");
                beszur.child("kulcs").setValue("ez az érték");
                //myRef.child("termekek").child("felkesz").child("tej").setValue("valami");
                //myRef.setValue(33);
            }
        });*/

        //felhasználó bevitele a rootRef útvonal alá
       /* olvasbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Felhasznalok tam = new Felhasznalok("daih saueh", "diausg@asuih.ti", false, true, 63, 72, true);
                rootRef.push().setValue(tam);
            }
        });*/

        //olvasRef link alatt lévő Eventeket figyeli
        /*olvasref.addValueEventListener(new ValueEventListener() {
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
        });*/


        String email = "tamasboldizsar23@gmail.com";
        String password = "qwedsa";
        String userID;
        final FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        //Regisztráció
        /*mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/
        //Bejelentkezés
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            txt.setText(user.getUid());
                            //rootref alatt uid val link létrehozása
                            rootRef.child(user.getUid().toString()).setValue("siker");
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

//Firestore-----------------------------------------------------------------------------
        /*FirebaseFirestore db = FirebaseFirestore.getInstance();
        // Create a new user with a first and last name
        //Felhasznalok felh = new Felhasznalok("nev","mail",false,false,76,187,true);
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);


        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
                    }
                });

        // Create a new user with a first, middle, and last name
        Map<String, Object> user2 = new HashMap<>();
        user2.put("first", "Alan");
        user2.put("middle", "Mathison");
        user2.put("last", "Turring");
        user2.put("born", 1912);

        // Add a new document with a generated ID
        db.collection("users")
                .add(user2)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
                    }
                });*/

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



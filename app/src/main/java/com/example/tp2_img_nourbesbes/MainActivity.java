package com.example.tp2_img_nourbesbes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText _edtTaille, _edtAge, _edtPoids;
    TextView _txtTaille,_txtAge,_txtPoids,_txtResultat, _txtInterpretation;
    RadioButton _rdbFemme,_rdbHomme;
    Button _btnCalculIMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _edtAge = (EditText) findViewById(R.id.edtAge);
        _edtPoids = (EditText) findViewById(R.id.edtPoids);
        _edtTaille = (EditText) findViewById(R.id.edtTaille);
        _txtAge = (TextView) findViewById(R.id.txtAge);
        _txtPoids = (TextView) findViewById(R.id.txtPoids);
        _txtTaille = (TextView) findViewById(R.id.txtTaille);
        _txtResultat = (TextView) findViewById(R.id.txtResultat);
        _txtInterpretation = (TextView) findViewById(R.id.txtInterpretation);
        _rdbFemme = (RadioButton) findViewById(R.id.rdbFemme);
        _rdbHomme = (RadioButton) findViewById(R.id.rdbHomme);
        _btnCalculIMG = (Button) findViewById(R.id.btnCalculIMG);


        //calculer IMG
        _btnCalculIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float poids;
                Float taille;
                int age;
                Float img;
                Float imc;
                int sexe;

                poids = Float.parseFloat(_edtPoids.getText().toString());
                taille = Float.parseFloat(_edtTaille.getText().toString());
                age = Integer.parseInt(_edtAge.getText().toString());

                if (_rdbFemme.isChecked())
                    sexe = 0;
                else
                    sexe = 1;
                //Conversion taille en mètres
                taille = taille / 100;
                imc = poids / (taille * taille);

                if (age >= 16)
                    img = (float) ((1.20 * imc) + (0.23 * age) - (10.8 * sexe) - 5.4);
                else
                    img = (float) ((1.51 * imc) + (0.70 * age) - (3.6 * sexe) - 1.4);

                _txtResultat.setText("Votre IMG est " + img + " %");
                if (sexe == 0) {
                    if (img < 25)
                        _txtInterpretation.setText("Interprétation : Trop maigre");
                    else if ((img >= 25) && (img <= 30))
                        _txtInterpretation.setText("Interprétation : Pourcentage normal");
                    else
                        _txtInterpretation.setText("Interprétation : Trop de graisse");
                }

                else {
                    if (img < 15)
                        _txtInterpretation.setText("Interprétation : Trop maigre");
                    else if ((img >= 15) && (img <= 20))
                        _txtInterpretation.setText("Interprétation : Pourcentage normal");
                    else
                        _txtInterpretation.setText("Interprétation : Trop de graisse");
                }

            }

        });
    }
}
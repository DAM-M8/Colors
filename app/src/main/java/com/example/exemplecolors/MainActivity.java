package com.example.exemplecolors;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Locale;

/**Aplicacio desenvolupada per L. Lopez
 * Joc un l'usuari ha d'encertar el color escrit al text
 * 4a versio: S'afegeix el boto de finalitzacio i un boto per anar a una web (permisos) */

/* Codi per a la carrega d'imatges aleatories extret de:
 * https://stackoverflow.com/questions/20549705/how-to-display-random-images-on-image-view
 */

public class MainActivity extends AppCompatActivity {

    int encert = 0;
    int error = 0;
    final Random rnd = new Random();
    String lang;
    String prefix;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textEncerts = (TextView) findViewById(R.id.textView);
        textEncerts.setText(getResources().getString(R.string.encerts));
        final TextView textErrors = (TextView) findViewById(R.id.textView2);
        textErrors.setText(getResources().getString(R.string.errors));

        lang = Locale.getDefault().getLanguage();

        if (lang.equals("es")) prefix = "color_es_";    //Idioma castella
        else if (lang.equals("en")) prefix = "color_en_"; //Idioma angles
        else prefix = "color_"; //Idioma per defecte catala


        //Carreguem la primera imatge aleatoriament


        ImageView img = (ImageView) findViewById(R.id.imgRandom);
        // I have 9 images named img_0 to img_2, so...
        str = prefix + rnd.nextInt(8);
        img.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(str, "drawable",
                                getApplicationContext()))
                );


        final Button bVermell = (Button) findViewById(R.id.button);
        bVermell.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (str.equals((prefix+"0")) || str.equals((prefix+"1")) || str.equals((prefix+"2")))
                    encert++;   //Si el text 'vermell' incrementa els encerts
                else error++;

                //Mostrem el nombre d'encerts i d'errors de la partida
                textEncerts.setText(getResources().getString(R.string.encerts) + encert);
                textErrors.setText(getResources().getString(R.string.errors) + error);

                //Carreguem una altra imatge per seguir jugant

                ImageView img = (ImageView) findViewById(R.id.imgRandom);
                // I have 9 images named img_0 to img_2, so...
                str = prefix + rnd.nextInt(8);
                img.setImageDrawable
                        (
                                getResources().getDrawable(getResourceID(str, "drawable",
                                        getApplicationContext()))
                        );
            }
        });


        final Button bBlau = (Button) findViewById(R.id.button2);
        bBlau.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //L'usuari prem el boto blau
                if (str.equals((prefix+"3")) || str.equals((prefix+"4")) || str.equals((prefix+"5")))
                    encert++;   //Si el text 'blau' incrementa els encerts
                else error++;

                //Mostrem el nombre d'encerts i d'errors de la partida
                textEncerts.setText(getResources().getString(R.string.encerts) + encert);
                textErrors.setText(getResources().getString(R.string.errors) + error);

                //Carreguem una altra imatge per seguir jugant

                ImageView img = (ImageView) findViewById(R.id.imgRandom);
                // I have 9 images named img_0 to img_2, so...
                str = prefix + rnd.nextInt(8);
                img.setImageDrawable
                        (
                                getResources().getDrawable(getResourceID(str, "drawable",
                                        getApplicationContext()))
                        );

            }
        });

        final Button bNegre = (Button) findViewById(R.id.button3);
        bNegre.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //L'usuari prem el boto negre
                if (str.equals((prefix+"6")) || str.equals((prefix+"7")) || str.equals((prefix+"8")))
                    encert++;   //Si el text 'negre' incrementa els encerts
                else error++;

                //Mostrem el nombre d'encerts i d'errors de la partida
                textEncerts.setText(getResources().getString(R.string.encerts) + encert);
                textErrors.setText(getResources().getString(R.string.errors) + error);

                //Carreguem una altra imatge per seguir jugant

                ImageView img = (ImageView) findViewById(R.id.imgRandom);
                // I have 9 images named img_0 to img_2, so...
                str = prefix + rnd.nextInt(8);
                img.setImageDrawable
                        (
                                getResources().getDrawable(getResourceID(str, "drawable",
                                        getApplicationContext()))
                        );

            }
        });

        //Boto per accedir a la web del test de Stroop
        final Button bt4= (Button) findViewById(R.id.button4);
        bt4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lang.equals("es"))  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://psicologiaymente.com/psicologia/test-de-stroop")));   //Idioma castella
                else if (lang.equals("en"))  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5388755/"))); //Idioma angles
                else startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://psicoesborranys.blogspot.com/2012/05/efecte-stroop.html"))); //Idioma per defecte catala
            }
        });

        //Boto per tancar l'app
        final ImageButton btSortir= (ImageButton) findViewById(R.id.btSortir);
        btSortir.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }



    protected final static int getResourceID
            (final String resName, final String resType, final Context ctx)
    {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, resType,
                        ctx.getApplicationInfo().packageName);
        if (ResourceID == 0)
        {
            throw new IllegalArgumentException
                    (
                            "No resource string found with name " + resName
                    );
        }
        else
        {
            return ResourceID;
        }
    }
}
package thecelestials.bilkentcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton b1,b2,b3,b4,b5,b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(ImageButton) findViewById(R.id.imageButton);
        b2=(ImageButton) findViewById(R.id.imageButton2);
        b3=(ImageButton) findViewById(R.id.imageButton3);
        b4=(ImageButton) findViewById(R.id.imageButton4);
        b5=(ImageButton) findViewById(R.id.imageButton5);
        b6=(ImageButton) findViewById(R.id.imageButton6);


        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            Intent i1 = new Intent(MainActivity.this,Calendar.class);
            startActivity(i1);


            }
        }

        );


        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i2 = new Intent(MainActivity.this,Building.class);
                startActivity(i2);


            }
        }

        );

        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i3 = new Intent(MainActivity.this,Transportation.class);
                startActivity(i3);

             }
        }

        );

        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i4 = new Intent(MainActivity.this,Cafeteria.class);
                startActivity(i4);


            }
        }

        );

        b5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i5 = new Intent(MainActivity.this,MarmaraMenu.class);
                startActivity(i5);


            }
        }

        );


        b6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i6 = new Intent(MainActivity.this,Park.class);
                startActivity(i6);


            }
        }

        );



    }
}

package thecelestials.bilkentcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MarmaraMenu extends AppCompatActivity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marmara_menu);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {

                                      Intent i1 = new Intent(MarmaraMenu.this,FixedMenu.class);
                                      startActivity(i1);

                                  }
                              }

        );

        b2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {

                                      Intent i2 = new Intent(MarmaraMenu.this,AlternativeMenu.class);
                                      startActivity(i2);


                                  }
                              }

        );


    }
}

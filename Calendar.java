package thecelestials.bilkentcompanion;


import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import thecelestials.bilkentcompanion.R;


public class Calendar extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String str = getResources().getString(R.string.result);
        setContentView(R.layout.activity_calendar);

        tv = (TextView) findViewById(R.id.textView);
        //tv.setText(getWebsite("http://w3.bilkent.edu.tr/bilkent/academic-calendar-2016-2017/"));
        //tv.setText(parseHtml());
        //String s = getWebsite("http://w3.bilkent.edu.tr/bilkent/academic-calendar-2016-2017/");
        //String filtered = Html.fromHtml(s).toString();
        //tv.setText(filtered);
        //tv.setText(HTMLFilteredReader());
        tv.setText(str);
        //System.out.println(HTMLFilteredReader());
    }

    public String getWebsite ( String website){
        String resString = "";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        HttpClient client = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(website);
        try{
            HttpResponse response;

            response = client.execute(httpget);
            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();
            BufferedReader reader = new BufferedReader (new InputStreamReader(stream, "windows-1251"),8);
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ( (line = reader.readLine()) != null){
                builder.append(line+ "\n");
            }
            resString = builder.toString();
            stream.close();
        } catch ( Exception e){
            e.printStackTrace();
            Toast.makeText(Calendar.this, "Error!", Toast.LENGTH_SHORT).show();
        }
        return resString;
    }



  /*  public String parseHtml (){

        String original  = getWebsite("http://w3.bilkent.edu.tr/bilkent/academic-calendar-2016-2017/");

        String store = "";

        boolean flag=true;

        for(int i=0;i<original.length();i++) {

            if(original.substring(i + 1, i + 4).equals("1\">"))
                flag=false;

            if ( flag==false )
                store += original.charAt(i);

            if (original.substring(i + 1, i + 4).equals("</t") )
                flag = true;

        }
        return store;
    }*/







    public String HTMLFilteredReader (){
        String or  = getWebsite("http://w3.bilkent.edu.tr/bilkent/academic-calendar-2016-2017/");

        String original =or.substring(38980,67037);
        String newCont;

        newCont = "";
        boolean flag=false;
        boolean check = false; //the conditon which checks weather we ar in <> or not
        String dayStart="";
        String dayStop="";
        String eventStart="";
        String eventStop="";
        String ln="";
        boolean br=true;
        for ( int i = 22; i < original.length()-15; i++ ) //filter operation
        {
            char catcher = original.charAt(i);
            dayStart =original.substring(i-21,i);
            dayStop=original.substring(i+1,i+9);
            eventStart =original.substring(i-21,i);
            eventStop=original.substring(i+1,i+11);


            if(original.substring(i+1,i+7).equals("<br />"))
                i=i+6;

            //if(original.substring(i+1,i+16).equals("<div class=oim>"))
            // i=i+15;

            if ( dayStart.equals("<td class=\"column-1\">")) {
                check = true;
                newCont += "\n";
                newCont += "\n";
            }
            if (eventStart.equals("<td class=\"column-2\">"))
                check = true;


            if ( check==true ) {

                if(catcher != '\n' && br) {
                    newCont += catcher;

                }



            }

            if ( dayStop.equals("</td><td")){
                check = false;
                newCont += "\n";
            }
            if (eventStop.equals("</td></tr>")){
                check = false;
                newCont += "\n";
                newCont += "\n";
            }




        }
        String result="";
        for ( int i = 0; i < newCont.length(); i++ ) //filter operation
        {
            char catcher = newCont.charAt(i);
            if ( catcher == '<')
                check = false;

            if ( check==true )
                result += catcher;

            if ( catcher == '>')
                check = true;
        }

        return result;



    }



    /*public String parseHtml ( String htmlCode){
        String original = htmlCode;
        String store = "";
        int start = original.indexOf("<td class=\"column-1\">");
        int end   = original.indexOf("<!-- #tablepress-14 from cache --></p>");
        int secondStart;
        int change;
        for ( int i=start; i<end; i++) {
            secondStart = original.indexOf("<td class=\"column-1\">");
            change = original.indexOf("- <br />");
            for ( int j= secondStart; j<change; j++)
                store = store + original.substring(secondStart, change);
            original = original.substring(change+1);
        }
        return store;
    }*/




}


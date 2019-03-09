package com.example.harris_hawk.tjticketprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] station={"池袋(TJ-01)","北池袋(TJ-02)","下板橋(TJ-03)","大山(TJ-04)","中板橋(TJ-05)","ときわ台(TJ-06)","上板橋(TJ-07)","東武練馬(TJ-08)","下赤塚(TJ-09)","成増(TJ-10)","和光市(TJ-11)","朝霞(TJ-12)","朝霞台(TJ-13)","志木(TJ-14)","柳瀬川(TJ-15)","みずほ台(TJ-16)","鶴瀬(TJ-17)","ふじみ野(TJ-18)","上福岡(TJ-19)","新河岸(TJ-20)","川越(TJ-21)","川越市(TJ-22)","霞ヶ関(TJ-23)","鶴ヶ島(TJ-24)","若葉(TJ-25)","坂戸(TJ-26)","北坂戸(TJ-27)","高坂(TJ-28)","東松山(TJ-29)","森林公園(TJ-30)","つきのわ(TJ-31)","武蔵嵐山(TJ-32)","小川町(TJ-33)","東武竹沢(TJ-34)","男衾(TJ-35)","鉢形(TJ-36)","玉淀(TJ-37)","寄居(TJ-38)","（越生線）一本松(TJ-41)","（越生線）西大家(TJ-42)","（越生線）川角(TJ-43)","（越生線）武州長瀬(TJ-44)","（越生線）東毛呂(TJ-45)","（越生線）武州唐沢(TJ-46)","（越生線）越生(TJ-47)"};
        final double[] km={0.0,1.2,2.0,3.0,4.0,4.7,6.0,7.4,8.9,10.4,12.5,14.0,16.4,17.8,19.3,20.6,22.0,24.2,25.9,28.3,30.5,31.4,34.8,37.0,38.9,40.6,42.7,46.2,49.9,52.6,55.4,57.1,64.1,67.1,70.8,73.5,74.4,75.0,2.8,4.4,5.6,7.6,8.6,9.4,10.9};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, station);
        Button button=super.findViewById(R.id.button);
        final Spinner departure = super.findViewById(R.id.departure);
        final Spinner destination = super.findViewById(R.id.destination);
        final TextView textView=super.findViewById(R.id.textView);
        textView.setText("出発駅と到着駅を選んでください");
        departure.setAdapter(adapter);
        destination.setAdapter(adapter); //寄居　INDEX37 越生線　INDEX38から　坂戸　INDEX25


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int index_s=departure.getSelectedItemPosition();
               int index_d=destination.getSelectedItemPosition();
               double result;
               if(index_s>=38&&index_d<=37){
                   result=km[index_d]-40.6;
                   if(result<0){
                       result=result*(-1);
                   }
                   result=result+km[index_s];

               }else if(index_d>=38&&index_s<=37){
                   result=km[index_s]-40.6;
                   if(result<0){
                       result=result*(-1);
                   }
                   result=result+km[index_d];
               }else{
                   result=km[index_s]-km[index_d];
               }
               if(result<0){
                   result=result*(-1);
               }
               if(result==0){
                   textView.setText("出発駅と到着駅は同じです！");
               }else{
                   int ticketprice;
                   int icprice;
                   int childticketprice;
                   int childicprice;
                   if(result<=4) {
                       ticketprice = 150;
                       icprice = 144;
                       childticketprice = 80;
                       childicprice = 72;
                   }else if(result>4&&result<=7){
                       ticketprice = 170;
                       icprice = 165;
                       childticketprice = 90;
                       childicprice = 82;
                   }else if(result>7&&result<=10){
                       ticketprice = 200;
                       icprice = 195;
                       childticketprice = 100;
                       childicprice = 97;
                   }else if(result>10&&result<=15){
                       ticketprice = 250;
                       icprice = 247;
                       childticketprice = 130;
                       childicprice = 123;
                   }else if(result>15&&result<=20){
                       ticketprice = 310;
                       icprice = 308;
                       childticketprice = 160;
                       childicprice = 154;
                   }else if(result>20.0&&result<=25){
                       ticketprice = 360;
                       icprice = 360;
                       childticketprice = 180;
                       childicprice = 180;
                   }else if(result>25.0&&result<=30){
                       ticketprice = 420;
                       icprice = 411;
                       childticketprice = 210;
                       childicprice = 205;
                   }else if(result>30.0&&result<=35){
                       ticketprice = 470;
                       icprice = 463;
                       childticketprice = 240;
                       childicprice = 231;
                   }else if(result>35.0&&result<=40){
                       ticketprice = 520;
                       icprice = 515;
                       childticketprice = 260;
                       childicprice = 257;
                   }else if(result>40.0&&result<=45){
                       ticketprice = 590;
                       icprice = 586;
                       childticketprice = 300;
                       childicprice = 293;
                   }else if(result>45.0&result<=50){
                       ticketprice = 650;
                       icprice = 648;
                       childticketprice = 330;
                       childicprice = 324;
                   }else if(result>50.0&&result<=60){
                       ticketprice = 720;
                       icprice = 720;
                       childticketprice = 360;
                       childicprice = 360;
                   }else if(result>60.0&&result<=70){
                       ticketprice = 810;
                       icprice = 802;
                       childticketprice = 410;
                       childicprice = 401;
                   }else {
                       ticketprice = 890;
                       icprice = 885;
                       childticketprice = 450;
                       childicprice = 442;
                   }
                   String str1 = String.valueOf(ticketprice);
                   String str2 = String.valueOf(icprice);
                   String str3 = String.valueOf(childticketprice);
                   String str4 = String.valueOf(childicprice);
                   textView.setText("大人運賃は"+str1+"円\n大人IC運賃は"+str2+"円\n子供運賃は"+str3+"円\n子供IC運賃は"+str4+"円");
               }

            }
        });
    }
}

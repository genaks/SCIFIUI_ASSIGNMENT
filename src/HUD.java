
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nafy
 */

public class HUD extends GameObject{
  
    Time t;
    StarMap m;
    Radar r;
    UI ui;

    int borderW;
    int borderH;
    int buttonAmount = 2;
    int buttonInterval = borderH / 3;
    int barAmount = 3;
    int j;
    int buttonWidth = borderW - borderW / 4;
    int i; 



    ArrayList <Button> buttons = new ArrayList <Button>();
    ArrayList <Bar> bars = new ArrayList<Bar>();

    HUD(UI ui){
        this.ui = ui;
        this.m = new StarMap( ui, ui.width / 32 , ui.height /32);
        
        this.r = new Radar( ui, 100, (ui.width / 4) / 2 ,  -(ui.height / 4 ) / 2 , 0.5f);
        borderW = ui.width / 4;
        borderH = ui.height / 4;
        
        //loop to add 4 buttons
        for(i = 0; i < buttonAmount; i++){ 
            for( j = 0; j < buttonAmount; j++){
                buttons.add(new Button( borderW / 10 , (buttonInterval) + buttonInterval * j , buttonWidth));
            };
            buttons.add(new Button( borderW / 10  , (buttonInterval) + buttonInterval * i ,  buttonWidth));
        };

       // loop to add in the bar meters
        for( i = 0; i < barAmount; i ++){ 
            bars.add(new Bar(borderW / 4 + (borderW / 4 ) * i, borderH - (borderH / 4), -50 , random(-100, -10 * i) ));
        }

        //creates 
        this.t = new Time(0,borderH + (borderH / 16));

    }

    public void render(){
     background(0);
     fill(255);
     //Covers the top white.
     rect(0,0, width , borderH);

     //creates the top border and bottom border layout
     fill(0,128,200);
     stroke(0);
     pushMatrix();
     translate(borderW , 0);
     rect(0 , 0, width / 2 , borderH / 2);
     translate(0 , height - borderW / 2);
     fill(0,128,200);
     rect(0, 0 , width / 2 , borderH);
     fill(255);
     rect(0 , 0, width / 2 , borderH / 4);
     stroke(0);
     popMatrix();

     //creates the left side layout   
     fill(0,128,200);
     rect(0 , borderH , borderW , height /2); 
     triangle(0 , borderH / 2 , 0 , borderH , borderW , borderH);
     triangle(0 , 0 , borderW , 0 , borderW , borderH / 2);
     quad(0 , (height - borderH ) + (borderH / 4) , borderW , (height - borderH ) + (borderH /4) , borderW + (borderW / 4) , height, 0 , height); 
     fill(255);
     stroke(0);
     rect(0, height - borderH, borderW + (borderW / 12) ,borderH / 4);
     quad(borderW + (borderW / 12) , height - borderH , borderW, height - (borderH - borderH / 4) , borderW + (borderW / 4) , height , (borderW + (borderW / 4)) + borderW / 8 , height); 
     fill(255);
     stroke(0);

     //creates the right side layout
     pushMatrix();
     translate(width - borderW , 0);
     fill(0,128,200);
     rect(0 , borderH , borderW , height /2);
     quad(0 , (height - borderH ) + (borderH / 4) , borderW , (height - borderH ) + (borderH /4) ,  borderW  , height, -(borderW / 4) , height); 
     triangle(borderW , borderH / 2 , 0 , borderH , borderW , borderH); 
     triangle(0 , 0 , borderW , 0 , 0 , borderH / 2);
     fill(255);
     stroke(0);
     rect(-(borderW/12), height - borderH, borderW + (borderW /12) ,borderH / 4);
     quad(-(borderW / 12) , height - borderH , 0, height - (borderH - borderH / 4) ,  - (borderW /4 ) , height ,  - (borderW / 4) - borderW / 8 , height); 
     fill(255);
     popMatrix();


     //buttons for bttom left
     strokeWeight(5);
     for ( i = 0; i  < buttonAmount; i++){
     pushMatrix();
     translate(0,height - borderH);  
       Button button = buttons.get(i);
       //button.update
       button.render();
       if (i == 0) {    
        pushMatrix();
        translate(borderW / 10, buttonInterval);
        fill(255);
        textSize(20);
        text("Radar", borderW / 4  , buttonInterval / 3);
        popMatrix();
       }
       else if (i == 1){
        pushMatrix();
        translate(borderW / 10, buttonInterval);
        fill(255);
        textSize(20);
        text("Map", borderW / 4  , buttonInterval + buttonInterval / 3);
        popMatrix();

       }
      popMatrix(); 
     }
       //buttoms for bottom right 
       for ( j = 0; j < buttonAmount; j++){
       pushMatrix();
       translate(width - (borderW - borderW /10), height- borderH);
       Button button = buttons.get(j);
       //button.update();
       button.render();

        if (j == 0) {    
          pushMatrix();
          translate(borderW / 10, buttonInterval);
          fill(255);
          textSize(20);
          text("Ship Status", borderW / 4  , buttonInterval / 3);
          popMatrix();
       }
         else if (j == 1){
            pushMatrix();
            translate(borderW / 10, buttonInterval);
            fill(255);
            textSize(20);
            text("Warpdrive", borderW / 4  , buttonInterval + buttonInterval / 3);
            popMatrix();
       };
       popMatrix();
     }

     //renders and updates the rader
     r.render();
     r.update();

     //map
     if ( click == true  ){
       pushMatrix();
       translate(borderW,borderH);
       m.render();
       popMatrix();
     }

     //time
     pushMatrix();
     translate(width / 2, height / 2);
     t.render();
     popMatrix();


     pushMatrix();
     translate(width - borderW , height / 2);
     //adding bar meters
     for(i = 0; i < barAmount; i++){
       Bar bar = bars.get(i);     
       fill(255  , 0 , 0 );     
       bar.update();
       bar.render();   
       if(i == 0){
       textSize(20);
       text("Ship HP" , borderW /4 + (borderW /4  * i) , borderH - borderH/ 6);
       }  
       else if( i == 1){
       text("Pilot HP" , borderW /4 + (borderW /4  * i)  ,borderH - borderH/ 6);
       }
       else if ( i == 2){

       text("Enemy HP" , borderW /4 + (borderW /4  * i)  , borderH - borderH/ 6);  
       }
   }





     popMatrix();


   }
 }
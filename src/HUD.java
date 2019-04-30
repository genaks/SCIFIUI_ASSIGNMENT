
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



    ArrayList <Button> buttons = new ArrayList <>();
    ArrayList <Bar> bars = new ArrayList<>();

    HUD(UI ui){
        this.ui = ui;
        this.m = new StarMap( ui, ui.width / 32 , ui.height /32);
        
        this.r = new Radar( ui, 100, (ui.width / 4) / 2 ,  -(ui.height / 4 ) / 2 , 0.5f);
        borderW = ui.width / 4;
        borderH = ui.height / 4;
        
        //loop to add 4 buttons
        for(i = 0; i < buttonAmount; i++){ 
            for( j = 0; j < buttonAmount; j++){ 
                         buttons.add(new Button( borderW / 10  , (buttonInterval) + buttonInterval * j ,  buttonWidth));
            }
            buttons.add(new Button( borderW / 10  , (buttonInterval) + buttonInterval * i ,  buttonWidth));
        }

       // loop to add in the bar meters
        for( i = 0; i < barAmount; i ++){ 
            bars.add(new Bar(borderW / 4 + (borderW / 4 ) * i, borderH - (borderH / 4), -50 ,random(-100, -10 * i) ));
        }

        //creates 
        this.t = new Time(0,borderH + (borderH / 16));

    }
    
    @Override
    public void render(){
            ui.background(0);
            ui.fill(255);
        //Covers the top white.
            ui.rect(0,0, ui.width , borderH);

        //creates the top border and bottom border layout
            ui.fill(0,128,200);
            ui.stroke(0);
            ui.pushMatrix();
            ui.translate(borderW , 0);
            ui.rect(0 , 0, ui.width / 2 , borderH / 2);
            ui.translate(0 , ui.height - borderW / 2);
            ui.fill(0,128,200);
            ui.rect(0, 0 , ui.width / 2 , borderH);
            ui.fill(255);
            ui.rect(0 , 0, ui.width / 2 , borderH / 4);
            ui.stroke(0);
            ui.popMatrix();

        //creates the left side layout   
            ui.fill(0,128,200);
            ui.rect(0 , borderH , borderW , ui.height /2); 
            ui.triangle(0 , borderH / 2 , 0 , borderH , borderW , borderH);
            ui.triangle(0 , 0 , borderW , 0 , borderW , borderH / 2);
            ui.quad(0 , (ui.height - borderH ) + (borderH / 4) , borderW , (ui.height - borderH ) + (borderH /4) , borderW + (borderW / 4) , ui.height, 0 , ui.height); 
            ui.fill(255);
            ui.stroke(0);
            ui.rect(0, ui.height - borderH, borderW + (borderW / 12) ,borderH / 4);
            ui.quad(borderW + (borderW / 12) , ui.height - borderH , borderW, ui.height - (borderH - borderH / 4) , borderW + (borderW / 4) , ui.height , (borderW + (borderW / 4)) + borderW / 8 , ui.height); 
            ui.fill(255);
            ui.stroke(0);

        //creates the right side layout
            ui.pushMatrix();
            ui.translate(ui.width - borderW , 0);
            ui.fill(0,128,200);
            ui.rect(0 , borderH , borderW , ui.height /2);
            ui.quad(0 , (ui.height - borderH ) + (borderH / 4) , borderW , (ui.height - borderH ) + (borderH /4) ,  borderW  , ui.height, -(borderW / 4) , ui.height); 
            ui.triangle(borderW , borderH / 2 , 0 , borderH , borderW , borderH); 
            ui.triangle(0 , 0 , borderW , 0 , 0 , borderH / 2);
            ui.fill(255);
            ui.stroke(0);
            ui.rect(-(borderW/12), ui.height - borderH, borderW + (borderW /12) ,borderH / 4);
            ui.quad(-(borderW / 12) , ui.height - borderH , 0, ui.height - (borderH - borderH / 4) ,  - (borderW /4 ) , ui.height ,  - (borderW / 4) - borderW / 8 , ui.height); 
            ui.fill(255);
            ui.popMatrix();


        //buttons for bttom left
            ui.strokeWeight(5);
                for ( i = 0; i  < buttonAmount; i++){
                    ui.pushMatrix();
                    ui.translate(0,ui.height - borderH);  
                    Button button = buttons.get(i);
            
            
            //button.update
                button.render();
                    if (i == 0) {    
                        ui.pushMatrix();
                        ui.translate(borderW / 10, buttonInterval);
                        ui.fill(255);
                        ui.textSize(20);
                        ui.text("Radar", borderW / 4  , buttonInterval / 3);
                        ui.popMatrix();
       }
                    else if (i == 1){
                        ui.pushMatrix();
                        ui.translate(borderW / 10, buttonInterval);
                        ui.fill(255);
                        ui.textSize(20);
                        ui.text("Map", borderW / 4  , buttonInterval + buttonInterval / 3);
                        ui.popMatrix();

       }
                ui.popMatrix(); 
     }
            //buttoms for bottom right 
                for ( j = 0; j < buttonAmount; j++){
                    ui.pushMatrix();
                    ui.translate(ui.width - (borderW - borderW /10), ui.height- borderH);
                    Button button = buttons.get(j);
            //button.update();
                button.render();

                    if (j == 0) {    
                        ui.pushMatrix();
                        ui.translate(borderW / 10, buttonInterval);
                        ui.fill(255);
                        ui.textSize(20);
                        ui.text("Ship Status", borderW / 4  , buttonInterval / 3);
                        ui.popMatrix();
       }
                else if (j == 1){
                        ui.pushMatrix();
                        ui.translate(borderW / 10, buttonInterval);
                        ui.fill(255);
                        ui.textSize(20);
                        ui.text("Warpdrive", borderW / 4  , buttonInterval + buttonInterval / 3);
                        ui.popMatrix();
       }
                        ui.popMatrix();
     }

            //renders and updates the rader
                        r.render();
                        r.update();

            //map
                if ( ui.click == true  ){
                        ui.pushMatrix();
                        ui.translate(borderW,borderH);
                        m.render();
                        ui.popMatrix();
     }

            //time
                        ui.pushMatrix();
                        ui.translate(ui.width / 2, ui.height / 2);
                        t.render();
                        ui.popMatrix();


                        ui.pushMatrix();
                        ui.translate(ui.width - borderW , ui.height / 2);
            //adding bar meters
                for(i = 0; i < barAmount; i++){
                        Bar bar = bars.get(i);     
                        ui.fill(255  , 0 , 0 );     
                        bar.update();
                        bar.render();   
                switch (i) {
                    case 0:
                        ui.textSize(20);
                        ui.text("Ship HP" , borderW /4 + (borderW /4  * i) , borderH - borderH/ 6);
                        break;
                    case 1:
                        ui.text("Pilot HP" , borderW /4 + (borderW /4  * i)  ,borderH - borderH/ 6);
                        break;
                    case 2:
                        ui.text("Enemy HP" , borderW /4 + (borderW /4  * i)  , borderH - borderH/ 6);
                        break;
                    default:
                        break;
                }
   }





     ui.popMatrix();


   }
 }
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nafy
 */
import processing.core.PVector;

public class ArcReactor extends GameObject{

  float start;
  float stop;
  float speed;
  float theta;
  float frequency;
  float s,t;
  float end;
  float rMax;
  float rMin;
  float strokeIntensity;
  UI ui;
  int col = 0;
  
  public ArcReactor (UI ui, float x, float y, float radius){
    this.ui = ui;
    pos = new PVector(x, y);
    this.radius = radius;
    start = ui.random(360);
    stop = start + 70 + ui.random(180);
    frequency = 30;
    this.end = 0;
    this.rMax = radius + 50;
    this.rMin = radius;
    this.strokeIntensity = 10;
  }

    //Makes the arc increase in size when hovered over
    public void hover(){
        if ( ui.mouseX >= (ui.width / 2 - radius) && ui.mouseX <= (ui.width /2 + radius) && ui.mouseY >= ui.height / 2 -  radius && ui.mouseY <= ui.height / 2 + radius && radius < rMax){
            radius++;

            if(strokeIntensity < 7){
                strokeIntensity++;
            }
        }
        else if (  radius > rMin) {
            radius--;

            if( strokeIntensity > 3){
                strokeIntensity--;
            }
        }
    }
    
  @Override
    public void update(){
        speed = (float) ((2*Math.PI / 60 ) * frequency);
        s = UI.radians(start + theta);
        t = UI.radians(stop + theta)- end;
        theta += speed;

        if(ui.click){
            end+= 0.045;
        }
        
        if(frequency<300)
        {
            frequency++;
        }
        
        if(col < 200)
        {
            col++;
        }
   }
    
  @Override
    public void render(){
        ui.strokeWeight(strokeIntensity);
        if(frequency > 299 )
        {
            ui.stroke(204, 255, 255, 230);
            ui.ellipse(pos.x, pos.y, radius * 2, radius * 2);
        }
        ui.stroke(col + 4, col + 55, col + 55);
        ui.noFill();
        ui.arc(pos.x, pos.y, (radius * 2) , (radius * 2), s , t);
        
    }
    
}
  
 
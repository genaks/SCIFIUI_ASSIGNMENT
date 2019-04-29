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
  
  public ArcReactor (UI ui, float x, float y, float radius, float start, float stop , float frequency){
    this.ui = ui;
    pos = new PVector(x, y);
    this.radius = radius;
    this.start = start;
    this.stop = stop;
    this.frequency = frequency;
    this.speed = (float) ((2*Math.PI / 60 ) * frequency);
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
    
    public void update(){
        s = ui.radians(start + theta);
        t = ui.radians(stop + theta)- end;
        theta += speed;

        if(ui.click){
            end+= 0.045;
        }
   }
    
    public void render(){
        ui.stroke(204, 255, 255);
        ui.strokeWeight(strokeIntensity);
        ui.noFill();
        ui.arc(pos.x, pos.y, (radius * 2) , (radius * 2), s , t);
    }
    
}
  
 
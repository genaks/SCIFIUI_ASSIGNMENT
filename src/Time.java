/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nafy
 */
public class Time {
  
 float x;
 float y;
 int s;
 int m;
 int h;
 String text;
 
 Time(float x, float y){
   this.x = x;
   this.y = y;
 }
  
 public void render(){
    
    s = second();
    m = minute();
    h = hour();
    
    text = "Time:" + h + ":" + m + ":" + s ;
    
    fill(255);
    textSize(30);
    textAlign(CENTER);
    text(text, x , y);
  }
}

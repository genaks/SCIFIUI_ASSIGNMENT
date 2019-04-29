/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nafy
 */
public class StarMap{
 float x;
 float y;
 float interval;
 float amountW;
 float amountH;
 int i;
 int j;
 
     public StarMap (float x, float y ){
  this.x = x;
  this.y = y;
  this.interval = width / 32;
  this.amountW = 15;
  this.amountH =  8;
  
 }
  
  public void render(){
    for(i = 0 ; i < amountW; i++){
       line(x + (interval * i) , y , x + (interval * i), y +(amountH * interval)); 
       for( j = 0; j <= amountH; j++){
         line(x , y + (interval * j) , width / 2 - width / 32, y + (interval * j)); 
       }  
  }
    
    
    
  }
  
  public void update(){
    
    
    
  }
  
  
  public void loadTable(){
    
   //Table table = loadTable("planetData.csv");
    
    
    
  }
  
  
  
  
  
  
  
  
  
  
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nafy
 */

import java.util.ArrayList;
import processing.core.PApplet;

public class UI extends PApplet
{   
    ArrayList<GameObject> objects = new ArrayList<GameObject>(); 
    /*boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys[Character.toUpperCase(c)];
    }
    
    */
    public void settings()
    {
        size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(P3D);
        
        
        
        Opening();
    }

    
    public void draw()
    {
        for(GameObject g: objects)
        {
            g.update();
            g.render();
        }
    }
    
    public void mouseClicked()
    {
        Ship();
    }
    
    public void Opening()
    {
        ArcReactor arc = new ArcReactor (this, (width/2), (height/2), 10, 10, 20 , 10);
        objects.add(arc);
    }
    
    public void Ship()
    {
        background(0);
        stroke(50, 100, 200);
        Radar r = new Radar(this, 1, width / 1.25f, height / 1.25f, 100);
        objects.add(r);
    }
    
    public void cleanUp()
    {
        for(GameObject g: objects)
        {
            objects.remove(g);
        }
    }
    
    
    

    
}

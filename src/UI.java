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
        
        Radar r = new Radar(this, 1, width / 2, height / 2, 100);
        objects.add(r);
    }

    
    public void draw()
    {
        for(GameObject g: objects)
        {
            g.update();
            g.render();
        }
    }
}

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
import processing.core.PVector;

public class UI extends PApplet
{   
    ArrayList<GameObject> objects = new ArrayList<GameObject>();
    public boolean click = false;
    PVector colour = new PVector(0, 0, 0);
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
        background(colour.x, colour.y, colour.z);
        for(GameObject g: objects)
        {
            g.update();
            g.render();
        }
    }
    
    public void mouseClicked()
    {
        click = true;
        Ship();
    }
    
    public void Opening()
    {
        ArcReactor arc = new ArcReactor (this, width/2.0f, height/2.0f, 70, 0, 70 , 50);
        System.out.println("Arc1");
        objects.add(arc);
        ArcReactor arc2 = new ArcReactor (this, width/2.0f, height/2.0f, 80, 70, 140 , 50);
        System.out.println("Arc2");
        objects.add(arc2);
        ArcReactor arc3 = new ArcReactor (this, width/2.0f, height/2.0f, 60, 30, 100 , 50);
        System.out.println("Arc3");
        objects.add(arc3);
        ArcReactor arc4 = new ArcReactor (this, width/2.0f, height/2.0f, 90, 50, 120 , 50);
        System.out.println("Arc4");
        objects.add(arc4);
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

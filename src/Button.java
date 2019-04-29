
import processing.core.PVector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nafy
 */
public class Button extends GameObject
{
    private float width;
    private float height;
    private String text;
    private UI ui;

    public Button(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        pos = new PVector(x, y);
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(255);
        ui.rect(pos.x, pos.y, width, height);
        ui.textAlign(ui.CENTER, ui.CENTER);
        ui.text(text, pos.x + width * 0.5f, pos.y + height * 0.5f);
    }
    
    public void update(){
        
    }
}

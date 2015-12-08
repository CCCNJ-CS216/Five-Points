/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FivePoints.Graphics;

import java.util.Random;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.paint.Paint;

/**
 *
 * @author Warren
 */
public class CustomGraphics {
    private Canvas canvas;
    
    public CustomGraphics(Canvas canvas){
        this.canvas = canvas;
    }
    
    public void setCanvas(Canvas canvas){
        this.canvas = canvas;
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
    
    public void drawRect(){
        Random rand = new Random();
        int x = rand.nextInt((int) canvas.getWidth());
        int y = rand.nextInt((int) canvas.getHeight());
        int w = rand.nextInt(10);
        int h = rand.nextInt(10);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(BLACK);
        gc.fillRect(x, y, w, h);
    }
    
    public void drawRect(int xpos, int ypos, int width, int height, Paint fill){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(fill);
        gc.fillRect(xpos,ypos,width,height);
    }

    public void clear() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(WHITE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }
}

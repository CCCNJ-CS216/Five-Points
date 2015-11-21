package FivePoints.General;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.paint.Paint;

/**
 *
 * @author Warren
 */

/*
    Provide methods so that actors don't need to know about the GraphicsContext.
    Created CustomCanvas to provide extra functionality, such as clearing the screen.
*/
public class CustomCanvas extends Canvas {

    public CustomCanvas(int width, int height) {
        super(width,height);
    }
    
    public void clear(){
        GraphicsContext temp = this.getGraphicsContext2D();
        temp.setFill(WHITE);
        temp.fillRect(0, 0, getWidth(), getHeight());
    }
    
    public void drawRect(int xpos, int ypos, int width, int height, Paint paint){
        GraphicsContext temp = this.getGraphicsContext2D();
        temp.setFill(paint);
        temp.fillRect(xpos, ypos, width, height);
    }

    
    
}

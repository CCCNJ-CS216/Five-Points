package FivePoints.GraphNavigation;

import java.util.ArrayList;
import FivePoints.General.Actor;

/**
 * CoordinateMap manages a set of nodes that are either occupied or free.
 * When moving a whole object, the translation must only occupy blocks which
 * are free, or else the translation refuses to execute.
 */
public class WorldMap extends Grid {

   

    private int resx;
    private int resy;

//creates grid of 'empty' nodes to the users will
  // need res for calculations
    //
    public WorldMap(int x, int y,int resolution){
          super(x,y);
        resx=resolution*(4/3);
      resy=resolution;
  

        
    }
    public void addMapitem(double x,double y, Actor a){
    int itemx; //temp ints to add item
    int itemy;
    //next four lines sets the mouse inputs to grd size and then turns them into 
    //coordinates
    x=x*(sizex/resx);    
    y=y*(sizey/resy);
    itemx=(int)x;
    itemy=(int)y;
   super.addGriditem(itemx,itemy,a);
     }
    public void changeMapRes(int res){
    resx=res*(4/3);
    resy=res;
       //clears grid though...
    
        
       
        }
}
        
    
        
    
    
    

    



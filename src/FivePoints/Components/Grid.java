package FivePoints.GraphNavigation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javafx.geometry.Point2D;
import FivePoints.General.Actor;
import java.util.Map;


/**
grid is designed to keep track of the list of actors at a given point on an imaginary grid
* warning:has not been tested properly if you run into a problem email me @ jwalder@student.cccnj.edu
 */
public abstract class Grid {

   //initialization of grid
    protected Map map = new HashMap<Point2D,ArrayList<Actor>>();
   
    protected int sizex;
    //grid size,x by y
    protected int sizey;
  //constructor creates reference points given an x and y both being maximum of grid
   //creates a list of acotrs for each and every point
    //on a side note the x and y could be the domain constraints and the additem methode will add actor lists at reference points as needed 
    public Grid(int x,int y){
        sizex=x;
        sizey=y;
        map = new HashMap<Point2D,ArrayList<Actor>>();
           for(int i = 0; i < x; i++) {
          
            for(int j = 0; j < y; j++){
                
                map.put(new Point2D(i,j),new ArrayList<Actor>());
            }

        }
    }
    //given a Point2D object and actor this will iterate through the list and add the Actor to the list at thate given reference point
    public void addGriditem(Point2D  p, Actor a){
      Iterator<Map.Entry<Point2D,ArrayList<Actor>>>  it = map.entrySet().iterator();
        while(it.hasNext()){
           Map.Entry<Point2D,ArrayList<Actor>> point=it.next();
            if(p==point.getKey())
             point.getValue().add(a);  
            else
                System.out.println("point does not exist within comfines of grid");
            }
        it.remove();
      
         }
     //given an x and y and actor this will iterate through the list and add the Actor to the list at thate given reference point
      public void addGriditem(int x,int y, Actor a){
             
          Point2D p= new Point2D(x,y);
      Iterator<Map.Entry<Point2D,ArrayList<Actor>>>  it = map.entrySet().iterator();
        while(it.hasNext()){
           Map.Entry<Point2D,ArrayList<Actor>> point=it.next();
            if(p==point.getKey())
             point.getValue().add(a);  
            else
                System.out.println("point does not exist within comfines of grid");
            }
        it.remove();
      
         }
    
   //clears grid, what more can i say
    public void clearGrid(){
       
                map.clear();     
                
           for(int i = 0; i < sizex; i++) {
          
            for(int j = 0; j < sizey; j++){
                
                map.put(new Point2D(i,j),new ArrayList<Actor>());
            }

        }

       
    }
//changes grid size    
//clears grid though...
        public void changeGridSize(int x, int y){
           clearGrid();
           sizex=x;
           sizey=y;
           for(int i = 0; i < sizex; i++) 
          
            for(int j = 0; j < sizey; j++)
                
                map.put(new Point2D(i,j),new ArrayList<Actor>());
            
           
         
       
          }
          //returns value of key given coordinates
         public ArrayList<Actor> getItem(int x, int y){
          
          Point2D p= new Point2D(x,y);
           ArrayList<Actor> a=(ArrayList<Actor>)map.get(p);
      return a;
           }
         //same thing as last just with Point2D object this time
           public ArrayList<Actor> getItem(Point2D p){
          ArrayList<Actor> a=(ArrayList<Actor>)map.get(p);
      return a;
       }
        
          //only use this if the actual get methode does not work
        public ArrayList<Actor> getItemtest(int x, int y){
          ArrayList<Actor> a= null;
          Point2D p= new Point2D(x,y);
          Iterator<Map.Entry<Point2D,ArrayList<Actor>>>  it = map.entrySet().iterator();
           while(it.hasNext()){
           Map.Entry<Point2D,ArrayList<Actor>> point=it.next();
            if(p==point.getKey())
             a = point.getValue();  
           
            }
        it.remove();
        return a;
        
        }
       
        }
        
    
        
    
    
    

    



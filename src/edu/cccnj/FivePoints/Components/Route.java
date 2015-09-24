import java.util.ArrayList;
/**
 * @author: Josue Gomez
 * @version: 1.0
 */
public class Route
{
    public ArrayList <SimplePair> route = new ArrayList <>();
    
    public Route()
    {
    }
    
    public Lane getLane(int route)
    {
        return this.route.get(route).getLane();
    }
    
    public Integer getInteger(int integer)
    {
        return this.route.get(integer).getInteger();
    }
    
   
   
    }


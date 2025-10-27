import greenfoot.*;
import greenfoot.Color;

public class garisMerah extends garis
{
    public void addedToWorld(World world)
    {
        int d = 15;

        GreenfootImage image = new GreenfootImage(world.getWidth() - 10, d);
        

        image.setColor(Color.GREEN); 
        image.fill(); 
        setImage(image);
    }
    
    public void act()
    {
       
    }
}

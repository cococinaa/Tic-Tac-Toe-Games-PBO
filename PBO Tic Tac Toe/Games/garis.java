import greenfoot.*;
import greenfoot.Color;

public class garis extends Actor
{
    public void addedToWorld(World world)
    {
        int d = 15;

        GreenfootImage image = new GreenfootImage(world.getWidth() - 10, d);
        
        image.setColor(Color.BLACK);
        image.fill(); 
        setImage(image);
    }
    
    public void act()
    {

    }
}

import greenfoot.*;
import greenfoot.Color; // Menggunakan Greenfoot's Color class

public class garis extends Actor
{
    public void addedToWorld(World world)
    {
        int d = 15;
        // Membuat gambar GreenfootImage dengan lebar World - 10 sel, dan tinggi 15 sel (d)
        GreenfootImage image = new GreenfootImage(world.getWidth() - 10, d);
        
        image.setColor(Color.BLACK);
        image.fill(); // Mengisi seluruh area gambar dengan warna yang disetel (GRAY)
        setImage(image);
    }
    
    // Metode act() kosong karena garis ini statis
    public void act()
    {
        // Add your action code here.
    }
}
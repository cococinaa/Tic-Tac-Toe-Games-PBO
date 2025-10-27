import greenfoot.*;
import greenfoot.Color;

public class garisMerah extends garis
{
    public void addedToWorld(World world)
    {
        int d = 15;
        // Membuat gambar dengan lebar World - 10 sel, dan tinggi 15 sel (d)
        // Ini mewarisi perilaku dari kelas 'garis' tetapi mengganti warna.
        GreenfootImage image = new GreenfootImage(world.getWidth() - 10, d);
        
        // Catatan: Nama kelasnya 'garisMerah', tetapi warnanya diatur menjadi GREEN
        image.setColor(Color.GREEN); 
        image.fill(); // Mengisi seluruh area gambar dengan warna HIJAU
        setImage(image);
    }
    
    // Metode act() kosong karena garis ini statis
    public void act()
    {
        // Add your action code here.
    }
}
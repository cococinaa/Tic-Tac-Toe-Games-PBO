import greenfoot.*;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
// Anda harus menggunakan java.awt.Color saat memakai Graphics2D
import java.awt.Color; 

public class Kotak extends Actor
{
    public int ID = 0, delta = 200;

    public Kotak(int delta)
    {
        this.delta = delta;
    }

    public Kotak(int id, int delta)
    {
        ID = id;
        this.delta = delta;
    }

    public void addedToWorld(World world)
    {
        GreenfootImage image = new GreenfootImage(delta, delta);
        int d = 30; // Digunakan sebagai ketebalan (thickness)
        
        if (ID == 0) // Jika ID adalah 0, gambar simbol X (Merah)
        {
            // --- INI ADALAH PERBAIKANNYA ---
            // Kita gunakan Graphics2D untuk menggambar 'X' secara langsung
            Graphics2D g2 = image.getAwtImage().createGraphics();
            
            // Atur ketebalan garis
            g2.setStroke(new BasicStroke(d)); 
            
            // Atur warna ke MERAH (HARUS java.awt.Color)
            g2.setColor(java.awt.Color.RED); 

            // Garis pertama: dari kiri atas ke kanan bawah
            // Kita beri padding 'd' agar tebal garis tidak terpotong di tepi
            g2.drawLine(d, d, delta - d, delta - d);
            
            // Garis kedua: dari kanan atas ke kiri bawah
            g2.drawLine(delta - d, d, d, delta - d);
            
            // Selesai menggambar
            g2.dispose();
            
            // Perintah image.setRotation(45); DIBUANG karena itulah penyebab error
        }
        else // Jika ID bukan 0, gambar simbol O (Biru)
        {
            Graphics2D g2 = image.getAwtImage().createGraphics();
            g2.setStroke(new BasicStroke(d));
            g2.setColor(java.awt.Color.BLUE); // Gunakan java.awt.Color
            g2.drawArc(d, d, image.getWidth() - 2 * d, image.getHeight() - 2 * d, 0, 360);
            g2.dispose();
        }
    
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }  
}
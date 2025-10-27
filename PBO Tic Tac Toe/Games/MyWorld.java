import greenfoot.*;
import greenfoot.Color;

public class MyWorld extends World
{
    private int[] Box = new int[9];
    private int delta = 200, TURN = 0;
    private boolean GAMEOVER = false;
    private int WINNER = -1; 

    public MyWorld()
    {
        super(600, 600, 1);
        setBackground("background.jpg");

        garis line = new garis();
        addObject(line, delta, (int)(0.5 * getHeight()));
        line.setRotation(90);

        line = new garis();
        addObject(line, 2 * delta, (int)(0.5 * getHeight()));
        line.setRotation(90);

        line = new garis();
        addObject(line, (int)(0.5 * getWidth()), delta);

        line = new garis();
        addObject(line, (int)(0.5 * getWidth()), 2 * delta);

        for (int i = 0; i < 9; i++) {
            Box[i] = -1;
        }
        
        TURN = Greenfoot.getRandomNumber(2);
        GAMEOVER = false;
        WINNER = -1;
    } 
   
    private void addBox(int a, int px, int py)
    {
        Kotak kotak = new Kotak(a, delta);
        addObject(kotak, px, py);
    }

    private int numFilled()
    {
        int num = 0;
        for (int i = 0; i < 9; i++) {
            if (Box[i] >= 0) {
                num++;
            }
        }
        return num;
    }

    private int searchBestPosition(int turn)
    {
        int[] cek = new int[]{0, 1, 2, 0, 2, 1, 1, 2, 0, 3, 4, 5, 3, 5, 4, 4, 5, 3, 6, 7, 8, 6, 8, 7, 7, 8, 6, 0, 3, 6, 0, 6, 3, 3, 6, 0, 1, 4, 7};
        for (int i = 0; i < cek.length / 3; i++) {
            if (Box[cek[3 * i + 0]] == Box[cek[3 * i + 1]] && Box[cek[3 * i + 1]] == turn && Box[cek[3 * i + 2]] < 0) {
                return cek[3 * i + 2];
            }
        }
        return -1;
    }

    private int cekWin()
    {
        int[] cek = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 0, 3, 6, 1, 4, 7, 2, 5, 8, 0, 4, 8, 2, 4, 6};
        for (int i = 0; i < cek.length / 3; i++) { // 'i' adalah indeks baris (0-7)
            if (Box[cek[3 * i + 0]] == Box[cek[3 * i + 1]] && Box[cek[3 * i + 1]] == Box[cek[3 * i + 2]] && Box[cek[3 * i + 0]] >= 0) {
                
  
                WINNER = i;
                
                return Box[cek[3 * i + 0]]; 
            }
        }
        return -1;
    }

    public void act()
    {
        int numisi = numFilled();
        if (numisi == 9) GAMEOVER = true;
        
        int win = cekWin(); 
        if (win >= 0) GAMEOVER = true;
        
        if (!GAMEOVER)
        {
            if (TURN == 0)
            {
                if (Greenfoot.mouseClicked(null))
                {
                    MouseInfo mouse = Greenfoot.getMouseInfo();
                    int io = (mouse.getX()) / delta % 3;
                    int jo = (mouse.getY()) / delta % 3;
                    int index = io + 3 * jo;
                    if (index >= 0 && index < 9) {
                        if (Box[index] < 0) {
                            Box[index] = TURN;
                            addBox(TURN, (int)((io + 0.5) * delta), (int)((jo + 0.5) * delta)); 
                            TURN = (TURN == 0) ? 1 : 0;
                        }
                    }
                }
            } else {
                if (numisi == 0) {
                    int a = Greenfoot.getRandomNumber(Box.length);
                    Box[a] = TURN;
                    int io = a % 3;
                    int jo = a / 3;

                    addBox(TURN, (int)((io + 0.5) * delta), (int)((jo + 0.5) * delta));
                    TURN = (TURN == 0) ? 1 : 0;
                } else if (numisi == 1 || numisi == 2) {
                    if (Box[4] < 0) {
                        int a = 4;
                        int io = a % 3;
                        int jo = a / 3;
                        Box[a] = TURN;
                        // --- PERBAIKAN 2: '0.S' diubah menjadi '0.5' ---
                        addBox(TURN, (int)((io + 0.5) * delta), (int)((jo + 0.5) * delta));
                        TURN = (TURN == 0) ? 1 : 0;
                    } else {
                        boolean pasang = false;
                        while (!pasang)
                        {
                            int a = Greenfoot.getRandomNumber(9);
                            if (Box[a] < 0) {
                                int io = a % 3;
                                int jo = a / 3;
                                Box[a] = TURN;

                                addBox(TURN, (int)((io + 0.5) * delta), (int)((jo + 0.5) * delta));
                                TURN = (TURN == 0) ? 1 : 0;
                                pasang = true;
                            }
                        }
                    }
                } else {
            
                    if(numisi==0){ 
                        int a=Greenfoot.getRandomNumber(Box.length);
                        Box[a]=TURN;
                        int io=a%3;
                        int jo=a/3;
                        addBox(TURN,(int)((io+0.5)*delta),(int)((jo+0.5)*delta)); 
                        TURN=(TURN==0)?1:0;
                    }else if(numisi==1 || numisi==2){
                        if(Box[4]<0){
                            int a=4;
                            int io=a%3;
                            int jo=a/3;
                            Box[a]=TURN;
                            addBox(TURN,(int)((io+0.5)*delta),(int)((jo+0.5)*delta)); 
                            TURN=(TURN==0)?1:0;
                        }else{
                            boolean pasang=false;
                            while(!pasang)
                            {
                                int a=Greenfoot.getRandomNumber(9);
                                if(Box[a]<0){
                                    int io=a%3;
                                    int jo=a/3;
                                    Box[a]=TURN;
                                    addBox(TURN,(int)((io+0.5)*delta),(int)((jo+0.5)*delta)); 
                                    TURN=(TURN==0)?1:0;
                                    pasang=true;
                                }
                            }
                        }

                        
                    }else{ 

                        int a = searchBestPosition(0); 
                        int waktu = 0;
                        if (a < 0) {
                            a = searchBestPosition(1); 
                            waktu++;
                        }

                        if (a < 0) {
                            waktu++;
                            a = Greenfoot.getRandomNumber(Box.length);
                            while (true) {
                                waktu++;
                                if (Box[a] < 0) {
                                    break;
                                } else {
                                    a = Greenfoot.getRandomNumber(Box.length);
                                }
                            }
                        }
                        
                        if (a >= 0) {
                            int io = a % 3;
                            int jo = a / 3;
                            Box[a] = TURN;
                            addBox(TURN, (int)((io + 0.5) * delta), (int)((jo + 0.5) * delta)); 
                            TURN = (TURN == 0) ? 1 : 0;
                        }
                    }
                }
            }
        } else {

            String text = "";
            if (win >= 0) { 
                text = (win == 0) ? "Player Win" : "Computer Win";
                
        
                if (WINNER == 0) { 
                    addObject(new garisMerah(), (int)(0.5 * getWidth()), (int)(0.5 * delta));
                } else if (WINNER == 1) { 
                    addObject(new garisMerah(), (int)(0.5 * getWidth()), (int)(1.5 * delta));
                } else if (WINNER == 2) { 
                    addObject(new garisMerah(), (int)(0.5 * getWidth()), (int)(2.5 * delta));
                } else if (WINNER == 3) { 
                    garisMerah rd = new garisMerah();
                    addObject(rd, (int)(0.5 * delta), (int)(0.5 * getHeight()));
                    rd.setRotation(90);
                } else if (WINNER == 4) {
                    garisMerah rd = new garisMerah();
                    addObject(rd, (int)(1.5 * delta), (int)(0.5 * getHeight()));
                    rd.setRotation(90);
                } else if (WINNER == 5) { 
                    garisMerah rd = new garisMerah();
                    addObject(rd, (int)(2.5 * delta), (int)(0.5 * getHeight()));
                    rd.setRotation(90);
                } else if (WINNER == 6) {
                    garisMerah rd = new garisMerah();
                    addObject(rd, (int)(0.5 * getWidth()), (int)(0.5 * getHeight()));
                    rd.setRotation(45);
                } else if (WINNER == 7) { 
                    garisMerah rd = new garisMerah();
                    addObject(rd, (int)(0.5 * getWidth()), (int)(0.5 * getHeight()));
                    rd.setRotation(-45);
                }
            } else { 
                text = "Draw";
            }
            Tamat theend = new Tamat();
            theend.setImage(new GreenfootImage(text, 80, Color.ORANGE, Color.WHITE));
            addObject(theend, (int)(0.5 * getWidth()), (int)(0.5 * getHeight()));
        }
    }
}

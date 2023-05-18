import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16; //16x16
    final int scale = 3;

    final int tileSize = originalTileSize*scale;

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    //player defaults
    int playerPositionX = 100;
    int playerPositionY = 100;
    private int playerSpeed = 4;


    private int FPS = 60;
    public KeyHandler keyH = new KeyHandler();
    Thread gameThread;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null){

            update();

            repaint();


            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0 ){
                    remainingTime = 0;
                }

                Thread.sleep( (long) remainingTime);
                nextDrawTime += drawInterval;


            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void update(){
        if (keyH.upCase){
            System.out.println(keyH.upCase);
        }

        //System.out.println(keyH.upCase+" "+keyH.rightCase+" ");
        if(keyH.upCase){
            playerPositionY -= playerSpeed;
            System.out.println("AAAA");
        } else if (keyH.downCase) {
            playerPositionY += playerSpeed;
            System.out.println("BBBB");
        } else if (keyH.leftCase) {
            playerPositionX -= playerSpeed;
            System.out.println("CCCC");
        } else if (keyH.rightCase) {
            playerPositionX += playerSpeed;
            System.out.println("DDD");
        }
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(playerPositionX, playerPositionY, tileSize, tileSize);
        g2.dispose();
    }

}

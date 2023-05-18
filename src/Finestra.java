import javax.swing.*;


// Questa dovrebbe essere la view
public class Finestra {
    JFrame f;
    Finestra(){
        f=new JFrame();//creating instance of JFrame

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        gamePanel.startGameThread();
        f.add(gamePanel);

        f.pack();
        f.setLocationRelativeTo(null);

        //f.setSize(400,500);//400 width and 500 height
        //f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }

}

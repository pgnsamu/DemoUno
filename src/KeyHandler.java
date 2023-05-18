import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upCase, downCase, leftCase, rightCase;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code){
            case KeyEvent.VK_W:
                upCase = true;
                //System.out.println("up");
                break;
            case KeyEvent.VK_S:
                downCase = true;
                //System.out.println("Down");
                break;
            case KeyEvent.VK_A:
                leftCase = true;
                //System.out.println("Left");
                break;
            case KeyEvent.VK_D:
                rightCase = true;
                //System.out.println("Right");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println(upCase+" "+downCase+" "+leftCase+" "+rightCase);
        int code = e.getKeyCode();
        switch (code){
            case KeyEvent.VK_W:
                upCase = false;
                //System.out.println("up");
                break;
            case KeyEvent.VK_S:
                downCase = false;
                //System.out.println("Down");
                break;
            case KeyEvent.VK_A:
                leftCase = false;
                //System.out.println("Left");
                break;
            case KeyEvent.VK_D:
                rightCase = false;
                //System.out.println("Right");da
                break;
        }
    }
    public String getDirection(){
        String a = "";
        if(upCase){
            a = "AAAA";
            System.out.println("AAAA");
        } else if (downCase) {
            a = "bbbb";
            System.out.println("BBBB");
        } else if (leftCase) {
            a = "cccc";
            System.out.println("CCCC");
        } else if (rightCase) {
            a = "dddd";
            System.out.println("DDD");
        }
        return a;
    }
}


import view.ButtonsFactory;
import controller.Controller;

import java.awt.*;

class Main{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    Controller cont = new Controller();
                    //ButtonsFactory factory = new ButtonsFactory();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }
}

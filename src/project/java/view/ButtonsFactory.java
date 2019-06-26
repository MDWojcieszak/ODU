package view;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonsFactory implements view.AbstractFactory<JButton>
{
    public ButtonsFactory()
    {

    }

    @Override
    public ArrayList<JButton> createButtons(int n, int x, int width)
    {
        ArrayList<JButton>buttons=new ArrayList<JButton>();
        for(int i=0;i<n;i++)
        {
            JButton button = new JButton();
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button.setBounds(x, 63+25*i, width, 23);
            button.setVisible(false);
            buttons.add(button);
        }
        return buttons;
    }
}


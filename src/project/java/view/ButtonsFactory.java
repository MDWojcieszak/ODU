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
    public ArrayList<JButton> createButtons(int n)
    {
        if(n>15)
            n=15;
        ArrayList<JButton>buttons=new ArrayList<JButton>();
        for(int i=0;i<n;i++)
        {
            JButton button = new JButton();
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button.setBounds(231, 63+25*i, 549, 23);
            button.setVisible(false);
            buttons.add(button);
        }
        return buttons;
    }
}


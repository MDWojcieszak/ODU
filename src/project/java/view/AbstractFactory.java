package view;
import java.util.ArrayList;

public interface AbstractFactory<T>
{
    ArrayList<T> createButtons(int n, int x, int width);
}


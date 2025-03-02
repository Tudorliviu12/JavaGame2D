package main;

import javax.swing.*;

public class Singleton extends JFrame {
    private static JFrame single_instance = null;
    private Singleton(){};
    public static synchronized JFrame getInstance(){
        if(single_instance == null){
            single_instance = new JFrame();
        }
        return single_instance;
    }
}

package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//obiect utilizat la finalul nivelurilor 1 si 2, pentru trecerea catre nivelul urmator
public class OBJ_Portal1 extends SuperObject{
    public OBJ_Portal1(){
        name = "Portal1";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/portal1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

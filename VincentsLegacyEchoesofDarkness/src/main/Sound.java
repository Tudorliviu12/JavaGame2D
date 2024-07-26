package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

//clasa Sound gestioneaza muzica de fundal si efectele sonore
public class Sound {
    Clip clip;
    URL soundURL[] = new URL[20];

    public Sound(){
        soundURL[0] = getClass().getResource("/sound/graveyard.wav");
        soundURL[1] = getClass().getResource("/sound/bones.wav");
        soundURL[2] = getClass().getResource("/sound/menumusic.wav");
        soundURL[3] = getClass().getResource("/sound/jungle.wav");
        soundURL[4] = getClass().getResource("/sound/coconut.wav");
        soundURL[5] = getClass().getResource("/sound/teleport.wav");
        soundURL[6] = getClass().getResource("/sound/eatpizza.wav");
        soundURL[7] = getClass().getResource("/sound/keys.wav");
        soundURL[8] = getClass().getResource("/sound/scarab.wav");
        soundURL[9] = getClass().getResource("/sound/desert.wav");
        soundURL[10] = getClass().getResource("/sound/sipcoffee.wav");
        soundURL[11] = getClass().getResource("/sound/dying.wav");
        soundURL[12] = getClass().getResource("/sound/camel.wav");
    }

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e){

        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}

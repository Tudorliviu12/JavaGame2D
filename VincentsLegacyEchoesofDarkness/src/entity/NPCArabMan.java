package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NPCArabMan extends Entity {
    public NPCArabMan(GamePanel gp) throws IOException {
        super(gp);
        direction = "down";
        getImage();
        setDialogue();
        dialogueIndex = 0;
        camelSpawnIndex = 0;
        coffeeSpawnIndex = 0;
        camelCounter = 0;
    }

    public void setValuesNPCArabMan(){
        direction = "down";
        dialogueIndex = 0;
        camelSpawnIndex = 0;
        coffeeSpawnIndex = 0;
        camelCounter = 0;
    }

    public void getImage() throws IOException {
        down1 = ImageIO.read(getClass().getResourceAsStream("/arabman/NPCArabMan.png"));
    }

    //functie care initializeaza vectorul de replici de dialog cu NPC ul
    public void setDialogue() {
        dialogue[0] = "Bedouin Merchant: shabi! law samahta! saeduni, 'ana yayisu!";
        dialogue[1] = "Vincent: I'm sorry, I can't understand you.";
        dialogue[2] = "Bedouin Merchant: Young man! Please! Help me, I'm desperate!";
        dialogue[3] = "Vincent: What's wrong?";
        dialogue[4] = "Bedouin Merchant: My beautiful camels got lost in a sandstorm! \n Please find my three camels and bring them to me as soon as possible! \n Without them I'm ruined, I can't support my family! \n Be careful! They can hurt you.";
        dialogue[5] = "Bedouin Merchant: Please! I lost three camels!";
        dialogue[6] = "Bedouin Merchant: My camels! My sweet camels! Thank you, good traveler! \n Here, drink this. You look like you need a strong coffee.";
        dialogue[7] = "Bedouin Merchant: ana saeid jida! laqad tama 'iinqadh eayilati alan!";
    }

    //functie apelata in momentul in care player ul interactioneaza cu NPC ul
    public void speak(){
        if(dialogueIndex < 5) {
            gp.ui.currentDialogue = dialogue[dialogueIndex];
            dialogueIndex++;
        }
        else if(dialogueIndex == 5){
            camelSpawnIndex = 1;
            dialogueIndex++;
        }
        else if(gp.player.camelCounter > 0 && gp.player.camelCounter < 3){
            gp.ui.currentDialogue = dialogue[5];
        }
        else if(gp.player.camelCounter >= 3){ //daca player ul are 3 camile si vorbeste cu npc ul, se spawneaza cafeaua
            gp.ui.currentDialogue = dialogue[dialogueIndex];
            if(dialogueIndex == 6) {
                coffeeSpawnIndex = 1;
            }
            while(dialogueIndex<7){
                dialogueIndex++;
            }
        }
    }

//    public void speak(){
//        if(dialogueIndex <= 5) {
//            gp.ui.currentDialogue = dialogue[dialogueIndex];
//            dialogueIndex++;
//        }
//        else if(dialogueIndex == 5){
//            camelSpawnIndex = 1;
//        }
//        else if(gp.player.camelCounter > 0 && gp.player.camelCounter < 3){
//            gp.ui.currentDialogue = dialogue[5];
//        }
//        else if(gp.player.camelCounter == 3){
//            gp.ui.currentDialogue = dialogue[dialogueIndex];
//            if(dialogueIndex == 6) {
//                coffeeSpawnIndex = 1;
//            }
//            while(dialogueIndex<7){
//                dialogueIndex++;
//            }
//        }
//    }
}

package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NPCArcheologist extends Entity {
    public NPCArcheologist(GamePanel gp) throws IOException {
        super(gp);
        direction = "down";
        getImage();
        setDialogue();
        dialogueIndex = 0;
        keySpawnIndex = 0;
        pizzaSpawnIndex = 0;
        pizzaCounter = 0;
    }

    public void setValuesNPCArcheologist(){
        direction = "down";
        dialogueIndex = 0;
        keySpawnIndex = 0;
        pizzaSpawnIndex = 0;
        pizzaCounter = 0;
    }

    public void getImage() throws IOException {
        down1 = ImageIO.read(getClass().getResourceAsStream("/archeologist/NPCArcheologist.png"));
    }

    //functie care initializeaza vectorul de replici de dialog cu NPC ul
    public void setDialogue() {
        dialogue[0] = "Archeologist: Hey! Hey, you, skeleton face! I need your help.";
        dialogue[1] = "Vincent: What's wrong?";
        dialogue[2] = "Archeologist: I lost in the jungle the key that opens this \n temple full of treasures. One of those goblins must have stolen it. \n Help me find it and I'll reward you!";
        dialogue[3] = "Archeologist: Hurry up, I don't have all day.";
        dialogue[4] = "Archeologist: Wow, you really found it! Thanks a lot. \n Here, as a reward. You're skinny as a skeleton, eat this.";
        dialogue[5] = "Archeologist: All the treasures will be mine...";
    }

    //functie apelata in momentul in care player ul interactioneaza cu NPC ul
    public void speak(){
        if(dialogueIndex <= 3) {
            gp.ui.currentDialogue = dialogue[dialogueIndex];
            dialogueIndex++;
        }

        else if(gp.player.keyCounter == 1){ //daca player ul are cheia, se spawneaza pizza
            gp.ui.currentDialogue = dialogue[dialogueIndex];
            if(dialogueIndex == 4) {
                pizzaSpawnIndex = 1;
            }
            while(dialogueIndex<5){
                dialogueIndex++;
            }
        }
    }

//    public void speak() {
//        if (gp.player.boneCounter == 0 && dialogueIndex <= 6) {
//            gp.ui.currentDialogue = dialogue[dialogueIndex];
//            dialogueIndex++;
//        }
//        if (dialogueIndex == 7) {
//                boneSpawnIndex = 1;
//        }
//        if (gp.player.boneCounter > 0 && gp.player.boneCounter < 20) {
//            gp.ui.currentDialogue = dialogue[7];
//        }
//        if (gp.player.boneCounter == 20)
//            gp.ui.currentDialogue = dialogue[8];
//        portalSpawnIndex = 1;
//        }
}

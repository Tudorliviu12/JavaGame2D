package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NPCHelena extends Entity {
    public NPCHelena(GamePanel gp) throws IOException {
        super(gp);
        direction = "down";
        getImage();
        setDialogue();
        dialogueIndex = 0;
        boneSpawnIndex = 0;
        portalSpawnIndex = 0;
        fruitSpawnIndex = 0;
        scarabSpawnIndex = 0;
        potionSpawnIndex = 0;
    }

    public void setValuesLoadNPCHelena(){
        direction = "down";
        boneSpawnIndex = 0;
        portalSpawnIndex = 0;
        fruitSpawnIndex = 0;
        scarabSpawnIndex = 0;
        potionSpawnIndex = 0;
    }

    public void getImage() throws IOException {
        down1 = ImageIO.read(getClass().getResourceAsStream("/Helena/down1.png"));
    }

    //functie care initializeaza vectorul de replici de dialog cu NPC ul
    public void setDialogue() {
        dialogue[0] = "Helena: Well, Vincent, I knew my stepmother would find out\n about you, but I didn't think so soon.";
        dialogue[1] = "Vincent: What can we do?";
        dialogue[2] = "Helena: First of all, we have to make you human again. \n You can't beat her as a skeleton. On the bright side, \n my potions manual has everything we need. Except...";
        dialogue[3] = "Vincent: Except what?";
        dialogue[4] = "Helena: We are missing some essential ingredients. \n You have to travel through three different worlds \n to get them.";
        dialogue[5] = "Vincent: What do you mean?";
        dialogue[6] = "Helena: This is probably going to sound strange to you but...\n I need 20 bones from the graveyard to establish \n a link with the afterlife and achieve regeneration. \n Come back to me when you have them all.";
        dialogue[7] = "Helena: I said I needed 20 bones!";
        dialogue[8] = "Helena: Good, you're back! And you brought me what \n I asked for! I will open a portal to the next \n dimension you must venture into!";
        dialogue[9] = "Helena: Glad you made it out okay, Vincent. From this wild jungle, \n I need 20 coconuts for the potion to restore your strength.";
        dialogue[10] = "Helena: Take your time, come back when you're ready!";
        dialogue[11] = "Helena: I said I needed 20 coconuts!";
        dialogue[12] = "Helena: Perfect! I've added the ingredients to the magic potion! \n I am now opening a portal that will lead you \n to your third and final adventure.";
        dialogue[13] = "Helena: The potion is almost ready, Vincent. Just one more ingredient \n is needed. You must bring me 20 magical scarabs from the \n desert to bind the bonds in your body.";
        dialogue[14] = "Helena: Bring me what I asked for and I'll give you the potion.";
        dialogue[15] = "Helena: I told you I need 20 scarabs!";
        dialogue[16] = "Congratulations, Vincent! Finally! The potion is ready! \n You'll regain your human form!";
    }

    /*functie apelata in momentul in care player ul interactioneaza cu NPC ul, diferita in functie de nivel intrucat
    NPC ul Helena este utilizat in toate cele 3 niveluri
     */
    public void speak() {
        if (gp.currentMap == 0) {
            if (gp.player.boneCounter == 0 && dialogueIndex <= 6) {
                gp.ui.currentDialogue = dialogue[dialogueIndex];
                dialogueIndex++;
            }
            if (dialogueIndex == 7) {
                boneSpawnIndex = 1;
            }
            if (gp.player.boneCounter > 0 && gp.player.boneCounter < 20) {
                gp.ui.currentDialogue = dialogue[7];
            }
            if (gp.player.boneCounter >= 20) {
                gp.ui.currentDialogue = dialogue[8];
                portalSpawnIndex = 1;
            }
        }
        if (gp.currentMap == 1) {
            if (dialogueIndex <= 10) {
                gp.ui.currentDialogue = dialogue[dialogueIndex];
                dialogueIndex++;
            } else if (gp.player.fruitCounter > 0 && gp.player.fruitCounter < 20) {
                gp.ui.currentDialogue = dialogue[11];
            } else if (gp.player.fruitCounter >= 20) {
                gp.ui.currentDialogue = dialogue[12];
                portalSpawnIndex = 1;
            }
        }
        if (gp.currentMap == 2) {
            if (dialogueIndex <= 14) {
                gp.ui.currentDialogue = dialogue[dialogueIndex];
                dialogueIndex++;
            } else if (gp.player.scarabCounter > 0 && gp.player.scarabCounter < 20) {
                gp.ui.currentDialogue = dialogue[15];
            } else if (gp.player.scarabCounter >= 20) {
                gp.ui.currentDialogue = dialogue[16];
                potionSpawnIndex = 1;
            }
        }
    }
}
//        if (gp.currentMap == 2) {
//            if (gp.player.scarabCounter == 0 && dialogueIndex <= 14) {
//                gp.ui.currentDialogue = dialogue[dialogueIndex];
//                dialogueIndex++;
//            }
//            if (dialogueIndex == 14) {
//                scarabSpawnIndex = 1;
//            }
//            if (gp.player.scarabCounter > 0 && gp.player.scarabCounter < 20) {
//                gp.ui.currentDialogue = dialogue[15];
//            }
//            if (gp.player.scarabCounter == 20) {
//                gp.ui.currentDialogue = dialogue[16];
//                potionSpawnIndex = 1;
//            }
//        }
//    }
//        if(gp.currentMap == 1){
//            if(gp.player.fruitCounter == 0){
//                dialogueIndex = 9;
//                gp.ui.currentDialogue = dialogue[dialogueIndex];
//            }
//            if (dialogueIndex == 9) {
//                fruitSpawnIndex = 1;
//            }
//            if(gp.player.fruitCounter > 0 && gp.player.fruitCounter < 20){
//                dialogueIndex = 10;
//                gp.ui.currentDialogue = dialogue[10];
//            }
//            if (gp.player.fruitCounter == 20){
//                gp.ui.currentDialogue = dialogue[11];
//                portalSpawnIndex = 1;
//        }
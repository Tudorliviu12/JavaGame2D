package main;

import java.awt.*;

import static main.GamePanel.deleteAllData;
import static main.GamePanel.resetAutoIncrement;

public class EventHandler { //verificam realizarea evenimentelor deosebite (ex teleport)
    GamePanel gp;
    EventRect eventRect[][][];
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;

    public EventHandler(GamePanel gp){
        this.gp = gp;
        eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
        int map = 0;
        int col = 0, row = 0;
        while(map < gp.maxMap && col<gp.maxWorldCol && row<gp.maxWorldRow){
            eventRect[map][col][row] = new EventRect();
            eventRect[map][col][row].x = 23; //middle of the tile
            eventRect[map][col][row].y = 23;
            eventRect[map][col][row].height = 8;
            eventRect[map][col][row].width = 8;
            eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
            col++;
            if(col == gp.maxWorldCol){
                col = 0;
                row++;

                if(row == gp.maxWorldRow){
                    row = 0;
                    map++;
                }
            } //event ul sa se intample doar daca player ul atinge centrul tile ului
        }

    }
    public void checkEvent() {
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if (distance > gp.tileSize) {
            canTouchEvent = true;
        }
        if (canTouchEvent == true) {
            if (hit(0, 27, 24, "any") == true) { //trecerea de la nivelul 1 la nivelul 2
                if (gp.npc[gp.currentMap][0].portalSpawnIndex == 1) {
                    gp.stopMusic();
                    gp.playMusic(3);
                    teleport(1, 27, 24);
                    gp.player.life = gp.player.maxLife;
                    gp.npc[gp.currentMap][0].dialogueIndex = 9;
                    deleteAllData("data", "Data_Table"); //stergem instantele din baza de date
                    resetAutoIncrement("data", "Data_Table");
                    gp.loadLevel = 1;
                    gp.npc[gp.currentMap][1].setValuesLoadNPCArcheologist();
                }
            }
            if (hit(1, 27, 24, "any") == true) { //trecerea de la nivelul 2 la nivelul 3
                if (gp.npc[gp.currentMap][0].portalSpawnIndex == 1) {
                    gp.stopMusic();
                    gp.playMusic(9);
                    teleport(2, 23, 24);
                    gp.player.life = gp.player.maxLife;
                    gp.npc[gp.currentMap][0].dialogueIndex = 13;
                    deleteAllData("data", "Data_Table");
                    resetAutoIncrement("data", "Data_Table");
                    gp.loadLevel = 2;
                    gp.npc[gp.currentMap][2].setValuesLoadNPCArabMan();
                }
            }
        }
    }

    //functia hit verifica daca player ul se afla pe tile ul respectiv
    public boolean hit(int map, int col, int row, String reqDirection){
        boolean hit=false;
        if(map == gp.currentMap) {

            gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
//            System.out.println(" player x: " + gp.player.solidArea.x);
            gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
//            System.out.println("player y: " + gp.player.solidArea.y);
            eventRect[map][col][row].x = col * gp.tileSize + eventRect[map][col][row].x;
//            System.out.println("eventrect x: " + eventRect[map][col][row].x);
            eventRect[map][col][row].y = row * gp.tileSize + eventRect[map][col][row].y;
//            System.out.println("eventrect y: " + eventRect[map][col][row].y);

            if (gp.player.solidArea.intersects(eventRect[map][col][row])) {
                if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                    hit = true;
                    previousEventX = gp.player.worldX;
                    previousEventY = gp.player.worldY;
                }
            }
            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;

        }
        return hit;
    }
    public void teleport(int map, int col, int row){ //realizeaza trecerea intre niveluri
        gp.currentMap = map;
        gp.player.worldX = gp.tileSize * col;
        gp.player.worldY = gp.tileSize * row;
        previousEventX = gp.player.worldX;
        previousEventY = gp.player.worldY;
        canTouchEvent = false;
    }

//    public void damagePit(int gameState){
//        gp.gameState = gameState;
//        gp.player.life = gp.player.life - 1;
//        canTouchEvent = false;
//    }
//    public void healingPool(int gameState){
//        if(gp.keyH.EPressed == true){
//            gp.gameState = gameState;
//            gp.player.life = gp.player.maxLife;
//        }
//    }
}

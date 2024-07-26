package main;

import entity.NPCArabMan;
import entity.NPCArcheologist;
import entity.NPCHelena;
//import factory.ObjectFactory;
import monster.MON_Camel;
import monster.MON_Goblin;
import monster.MON_Mummy;
import monster.MON_Pumpkin;
import object.*;

import java.io.IOException;

public class AssetSetter { //clasa AssetSetter initializeaza pe harta obiectele, NPC urile, inamicii
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() { //initializam pozitiile obiectelor in functie de harta
        int mapNum = 0;

        gp.obj[mapNum][0] = new OBJ_Bone();
        gp.obj[mapNum][0].worldX = 20 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][0].worldY = 23 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][1] = new OBJ_Bone();
        gp.obj[mapNum][1].worldX = 20 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][1].worldY = 12 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][2] = new OBJ_Bone();
        gp.obj[mapNum][2].worldX = 30 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][2].worldY = 16 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][3] = new OBJ_Bone();
        gp.obj[mapNum][3].worldX = 46 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][3].worldY = 14 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][4] = new OBJ_Bone();
        gp.obj[mapNum][4].worldX = 41 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][4].worldY = 22 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][5] = new OBJ_Bone();
        gp.obj[mapNum][5].worldX = 41 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][5].worldY = 22 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][6] = new OBJ_Bone();
        gp.obj[mapNum][6].worldX = 43 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][6].worldY = 33 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][7] = new OBJ_Bone();
        gp.obj[mapNum][7].worldX = 23 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][7].worldY = 32 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][8] = new OBJ_Bone();
        gp.obj[mapNum][8].worldX = 18 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][8].worldY = 34 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][9] = new OBJ_Bone();
        gp.obj[mapNum][9].worldX = 39 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][9].worldY = 44 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][10] = new OBJ_Bone();
        gp.obj[mapNum][10].worldX = 32 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][10].worldY = 35 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][11] = new OBJ_Bone();
        gp.obj[mapNum][11].worldX = 38 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][11].worldY = 14 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][12] = new OBJ_Bone();
        gp.obj[mapNum][12].worldX = 15 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][12].worldY = 29 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][13] = new OBJ_Bone();
        gp.obj[mapNum][13].worldX = 13 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][13].worldY = 12 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][14] = new OBJ_Bone();
        gp.obj[mapNum][14].worldX = 27 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][14].worldY = 33 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][15] = new OBJ_Bone();
        gp.obj[mapNum][15].worldX = 29 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][15].worldY = 40 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][16] = new OBJ_Bone();
        gp.obj[mapNum][16].worldX = 48 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][16].worldY = 28 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][17] = new OBJ_Bone();
        gp.obj[mapNum][17].worldX = 41 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][17].worldY = 13 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][18] = new OBJ_Bone();
        gp.obj[mapNum][18].worldX = 38 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][18].worldY = 14 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][19] = new OBJ_Bone();
        gp.obj[mapNum][19].worldX = 45 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][19].worldY = 43 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][61] = new OBJ_Bone();
        gp.obj[mapNum][61].worldX = 42 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][61].worldY = 40 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][62] = new OBJ_Bone();
        gp.obj[mapNum][62].worldX = 30 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][62].worldY = 30 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][63] = new OBJ_Bone();
        gp.obj[mapNum][63].worldX = 34 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][63].worldY = 24 * gp.tileSize - gp.tileSize;

        mapNum = 1;

        gp.obj[mapNum][20] = new OBJ_MrCoconut();
        gp.obj[mapNum][20].worldX = 37 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][20].worldY = 43 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][21] = new OBJ_MrCoconut();
        gp.obj[mapNum][21].worldX = 36 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][21].worldY = 24 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][22] = new OBJ_MrCoconut();
        gp.obj[mapNum][22].worldX = 31 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][22].worldY = 19 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][23] = new OBJ_MrCoconut();
        gp.obj[mapNum][23].worldX = 44 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][23].worldY = 13 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][24] = new OBJ_MrCoconut();
        gp.obj[mapNum][24].worldX = 36 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][24].worldY = 41 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][25] = new OBJ_MrCoconut();
        gp.obj[mapNum][25].worldX = 26 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][25].worldY = 17 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][26] = new OBJ_MrCoconut();
        gp.obj[mapNum][26].worldX = 27 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][26].worldY = 40 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][27] = new OBJ_MrCoconut();
        gp.obj[mapNum][27].worldX = 30 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][27].worldY = 46 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][28] = new OBJ_MrCoconut();
        gp.obj[mapNum][28].worldX = 21 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][28].worldY = 20 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][29] = new OBJ_MrCoconut();
        gp.obj[mapNum][29].worldX = 40 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][29].worldY = 33 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][30] = new OBJ_MrCoconut();
        gp.obj[mapNum][30].worldX = 20 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][30].worldY = 40 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][31] = new OBJ_MrCoconut();
        gp.obj[mapNum][31].worldX = 21 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][31].worldY = 45 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][32] = new OBJ_MrCoconut();
        gp.obj[mapNum][32].worldX = 45 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][32].worldY = 45 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][33] = new OBJ_MrCoconut();
        gp.obj[mapNum][33].worldX = 40 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][33].worldY = 25 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][34] = new OBJ_MrCoconut();
        gp.obj[mapNum][34].worldX = 39 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][34].worldY = 17 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][35] = new OBJ_MrCoconut();
        gp.obj[mapNum][35].worldX = 35 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][35].worldY = 23 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][36] = new OBJ_MrCoconut();
        gp.obj[mapNum][36].worldX = 18 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][36].worldY = 40 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][37] = new OBJ_MrCoconut();
        gp.obj[mapNum][37].worldX = 19 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][37].worldY = 19 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][38] = new OBJ_MrCoconut();
        gp.obj[mapNum][38].worldX = 22 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][38].worldY = 33 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][39] = new OBJ_MrCoconut();
        gp.obj[mapNum][39].worldX = 13 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][39].worldY = 24 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][64] = new OBJ_MrCoconut();
        gp.obj[mapNum][64].worldX = 13 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][64].worldY = 29 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][65] = new OBJ_MrCoconut();
        gp.obj[mapNum][65].worldX = 30 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][65].worldY = 24 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][66] = new OBJ_MrCoconut();
        gp.obj[mapNum][66].worldX = 24 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][66].worldY = 40 * gp.tileSize - gp.tileSize;

        gp.obj[mapNum][40] = new OBJ_Key();
        gp.obj[mapNum][40].worldX = 15 * gp.tileSize - gp.tileSize;
        gp.obj[mapNum][40].worldY = 37 * gp.tileSize - gp.tileSize;

        mapNum = 2;
            gp.obj[mapNum][41] = new OBJ_Scarab();
            gp.obj[mapNum][41].worldX = 30 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][41].worldY = 33 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][42] = new OBJ_Scarab();
            gp.obj[mapNum][42].worldX = 24 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][42].worldY = 20 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][43] = new OBJ_Scarab();
            gp.obj[mapNum][43].worldX = 14 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][43].worldY = 37 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][44] = new OBJ_Scarab();
            gp.obj[mapNum][44].worldX = 19 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][44].worldY = 28 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][45] = new OBJ_Scarab();
            gp.obj[mapNum][45].worldX = 16 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][45].worldY = 47 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][46] = new OBJ_Scarab();
            gp.obj[mapNum][46].worldX = 36 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][46].worldY = 23 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][47] = new OBJ_Scarab();
            gp.obj[mapNum][47].worldX = 47 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][47].worldY = 20 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][48] = new OBJ_Scarab();
            gp.obj[mapNum][48].worldX = 34 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][48].worldY = 31 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][49] = new OBJ_Scarab();
            gp.obj[mapNum][49].worldX = 32 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][49].worldY = 18 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][50] = new OBJ_Scarab();
            gp.obj[mapNum][50].worldX = 45 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][50].worldY = 45 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][51] = new OBJ_Scarab();
            gp.obj[mapNum][51].worldX = 45 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][51].worldY = 37 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][52] = new OBJ_Scarab();
            gp.obj[mapNum][52].worldX = 24 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][52].worldY = 44 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][53] = new OBJ_Scarab();
            gp.obj[mapNum][53].worldX = 33 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][53].worldY = 44 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][54] = new OBJ_Scarab();
            gp.obj[mapNum][54].worldX = 14 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][54].worldY = 19 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][55] = new OBJ_Scarab();
            gp.obj[mapNum][55].worldX = 30 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][55].worldY = 14 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][56] = new OBJ_Scarab();
            gp.obj[mapNum][56].worldX = 36 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][56].worldY = 38 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][57] = new OBJ_Scarab();
            gp.obj[mapNum][57].worldX = 40 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][57].worldY = 38 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][58] = new OBJ_Scarab();
            gp.obj[mapNum][58].worldX = 43 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][58].worldY = 22 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][59] = new OBJ_Scarab();
            gp.obj[mapNum][59].worldX = 22 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][59].worldY = 32 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][60] = new OBJ_Scarab();
            gp.obj[mapNum][60].worldX = 39 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][60].worldY = 24 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][67] = new OBJ_Scarab();
            gp.obj[mapNum][67].worldX = 30 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][67].worldY = 20 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][68] = new OBJ_Scarab();
            gp.obj[mapNum][68].worldX = 18 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][68].worldY = 38 * gp.tileSize - gp.tileSize;

            gp.obj[mapNum][69] = new OBJ_Scarab();
            gp.obj[mapNum][69].worldX = 41 * gp.tileSize - gp.tileSize;
            gp.obj[mapNum][69].worldY = 26 * gp.tileSize - gp.tileSize;
    }

//    public void setObject() {
//        int mapNum = 0;
//        setObjectsForMap(mapNum, new String[]{
//                "Bone", "Bone", "Bone", "Bone", "Bone", "Bone", "Bone", "Bone", "Bone", "Bone",
//                "Bone", "Bone", "Bone", "Bone", "Bone", "Bone", "Bone", "Bone", "Bone", "Bone", "Bone", "Bone", "Bone"
//        }, new int[][]{
//                {20, 23}, {20, 12}, {30, 16}, {46, 14}, {41, 22}, {41, 22}, {43, 33}, {23, 32}, {18, 34}, {39, 44},
//                {32, 35}, {38, 14}, {15, 29}, {13, 12}, {27, 33}, {29, 40}, {48, 28}, {41, 13}, {38, 14}, {45, 43}, {30, 30}, {34, 24}, {30, 25}
//        });
//
//        mapNum = 1;
//        setObjectsForMap(mapNum, new String[]{
//                "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut",
//                "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut",
//                "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut", "MrCoconut", "Key"
//        }, new int[][]{
//                {37, 43}, {36, 24}, {31, 19}, {44, 13}, {36, 41}, {26, 17}, {27, 40}, {30, 46}, {21, 20}, {40, 33},
//                {20, 40}, {21, 45}, {45, 45}, {40, 25}, {39, 17}, {35, 23}, {18, 40}, {19, 19}, {22, 33}, {13, 24},
//                {13, 29}, {30, 24}, {24, 40}, {15, 37}
//        });
//
//        mapNum = 2;
//        setObjectsForMap(mapNum, new String[]{
//                "Scarab", "Scarab", "Scarab", "Scarab", "Scarab", "Scarab", "Scarab", "Scarab", "Scarab", "Scarab",
//                "Scarab", "Scarab", "Scarab", "Scarab", "Scarab", "Scarab", "Scarab", "Scarab", "Scarab", "Scarab", "Scarab", "Scarab", "Scarab"
//        }, new int[][]{
//                {30, 33}, {24, 20}, {14, 37}, {19, 28}, {16, 47}, {36, 23}, {47, 20}, {34, 31}, {32, 18}, {45, 45},
//                {45, 37}, {24, 44}, {33, 44}, {14, 19}, {30, 14}, {36, 38}, {40, 38}, {43, 22}, {22, 32}, {39, 24}, {30, 20}, {18, 38}, {41, 26}
//        });
//    }
//
//    private void setObjectsForMap(int mapNum, String[] objectTypes, int[][] positions) {
//        gp.obj[mapNum] = new SuperObject[objectTypes.length];
//        for (int i = 0; i < objectTypes.length; i++) {
//            gp.obj[mapNum][i] = ObjectFactory.createObject(objectTypes[i]);
//            gp.obj[mapNum][i].worldX = positions[i][0] * gp.tileSize - gp.tileSize;
//            gp.obj[mapNum][i].worldY = positions[i][1] * gp.tileSize - gp.tileSize;
//        }
//    }

    public void setNPC() throws IOException {
        int mapNum = 0;
        gp.npc[mapNum][0] = new NPCHelena(gp);
        gp.npc[mapNum][0].worldX = gp.tileSize*29;
        gp.npc[mapNum][0].worldY = gp.tileSize*24;

        mapNum = 1;
        gp.npc[mapNum][0] = new NPCHelena(gp);
        gp.npc[mapNum][0].worldX = gp.tileSize*28;
        gp.npc[mapNum][0].worldY = gp.tileSize*24;

        gp.npc[mapNum][1] = new NPCArcheologist(gp);
        gp.npc[mapNum][1].worldX = gp.tileSize*16;
        gp.npc[mapNum][1].worldY = gp.tileSize*15;

        mapNum = 2;
        gp.npc[mapNum][0] = new NPCHelena(gp);
        gp.npc[mapNum][0].worldX = gp.tileSize*24;
        gp.npc[mapNum][0].worldY = gp.tileSize*25;

        gp.npc[mapNum][2] = new NPCArabMan(gp);
        gp.npc[mapNum][2].worldX = gp.tileSize*17;
        gp.npc[mapNum][2].worldY = gp.tileSize*16;
    }

    public void spawnPizzaObject(){
        int mapNum = 1;
        gp.obj[mapNum][42] = new OBJ_Pizza();
        gp.obj[mapNum][42].worldX = 18 * gp.tileSize;
        gp.obj[mapNum][42].worldY = 15 * gp.tileSize;
    }

    public void spawnCoffeeObject(){
        int mapNum = 2;
        gp.obj[mapNum][42] = new OBJ_Coffee();
        gp.obj[mapNum][42].worldX = 19 * gp.tileSize;
        gp.obj[mapNum][42].worldY = 16 * gp.tileSize;
    }

    public void spawnPortalObject() {
        int mapNum = 0;
        gp.obj[mapNum][20] = new OBJ_Portal1();
        gp.obj[mapNum][20].worldX = 27 * gp.tileSize;
        gp.obj[mapNum][20].worldY = 24 * gp.tileSize;

        mapNum = 1;
        gp.obj[mapNum][21] = new OBJ_Portal1();
        gp.obj[mapNum][21].worldX = 27 * gp.tileSize;
        gp.obj[mapNum][21].worldY = 24 * gp.tileSize;
    }

    public void spawnPotionObject(){
        int mapNum = 2;
        gp.obj[mapNum][21] = new OBJ_Potion();
        gp.obj[mapNum][21].worldX = 23 * gp.tileSize;
        gp.obj[mapNum][21].worldY = 25 * gp.tileSize;
    }

    public void setMonster() throws IOException {
        int mapNum = 0;
        gp.monster[mapNum][0] = new MON_Pumpkin(gp);
        gp.monster[mapNum][0].worldX = gp.tileSize*45;
        gp.monster[mapNum][0].worldY = gp.tileSize*24;

        gp.monster[mapNum][1] = new MON_Pumpkin(gp);
        gp.monster[mapNum][1].worldX = gp.tileSize*41;
        gp.monster[mapNum][1].worldY = gp.tileSize*36;

        gp.monster[mapNum][2] = new MON_Pumpkin(gp);
        gp.monster[mapNum][2].worldX = gp.tileSize*20;
        gp.monster[mapNum][2].worldY = gp.tileSize*31;

        gp.monster[mapNum][3] = new MON_Pumpkin(gp);
        gp.monster[mapNum][3].worldX = gp.tileSize*25;
        gp.monster[mapNum][3].worldY = gp.tileSize*44;

        gp.monster[mapNum][4] = new MON_Pumpkin(gp);
        gp.monster[mapNum][4].worldX = gp.tileSize*19;
        gp.monster[mapNum][4].worldY = gp.tileSize*40;

        mapNum = 1;
        gp.monster[mapNum][5] = new MON_Goblin(gp);
        gp.monster[mapNum][5].worldX = gp.tileSize*43;
        gp.monster[mapNum][5].worldY = gp.tileSize*21;

        gp.monster[mapNum][6] = new MON_Goblin(gp);
        gp.monster[mapNum][6].worldX = gp.tileSize*25;
        gp.monster[mapNum][6].worldY = gp.tileSize*34;

        gp.monster[mapNum][7] = new MON_Goblin(gp);
        gp.monster[mapNum][7].worldX = gp.tileSize*36;
        gp.monster[mapNum][7].worldY = gp.tileSize*20;

        gp.monster[mapNum][8] = new MON_Goblin(gp);
        gp.monster[mapNum][8].worldX = gp.tileSize*30;
        gp.monster[mapNum][8].worldY = gp.tileSize*46;

        gp.monster[mapNum][9] = new MON_Goblin(gp);
        gp.monster[mapNum][9].worldX = gp.tileSize*20;
        gp.monster[mapNum][9].worldY = gp.tileSize*42;

        gp.monster[mapNum][10] = new MON_Goblin(gp);
        gp.monster[mapNum][10].worldX = gp.tileSize*20;
        gp.monster[mapNum][10].worldY = gp.tileSize*23;

        mapNum = 2;
        gp.monster[mapNum][11] = new MON_Mummy(gp);
        gp.monster[mapNum][11].worldX = gp.tileSize*40;
        gp.monster[mapNum][11].worldY = gp.tileSize*37;

        gp.monster[mapNum][12] = new MON_Mummy(gp);
        gp.monster[mapNum][12].worldX = gp.tileSize*30;
        gp.monster[mapNum][12].worldY = gp.tileSize*30;

        gp.monster[mapNum][13]= new MON_Mummy(gp);
        gp.monster[mapNum][13].worldX = gp.tileSize*35;
        gp.monster[mapNum][13].worldY = gp.tileSize*20;

        ///
        gp.monster[mapNum][14] = new MON_Camel(gp);
        gp.monster[mapNum][14].worldX = gp.tileSize*40;
        gp.monster[mapNum][14].worldY = gp.tileSize*40;

        gp.monster[mapNum][15] = new MON_Camel(gp);
        gp.monster[mapNum][15].worldX = gp.tileSize*35;
        gp.monster[mapNum][15].worldY = gp.tileSize*18;

        gp.monster[mapNum][16] = new MON_Camel(gp);
        gp.monster[mapNum][16].worldX = gp.tileSize*41;
        gp.monster[mapNum][16].worldY = gp.tileSize*20;
        ///

        gp.monster[mapNum][17] = new MON_Mummy(gp);
        gp.monster[mapNum][17].worldX = gp.tileSize*15;
        gp.monster[mapNum][17].worldY = gp.tileSize*20;

        gp.monster[mapNum][18] = new MON_Mummy(gp);
        gp.monster[mapNum][18].worldX = gp.tileSize*14;
        gp.monster[mapNum][18].worldY = gp.tileSize*45;

        gp.monster[mapNum][19] = new MON_Mummy(gp);
        gp.monster[mapNum][19].worldX = gp.tileSize*23;
        gp.monster[mapNum][19].worldY = gp.tileSize*32;
    }
}
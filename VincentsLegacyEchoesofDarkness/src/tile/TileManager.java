package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


//clasa TileManager reprezinta o implementare a sablonului de proiectare Factory, prin intermediul ei sunt incarcate tile-urile
public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][][] mapTileNum;

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[200];
        mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/map01.txt", 0);
        loadMap("/maps/map02.txt", 1);
        loadMap("/maps/map03.txt", 2);
    }

    public void getTileImage(){ //incarca tile urile
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/green.jpg"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/greengrass.jpg"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/greenflowers.jpg"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grey.jpg"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/brown.jpg"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.jpg"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/getup.jpg"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/fence1.jpg"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/brown2.jpg"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/brown3.jpg"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/fence2.jpg"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/corner1.jpg"));
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/corner2.jpg"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravestone1.jpg"));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravestone2.jpg"));
            tile[14].collision = true;

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravestone3.jpg"));
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravestone4.jpg"));
            tile[16].collision = true;

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravestone5.jpg"));
            tile[17].collision = true;

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravestone6.jpg"));
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravestone7.jpg"));
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravestone8.jpg"));
            tile[20].collision = true;

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bench1.jpg"));
            tile[21].collision = true;

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bench2.jpg"));
            tile[22].collision = true;

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/statue1.jpg"));
            tile[23].collision = true;

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/statue2.jpg"));
            tile[24].collision = true;

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bench3.jpg"));
            tile[25].collision = true;

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bench4.jpg"));
            tile[26].collision = true;

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower1.jpg"));

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower2.jpg"));

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower3.jpg"));

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower4.jpg"));

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree1.jpg"));
            tile[31].collision = true;

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree2.jpg"));
            tile[32].collision = true;

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree3.jpg"));
            tile[33].collision = true;

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree4.jpg"));
            tile[34].collision = true;

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree5.jpg"));
            tile[35].collision = true;

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree6.jpg"));
            tile[36].collision = true;

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree7.jpg"));

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree8.jpg"));
            tile[38].collision = true;

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree9.jpg"));

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravestone9.jpg"));
            tile[40].collision = true;

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/tiles/gravestone10.jpg"));
            tile[41].collision = true;

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house1.jpg"));
            tile[42].collision = true;

            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house2.jpg"));
            tile[43].collision = true;

            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house3.jpg"));
            tile[44].collision = true;

            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house4.jpg"));
            tile[45].collision = true;

            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house5.jpg"));
            tile[46].collision = true;

            tile[47] = new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house6.jpg"));
            tile[47].collision = true;

            tile[48] = new Tile();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house7.jpg"));
            tile[48].collision = true;

            tile[49] = new Tile();
            tile[49].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house8.jpg"));
            tile[49].collision = true;

            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house9.jpg"));
            tile[50].collision = true;

            tile[51] = new Tile();
            tile[51].image = ImageIO.read(getClass().getResourceAsStream("/tiles/statue3.jpg"));
            tile[51].collision = true;

            tile[52] = new Tile();
            tile[52].image = ImageIO.read(getClass().getResourceAsStream("/tiles/statue4.jpg"));
            tile[52].collision = true;

            tile[53] = new Tile();
            tile[53].image = ImageIO.read(getClass().getResourceAsStream("/tiles/statue5.jpg"));
            tile[53].collision = true;

            tile[54] = new Tile();
            tile[54].image = ImageIO.read(getClass().getResourceAsStream("/tiles/statue6.jpg"));
            tile[54].collision = true;

            //////LVL2

            tile[55] = new Tile();
            tile[55].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/grasslvl2.png"));
            tile[55].collision = false;

            tile[56] = new Tile();
            tile[56].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/path.jpg"));
            tile[56].collision = false;

            tile[57] = new Tile();
            tile[57].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/ground.png"));
            tile[57].collision = true;

            tile[58] = new Tile();
            tile[58].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/stairsground.png"));
            tile[58].collision = false;

            tile[59] = new Tile();
            tile[59].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/waterstairs.png"));
            tile[59].collision = false;

            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/grasstuft.jpg"));
            tile[60].collision = true;

            tile[61] = new Tile();
            tile[61].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/plant.jpg"));
            tile[61].collision = true;

            tile[62] = new Tile();
            tile[62].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/bush1.png"));
            tile[62].collision = true;

            tile[63] = new Tile();
            tile[63].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/bush2.png"));
            tile[63].collision = true;

            tile[64] = new Tile();
            tile[64].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/bush3.png"));
            tile[64].collision = true;

            tile[65] = new Tile();
            tile[65].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/bush4.jpg"));
            tile[65].collision = true;

            tile[66] = new Tile();
            tile[66].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/temple1.png"));
            tile[66].collision = true;

            tile[67] = new Tile();
            tile[67].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/temple2.png"));
            tile[67].collision = true;

            tile[68] = new Tile();
            tile[68].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/temple3.png"));
            tile[68].collision = true;

            tile[69] = new Tile();
            tile[69].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/temple4.png"));
            tile[69].collision = true;

            tile[70] = new Tile();
            tile[70].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/house1.png"));
            tile[70].collision = true;

            tile[71] = new Tile();
            tile[71].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/house2.png"));
            tile[71].collision = true;

            tile[72] = new Tile();
            tile[72].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/house3.png"));
            tile[72].collision = true;

            tile[73] = new Tile();
            tile[73].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/house4.png"));
            tile[73].collision = true;

            tile[74] = new Tile();
            tile[74].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/house5.png"));
            tile[74].collision = true;

            tile[75] = new Tile();
            tile[75].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/house6.png"));
            tile[75].collision = true;

            tile[76] = new Tile();
            tile[76].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/statue1.jpg"));
            tile[76].collision = true;

            tile[77] = new Tile();
            tile[77].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/statue2.jpg"));
            tile[77].collision = true;

            tile[78] = new Tile();
            tile[78].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/statue3.jpg"));
            tile[78].collision = true;

            tile[79] = new Tile();
            tile[79].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/statue4.jpg"));
            tile[79].collision = true;

            tile[80] = new Tile();
            tile[80].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/statueface1.jpg"));
            tile[80].collision = true;

            tile[81] = new Tile();
            tile[81].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/statueface2.jpg"));
            tile[81].collision = true;

            tile[82] = new Tile();
            tile[82].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/tree1.jpg"));
            tile[82].collision = true;

            tile[83] = new Tile();
            tile[83].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/tree2.jpg"));
            tile[83].collision = true;

            tile[84] = new Tile();
            tile[84].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/tree3.jpg"));
            tile[84].collision = true;

            tile[85] = new Tile();
            tile[85].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/tree4.jpg"));
            tile[85].collision = true;

            tile[86] = new Tile();
            tile[86].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/tree5.jpg"));
            tile[86].collision = true;

            tile[87] = new Tile();
            tile[87].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/tree6.jpg"));
            tile[87].collision = true;

            tile[88] = new Tile();
            tile[88].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/tree7.jpg"));
            tile[88].collision = false;

            tile[89] = new Tile();
            tile[89].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/tree8.jpg"));
            tile[89].collision = true;

            tile[90] = new Tile();
            tile[90].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/tree9.jpg"));
            tile[90].collision = false;

            tile[91] = new Tile();
            tile[91].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/water.jpg"));
            tile[91].collision = true;

            tile[92] = new Tile();
            tile[92].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/carnivor.jpg"));
            tile[92].collision = true;

            tile[93] = new Tile();
            tile[93].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/statueface3.jpg"));
            tile[93].collision = true;

            tile[94] = new Tile();
            tile[94].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/statueface4.jpg"));
            tile[94].collision = true;

            tile[95] = new Tile();
            tile[95].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/temple5.png"));
            tile[95].collision = true;

            tile[96] = new Tile();
            tile[96].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/temple6.png"));
            tile[96].collision = true;

            tile[97] = new Tile();
            tile[97].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/temple7.png"));
            tile[97].collision = true;

            tile[98] = new Tile();
            tile[98].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/temple8.png"));
            tile[98].collision = true;

            tile[99] = new Tile();
            tile[99].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl2/temple9.png"));
            tile[99].collision = true;


            // LEVEL 3

            tile[100] = new Tile();
            tile[100].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/sand.jpg"));
            tile[100].collision = false;

            tile[101] = new Tile();
            tile[101].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/platform.jpg"));
            tile[101].collision = false;

            tile[102] = new Tile();
            tile[102].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/platformstairs.jpg"));
            tile[102].collision = false;

            tile[103] = new Tile();
            tile[103].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/ground.jpg"));
            tile[103].collision = true;

            tile[104] = new Tile();
            tile[104].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/stairs.jpg"));
            tile[104].collision = false;

            tile[105] = new Tile();
            tile[105].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/cactus.jpg"));
            tile[105].collision = true;

            tile[106] = new Tile();
            tile[106].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/cactus1.jpg"));
            tile[106].collision = true;

            tile[107] = new Tile();
            tile[107].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/cactus2.jpg"));
            tile[107].collision = true;

            tile[108] = new Tile();
            tile[108].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/cactus3.jpg"));
            tile[108].collision = true;

            tile[109] = new Tile();
            tile[109].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/cactus4.jpg"));
            tile[109].collision = true;

            tile[110] = new Tile();
            tile[110].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/tree1.png"));
            tile[110].collision = true;

            tile[111] = new Tile();
            tile[111].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/tree2.png"));
            tile[111].collision = true;

            tile[112] = new Tile();
            tile[112].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/tree3.png"));
            tile[112].collision = true;

            tile[113] = new Tile();
            tile[113].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/tree4.png"));
            tile[113].collision = true;

            tile[114] = new Tile();
            tile[114].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/tree5.jpg"));
            tile[114].collision = true;

            tile[115] = new Tile();
            tile[115].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/tree6.jpg"));
            tile[115].collision = true;

            tile[116] = new Tile();
            tile[116].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/fenceup.png"));
            tile[116].collision = true;

            tile[117] = new Tile();
            tile[117].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/fencelateral.png"));
            tile[117].collision = true;

            tile[118] = new Tile();
            tile[118].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/gate1.jpg"));
            tile[118].collision = true;

            tile[119] = new Tile();
            tile[119].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/gate2.jpg"));
            tile[119].collision = true;

            tile[120] = new Tile();
            tile[120].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/skull.jpg"));
            tile[120].collision = true;

            tile[121] = new Tile();
            tile[121].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/directionleft.jpg"));
            tile[121].collision = true;

            tile[122] = new Tile();
            tile[122].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/directionright.jpg"));
            tile[122].collision = true;

            tile[123] = new Tile();
            tile[123].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/wagon1.jpg"));
            tile[123].collision = true;

            tile[124] = new Tile();
            tile[124].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/wagon2.jpg"));
            tile[124].collision = true;

            tile[125] = new Tile();
            tile[125].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/lake1.jpg"));
            tile[125].collision = true;

            tile[126] = new Tile();
            tile[126].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/lake2.jpg"));
            tile[126].collision = true;

            tile[127] = new Tile();
            tile[127].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/lake3.jpg"));
            tile[127].collision = true;

            tile[128] = new Tile();
            tile[128].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/lake4.jpg"));
            tile[128].collision = true;

            tile[129] = new Tile();
            tile[129].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/lake5.jpg"));
            tile[129].collision = true;

            tile[130] = new Tile();
            tile[130].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/lake6.jpg"));
            tile[130].collision = true;

            tile[131] = new Tile();
            tile[131].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/lake7.jpg"));
            tile[131].collision = true;

            tile[132] = new Tile();
            tile[132].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/lake8.jpg"));
            tile[132].collision = true;

            tile[133] = new Tile();
            tile[133].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/tent1.jpg"));
            tile[133].collision = true;

            tile[134] = new Tile();
            tile[134].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/tent2.jpg"));
            tile[134].collision = true;

            tile[135] = new Tile();
            tile[135].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/tent3.jpg"));
            tile[135].collision = true;

            tile[136] = new Tile();
            tile[136].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/tent4.jpg"));
            tile[136].collision = true;

            tile[137] = new Tile();
            tile[137].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/house1.png"));
            tile[137].collision = true;

            tile[138] = new Tile();
            tile[138].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/house2.png"));
            tile[138].collision = true;

            tile[139] = new Tile();
            tile[139].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/house3.png"));
            tile[139].collision = true;

            tile[140] = new Tile();
            tile[140].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/house4.png"));
            tile[140].collision = true;

            tile[141] = new Tile();
            tile[141].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/house5.png"));
            tile[141].collision = true;

            tile[142] = new Tile();
            tile[142].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/house6.png"));
            tile[142].collision = true;

            tile[143] = new Tile();
            tile[143].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/house7.png"));
            tile[143].collision = true;

            tile[144] = new Tile();
            tile[144].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/house8.png"));
            tile[144].collision = true;

            tile[145] = new Tile();
            tile[145].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/house9.png"));
            tile[145].collision = true;

            tile[146] = new Tile();
            tile[146].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/pyramid1.jpg"));
            tile[146].collision = true;

            tile[147] = new Tile();
            tile[147].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/pyramid2.jpg"));
            tile[147].collision = true;

            tile[148] = new Tile();
            tile[148].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/pyramid3.jpg"));
            tile[148].collision = true;

            tile[149] = new Tile();
            tile[149].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/pyramid4.jpg"));
            tile[149].collision = true;

            tile[150] = new Tile();
            tile[150].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/pyramid5.jpg"));
            tile[150].collision = true;

            tile[151] = new Tile();
            tile[151].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/pyramid6.jpg"));
            tile[151].collision = true;

            tile[152] = new Tile();
            tile[152].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/pyramid7.jpg"));
            tile[152].collision = true;

            tile[153] = new Tile();
            tile[153].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/pyramid8.jpg"));
            tile[153].collision = true;

            tile[154] = new Tile();
            tile[154].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/pyramid9.jpg"));
            tile[154].collision = true;

            tile[155] = new Tile();
            tile[155].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/dunehorizontal1.jpg"));
            tile[155].collision = true;

            tile[156] = new Tile();
            tile[156].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/dunehorizontal2.jpg"));
            tile[156].collision = true;

            tile[157] = new Tile();
            tile[157].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/dunehorizontal3.jpg"));
            tile[157].collision = true;

            tile[158] = new Tile();
            tile[158].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/dunehorizontal4.jpg"));
            tile[158].collision = true;

            tile[159] = new Tile();
            tile[159].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/dunehorizontal5.jpg"));
            tile[159].collision = true;

            tile[160] = new Tile();
            tile[160].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/dunehorizontal6.jpg"));
            tile[160].collision = true;

            tile[161] = new Tile();
            tile[161].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/dunehorizontal7.jpg"));
            tile[161].collision = true;

            tile[162] = new Tile();
            tile[162].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/dunehorizontal8.jpg"));
            tile[162].collision = true;

            tile[163] = new Tile();
            tile[163].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/scorpion.jpg"));
            tile[163].collision = true;

            tile[164] = new Tile();
            tile[164].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/flower.jpg"));
            tile[164].collision = true;

            tile[165] = new Tile();
            tile[165].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/statue1.jpg"));
            tile[165].collision = true;

            tile[166] = new Tile();
            tile[166].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/statue2.jpg"));
            tile[166].collision = true;

            tile[167] = new Tile();
            tile[167].image = ImageIO.read(getClass().getResourceAsStream("/Tileslvl3/path.jpg"));
            tile[167].collision = false;

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath, int map){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(is)));
            int col=0;
            int row=0;
            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();
                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[map][col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){

        }
    }

    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;
        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }

            worldCol++;

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
}

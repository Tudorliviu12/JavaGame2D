package main;

import ai.PathFinder;
import entity.Entity;
import entity.Player;
import object.OBJ_Portal1;
import object.SuperObject;
import tile.TileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 18;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public final int maxWorldCol = 60;
    public final int maxWorldRow = 60;

    public final int maxMap = 3;
    public int currentMap = 0; //harta playable

    public int lifePause, XPause, YPause;

    public final int worldWidth = tileSize*maxWorldCol;
    public final int worldHeight = tileSize*maxWorldRow;

    int FPS = 60;

    public TileManager tileM = new TileManager(this);

    public KeyHandler keyH = new KeyHandler(this);

    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);

    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread;
    public PathFinder pFinder = new PathFinder(this);

    Sound music = new Sound();
    Sound se = new Sound();

    public Player player = new Player(this,keyH);
    public SuperObject obj[][] = new SuperObject[maxMap][70];
    public Entity npc[][] = new Entity[maxMap][20];
    public Entity monster[][] = new Entity[maxMap][35];
    public ArrayList<Entity> spellList = new ArrayList<>();
    public ArrayList<Entity> entityList = new ArrayList<>();

    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int dialogueState = 2;
    public final int storyState = 3;
    public final int gameOverState = 4;
    public final int pauseState = 5;
    public final int storyState2 = 6;

    public int interactNPCIndex;

    public int loadLevel;

    public int currentStoryImage = 1;

    /*
    constructorul clasei GamePanel
    variabila loadLevel ia valoarea 0 la fiecare executie a jocului, si va memora nivelul maxim la care a ajuns player ul
     */
    public GamePanel() throws IOException {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        interactNPCIndex = 0;
        loadLevel = 0;
    }

    public void setupGame() throws IOException { //la rularea jocului
        aSetter.setNPC();
        aSetter.setObject();
        aSetter.setMonster();
        playMusic(2);
        gameState = titleState;
        deleteAllData("data", "Data_Table"); //stergem instantele din baza de date la fiecare rulare a jocului
        resetAutoIncrement("data", "Data_Table");
    }

    //in momentul in care player ul pierde, poate alege sa dea retry la nivel, in functie de nivelul la care se afla player ul
    public void retry() throws IOException {
        if(currentMap == 0) {
            npc[currentMap][0].dialogueIndex = 0;
            stopMusic();
            playMusic(0);
        }
        if(currentMap == 1) {
            npc[currentMap][0].dialogueIndex = 9;
            stopMusic();
            playMusic(3);
        }
        if(currentMap == 2) {
            npc[currentMap][0].dialogueIndex = 13;
            stopMusic();
            playMusic(9);
        }
        player.setDefaultValues();
        aSetter.setMonster();
    }
    public void restart() throws IOException { //daca player ul alege optiunea quit, va fi dus la meniul principal al jocului
        player.setDefaultValues();
        aSetter.setMonster();
        playMusic(2);
    }

    //functia paintComponent, in functie de gamestate ul in care ne aflam, apeleaza functii pentru desenarea instantelor pe ecran
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (gameState == titleState) {
            try {
                ui.draw(g2, this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            if (gameState == storyState) {
                BufferedImage s1, s2, s3, s4, s5, s6;
                try {
                    s1 = ImageIO.read(getClass().getResourceAsStream("/background/Story1.jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    s2 = ImageIO.read(getClass().getResourceAsStream("/background/Story2.jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    s3 = ImageIO.read(getClass().getResourceAsStream("/background/Story3.jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    s4 = ImageIO.read(getClass().getResourceAsStream("/background/Story4.jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    s5 = ImageIO.read(getClass().getResourceAsStream("/background/Story5.jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    s6 = ImageIO.read(getClass().getResourceAsStream("/background/Story6.jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                switch (currentStoryImage) {
                    case 1:
                        g2.drawImage(s1, 0, 0, screenWidth, screenHeight, null);
                        break;
                    case 2:
                        g2.drawImage(s2, 0, 0, screenWidth, screenHeight, null);
                        break;
                    case 3:
                        g2.drawImage(s3, 0, 0, screenWidth, screenHeight, null);
                        break;
                    case 4:
                        g2.drawImage(s4, 0, 0, screenWidth, screenHeight, null);
                        break;
                    case 5:
                        g2.drawImage(s5, 0, 0, screenWidth, screenHeight, null);
                        break;
                    case 6:
                        g2.drawImage(s6, 0, 0, screenWidth, screenHeight, null);
                        break;
                }
            }
            else {
                if (gameState == storyState2) {
                    BufferedImage s1, s2, s3, s4;
                    try {
                        s1 = ImageIO.read(getClass().getResourceAsStream("/background/Story7.jpg"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        s2 = ImageIO.read(getClass().getResourceAsStream("/background/Story8.jpg"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        s3 = ImageIO.read(getClass().getResourceAsStream("/background/Story9.jpg"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        s4 = ImageIO.read(getClass().getResourceAsStream("/background/Story10.jpg"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    switch (currentStoryImage) {
                        case 7:
                            g2.drawImage(s1, 0, 0, screenWidth, screenHeight, null);
                            break;
                        case 8:
                            g2.drawImage(s2, 0, 0, screenWidth, screenHeight, null);
                            break;
                        case 9:
                            g2.drawImage(s3, 0, 0, screenWidth, screenHeight, null);
                            break;
                        case 10:
                            g2.drawImage(s4, 0, 0, screenWidth, screenHeight, null);
                            break;
                    }
                }
            }
            if (gameState == playState || gameState == dialogueState || gameState == pauseState || gameState == gameOverState) {
                tileM.draw(g2);
                for (int i = 0; i < npc[1].length; ++i) {
                    if (npc[currentMap][i] != null) {
                        npc[currentMap][i].draw(g2);
                    }
                }

                for (int i = 0; i < obj[1].length; ++i) {
                    if (obj[currentMap][i] != null) {
                        obj[currentMap][i].draw(g2, this);
                    }
                }

                for (int i = 0; i < monster[1].length; ++i) {
                    if (monster[currentMap][i] != null) {
                        monster[currentMap][i].draw(g2);
                    }
                }
                for (int i = 0; i < spellList.size(); ++i) {
                    if (spellList.get(i) != null) {
                        entityList.add(spellList.get(i));
                    }
                }

//                Collections.sort(entityList, new Comparator<Entity>() {
//                    @Override
//                    public int compare(Entity e1, Entity e2) {
//                        int result = Integer.compare(e1.worldY, e2.worldY);
//                        return result;
//                    }
//                });

                for (int i=0;i<entityList.size();++i){
                    if (entityList.get(i)!=null)
                    {
                        entityList.get(i).draw(g2);
                    }}

                entityList.clear();

                player.draw(g2);

                try {
                    ui.draw(g2, this);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                g2.dispose();
                if(currentMap == 0) {
                    if (player.boneCounter >= 20 && npc[currentMap][0].portalSpawnIndex == 1) {
                        aSetter.spawnPortalObject();
                    }
                    else{
                        obj[currentMap][20] = null;
                    }
                }
                if(currentMap == 1) {
                    if (player.fruitCounter >= 20 && npc[currentMap][0].portalSpawnIndex == 1) {
                        aSetter.spawnPortalObject();
                    }
                    else{
                            obj[currentMap][21] = null;
                        }
                    if (npc[currentMap][1].pizzaSpawnIndex == 1 && npc[currentMap][1].pizzaCounter == 0) {
                        aSetter.spawnPizzaObject();
                    }
                    else{
                        obj[currentMap][42] = null;
                    }
                }
                if(currentMap == 2) {
                    if (player.scarabCounter >= 20 && npc[currentMap][0].potionSpawnIndex == 1) {
                        aSetter.spawnPotionObject();
                    }
                    else{
                        obj[currentMap][21] = null;
                    }
                    if (npc[currentMap][2].coffeeSpawnIndex == 1 && npc[currentMap][2].coffeeCounter == 0) {
                        aSetter.spawnCoffeeObject();
                    }
                    else{
                        obj[currentMap][42] = null;
                    }
                }
            }
        }
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){
    //update information such as character position
            try {
                update();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //draw the screen with the updated information
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime = nextDrawTime + drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void playMusic(int i){ //porneste muzica de fundal, intr un loop infinit pana la apelarea stopmusic
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic(){
        music.stop();
    }

    public void playSE(int i){
        se.setFile(i);
        se.play();
    }

    public void update() throws IOException { //functia de update
        if (gameState == playState) {
            player.update();

            for (int i = 0; i < monster[1].length; i++) {
                if (monster[currentMap][i] != null) {
                    if(monster[currentMap][i].alive == true && monster[currentMap][i].dying == false) {
                        monster[currentMap][i].update();
                    }
                    if(monster[currentMap][i].alive == false){
                        monster[currentMap][i] = null;
                    }
                }
            }
            for (int i = 0; i < spellList.size(); i++) {
                if (spellList.get(i) != null) {
                    if(spellList.get(i).alive == true) {
                        spellList.get(i).update();
                    }
                    if(spellList.get(i).alive == false){
                        spellList.remove(i);
                    }
                }
            }
        }

        //daca jocul se afla in meniul de pauza, afisam pe ecran variabilele extrase din baza de date (life, X, Y)
        if (gameState == pauseState) {
            insertData("data", "Data_Table", player.life, player.worldX, player.worldY);
            int[]val = getData("data", "Data_Table");
            lifePause = val[0];
            XPause = val[1];
            YPause = val[2];
        }
        if(gameState == gameOverState){
            stopMusic();
            deleteAllData("data", "Data_Table");
            resetAutoIncrement("data", "Data_Table");
        }

    }

    //functia pentru inserarea in baza de date
    public static void insertData(String dbPath, String tableName, int life, int x, int y) {

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Home/Desktop/VincentsLegacyEchoesofDarkness/data.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "INSERT INTO " + tableName + " (Life, X, Y) VALUES (" + life + ", " + x + ", " + y + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.out.println("Eroare la insert");
            e.printStackTrace();
            // Optional rollback in case of error
            try {
                if (c != null) {
                    c.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }


    //functie pentru extragerea datelor din baza de date
    public static int[] getData(String dbPath, String tableName) {
        Connection c = null;
        Statement stmt = null;
        int[] values = new int[3]; // [Life, X, Y]
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Home/Desktop/VincentsLegacyEchoesofDarkness/data.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + " ORDER BY ID DESC LIMIT 1;");
            if (rs.next()) {
                values[0] = rs.getInt("Life");
                values[1] = rs.getInt("X");
                values[2] = rs.getInt("Y");
            }

            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Eroare la get");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return values;
    }

    //functia pentru stergerea valorilor din baza de date apelata la finalizarea unui nivel/pornirea jocului/meniul de gameover
    public static void deleteAllData(String dbPath, String tableName) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Home/Desktop/VincentsLegacyEchoesofDarkness/data.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "DELETE FROM " + tableName + ";";
            stmt.executeUpdate(sql);
            c.commit();
        } catch (Exception e) {
            System.out.println("Eroare la ștergere");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    //functia pentru resetarea ID-ului (primary key, autoincrement)
    public static void resetAutoIncrement(String dbPath, String tableName) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Home/Desktop/VincentsLegacyEchoesofDarkness/data.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            // Resetează valoarea auto-increment a coloanei ID
            String sql = "DELETE FROM sqlite_sequence WHERE name='" + tableName + "';";
            stmt.executeUpdate(sql);
            c.commit();
        } catch (Exception e) {
            System.out.println("Eroare la resetarea auto-incrementării");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

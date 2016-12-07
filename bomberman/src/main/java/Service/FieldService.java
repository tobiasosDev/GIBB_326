package Service;

import Model.*;
import Predicates.PlayerPredicates;
import application.network.protocol.Maze;
import javafx.scene.input.KeyCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukas on 16.11.2016.
 */
public class FieldService {

    private static  FieldService fieldService = new FieldService();

    private Maze maze;
    private Gear gear;
    private GameMode gameMode;


    private List<Player> players = new ArrayList<>();
    private String playerName;

    private FieldService() {
        ArrayList<Key> keys = new ArrayList<>();
        keys.add( new Key(KeyCode.W, PlayerFunctions.UP));
        keys.add( new Key(KeyCode.S, PlayerFunctions.DOWN));
        keys.add( new Key(KeyCode.D, PlayerFunctions.RIGHT));
        keys.add( new Key(KeyCode.A, PlayerFunctions.LEFT));
        keys.add( new Key(KeyCode.SHIFT, PlayerFunctions.DROPBOMB));


        this.gear = new Gear(true, keys);

        this.gameMode = new GameMode(60000, 3);
        this.playerName = "Test";
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public Player getPlayer(String playerName) {
        return players.stream().filter(PlayerPredicates.isPlayer(playerName)).findFirst().get();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public static FieldService getInstance(){
        return fieldService;
    }
}

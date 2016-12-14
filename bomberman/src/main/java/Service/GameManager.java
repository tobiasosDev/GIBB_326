package Service;

import Controller.MessageFactory;
import Controller.NameGenerator;
import Model.ServerStartGameMessage;
import application.network.api.Network;
import application.network.api.client.ClientIdInUseException;
import application.network.api.client.LobbyFullException;
import application.network.api.client.ServerProxy;
import application.network.api.server.Server;
import application.network.mock.MockServer;
import application.network.mock.MockServerProxy;
import application.network.protocol.PlayerJoined;
import application.network.protocol.StartGame;

import java.io.IOException;


/**
 * Created by tobiasluscher on 16.11.16.
 */
public class GameManager {

        public void startupServer() throws IOException
        {
            Server server = Network.getServer();
            server.listen(1000);
            server.addMessageHandler((msg, clientId) -> {
                GameManager gameManager = new GameManager();
                System.out.println("Server received message "+msg+" from "+clientId);
                try {
                    gameManager.startupClient();
                } catch (LobbyFullException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClientIdInUseException e) {
                    e.printStackTrace();
                }
            });
            //Your application
            ServerStartGameMessage message = new ServerStartGameMessage();
            message.setCommand("Start");
            MockServer.simulateMessage(message, "ID123");

            server.shutdown();
        }

        public void startupClient() throws LobbyFullException, IOException, ClientIdInUseException
        {
            MockMaceGenerater mockMaceGenerater = new MockMaceGenerater();
            ServerProxy client = Network.getClient();
            MessageFactory messageFactory = new MessageFactory();
            client.connect("test-client", "localhost", 1000);
            client.addMessageHandler(msg -> {
                messageFactory.executeMessageMethod(msg);
            });

            StartGame startGame = new StartGame();
            startGame.setMaze(mockMaceGenerater.createMockMace());

            PlayerJoined playerJoined = new PlayerJoined();
            NameGenerator nameGenerator = new NameGenerator();
            playerJoined.setPlayerName(nameGenerator.getRandomName());
            playerJoined.setPositionX(0);
            playerJoined.setPositionY(0);

            MockServerProxy.simulateMessage(startGame);
            MockServerProxy.simulateMessage(playerJoined);
        }
}

package Service;

import Controller.MessageFactory;
import Controller.NameGenerator;
import Model.ServerStartGameMessage;
import application.network.api.Network;
import application.network.api.client.ClientIdInUseException;
import application.network.api.client.LobbyFullException;
import application.network.api.client.ServerProxy;
import application.network.api.server.Server;
import application.network.protocol.PlayerJoined;
import application.network.protocol.StartGame;

import java.io.IOException;


/**
 * Created by tobiasluscher on 16.11.16.
 */
public class GameManager {

        public void startupClient() throws LobbyFullException, IOException, ClientIdInUseException
        {
            MockMaceGenerater mockMaceGenerater = new MockMaceGenerater();
            ServerProxy client = Network.getClient();
            MessageFactory messageFactory = new MessageFactory();
            client.connect("test-client", "localhost", 10082);
            client.addMessageHandler(msg -> {
                messageFactory.executeMessageMethod(msg);
            });
        }
}

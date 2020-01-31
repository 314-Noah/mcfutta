package de.noah.mcfutta.unused;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;

import de.noah.mcfutta.collections.Repositories;
import de.noah.mcfutta.collections.menus.FoodTypeCollection;
import de.noah.mcfutta.collections.menus.Menu;
import de.noah.mcfutta.collections.menus.food.Food;
import io.socket.engineio.parser.Packet;
import io.socket.engineio.server.EngineIoServer;
import io.socket.engineio.server.EngineIoSocket;
import io.socket.engineio.server.EngineIoWebSocket;
import io.socket.parseqs.ParseQS;

public class Socket extends Endpoint {

	private final EngineIoServer ioServer = new EngineIoServer();
	private EngineIoWebSocket ioWebSocket;

    private Session mSession;
    private Map<String, String> mQuery;

	@Override
	public void onOpen(Session session, EndpointConfig config) {
		
		mSession = session;
		mQuery = ParseQS.decode(session.getQueryString());
		
		ioWebSocket = new EngineIoWebSocketImpl();
		
		ioServer.handleWebSocket(ioWebSocket);
		
		ioServer.on("connection", args -> {
			EngineIoSocket socket = (EngineIoSocket) args[0];
			
			socket.on("create-menu", arguments -> {
				Packet<?> packet = (Packet<?>) arguments[0]; //?
				String msg = (String) packet.data;
				
				String[] block = msg.split("-;-");
				
				Menu menu = new Menu();
				List<FoodTypeCollection> ftcs = new ArrayList<>();
				
				for (int i = 0; i < block.length; i++) {
					String[] part = block[i].split(":-:");
					Food[] feed = new Food[part.length - 1];
					
					for (int j = 1; j < part.length; j++) {
						feed[j-1] = Repositories.food.getByName(part[j]);
					}
					ftcs.add(new FoodTypeCollection(part[0], feed));
				}
				
				menu.setName(block[block.length-1]);
				menu.setCollections((FoodTypeCollection[]) ftcs.toArray()); 
				
				Repositories.menus.save(menu);
				
			});
		});
	}
	
	@Override
    public void onClose(Session session, CloseReason closeReason) {
        super.onClose(session, closeReason);

        ioWebSocket.emit("close");
        mSession = null;
    }
	


	private class EngineIoWebSocketImpl extends EngineIoWebSocket {
		
		private RemoteEndpoint.Basic mBasic;

        EngineIoWebSocketImpl() {
            mBasic = mSession.getBasicRemote();
        }

        @Override
        public Map<String, String> getQuery() {
            return mQuery;
        }

        @Override
        public void write(String message) throws IOException {
            mBasic.sendText(message);
        }

        @Override
        public void write(byte[] message) throws IOException {
            mBasic.sendBinary(ByteBuffer.wrap(message));
        }

        @Override
        public void close() {
            try {
                mSession.close();
            } catch (IOException ignore) {
            }
        }
    }
}

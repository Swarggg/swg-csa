import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class SwgCSA {
    public static void main(String[] args) throws Exception {
        if (args.length>0) {
            int port = Integer.parseInt(args[0]);
            System.out.println("Starting server version...");
            System.out.println("Server open port: "+port);

            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
            PushService pushService = new PushService();
            server.createContext("/", new SwgHandler(pushService)); //обрабатывает запросы от клиентов к серверу

        } else {
            System.out.println("Starting client version...");


        }
    }
}

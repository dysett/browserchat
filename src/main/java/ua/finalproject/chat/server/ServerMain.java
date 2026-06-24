package ua.finalproject.chat.server;

import ua.finalproject.chat.db.ChatDatabase;
import ua.finalproject.chat.http.ChatHttpServer;
import ua.finalproject.chat.http.JwtTokenService;
import ua.finalproject.chat.udp.UdpHeartbeatServer;

/**
 * Точка запуску програми.
 * Створює базу даних, TCP-сервер, HTTP-сервер і UDP heartbeat-сервер.
 */
public final class ServerMain {
    private ServerMain() {
    }

    public static void main(String[] args) throws Exception {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 5050;
        String dbUrl = args.length > 1 ? args[1] : "jdbc:sqlite:chat.db";
        String secret = args.length > 2 ? args[2] : "course-final-chat-secret";
        int httpPort = args.length > 3 ? Integer.parseInt(args[3]) : 8080;
        String jwtSecret = args.length > 4 ? args[4] : "course-final-chat-jwt-secret";
        int udpPort = args.length > 5 ? Integer.parseInt(args[5]) : 5051;

        try (ChatDatabase database = new ChatDatabase(dbUrl);
             ChatServer server = new ChatServer(port, database, secret);
             ChatHttpServer httpServer = new ChatHttpServer(httpPort, database, server, new JwtTokenService(jwtSecret));
             UdpHeartbeatServer udpHeartbeatServer = new UdpHeartbeatServer(udpPort)) {
            server.start();
            httpServer.start();
            udpHeartbeatServer.start();
            System.out.println("Chat server started on TCP port " + server.port());
            System.out.println("UDP heartbeat server started on port " + udpHeartbeatServer.port());
            System.out.println("Browser client is available at http://localhost:" + httpServer.port());
            System.out.println("Press Enter to stop.");
            System.in.read();
        }
    }
}

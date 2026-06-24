# Browser Chat

Browser Chat is the web version of the final online-chat project.

## Included

- browser UI with registration, login, chats, groups, themes and admin controls;
- HTTP REST API protected by JWT Bearer tokens;
- authenticated server-sent events for real-time browser updates;
- SQLite/JDBC persistence;
- commit/rollback transactions for multi-step database operations;
- PBKDF2 password hashing with a unique salt;
- TCP protocol core with AES-GCM, CRC16 and big-endian packets;
- UDP heartbeat with ACK, timeout and retry handling;
- multithreaded server and JUnit tests.

The project intentionally has no Swing or console client. The TCP protocol remains in the server core, while users work through the browser UI.

## Requirements

- JDK 17 or newer;
- internet access during the first run to download Maven and dependencies.

## Run

```powershell
.\run-server.cmd
```

Then open `http://localhost:8080/`.

The server also listens on TCP port `5050` and UDP heartbeat port `5051` by default.

## Test

```powershell
mvn test
```

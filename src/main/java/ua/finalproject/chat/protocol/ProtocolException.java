package ua.finalproject.chat.protocol;

/**
 * Помилка протоколу: неправильний формат, контрольна сума або некоректні дані пакета.
 */
public final class ProtocolException extends RuntimeException {
    public ProtocolException(String message) {
        super(message);
    }

    public ProtocolException(String message, Throwable cause) {
        super(message, cause);
    }
}

package ua.finalproject.chat.db;

/**
 * Модель авторизованого користувача.
 * Record використовується як компактний immutable-об'єкт: після створення поля не змінюються напряму.
 */
public record ChatUser(
        int id,
        String username,
        UserRole role,
        boolean blocked,
        String description,
        boolean hasAvatar,
        String quickReaction
) {
}

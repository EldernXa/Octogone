package fr.hexagone.back;

public enum BookRoomResult {
    OK,
    INVALID_END_DATETIME,
    INVALID_DURATION,
    INVALID_ROOM,
    ROOM_NOT_AVAILABLE,
    PERSISTANCE_ERROR,
    INVALID_MAIL
}

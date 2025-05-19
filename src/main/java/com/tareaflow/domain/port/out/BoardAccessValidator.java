package com.tareaflow.domain.port.out;

import java.util.UUID;

public interface BoardAccessValidator {
    boolean isMember(UUID userId, UUID boardId);
    boolean isOwner(UUID userId, UUID boardId);
}

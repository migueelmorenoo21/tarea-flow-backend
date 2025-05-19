package com.tareaflow.adapters.output.postgres;

import com.tareaflow.adapters.output.postgres.entity.UserEntity;
import com.tareaflow.domain.model.User;
import com.tareaflow.domain.port.out.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    public UserRepositoryAdapter(SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return springDataUserRepository.findByEmail(email)
                .map(this::toDomain);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return springDataUserRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity entity = toEntity(user);
        UserEntity saved = springDataUserRepository.save(entity);
        return toDomain(saved);
    }

    // === Conversión a dominio ===
    private User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPasswordHash(),
                entity.isCompany(),
                entity.getPlan(),
                entity.getCreatedAt()
        );
    }

    // === Conversión a entidad ===
    private UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPasswordHash(user.getPasswordHash());
        entity.setCompany(user.isCompany());
        entity.setPlan(user.getPlan());
        entity.setCreatedAt(user.getCreatedAt());
        return entity;
    }
}

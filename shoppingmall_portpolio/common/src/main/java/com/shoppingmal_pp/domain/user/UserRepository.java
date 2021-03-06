package com.shoppingmal_pp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findById(UUID user);
    Optional<User> findByIdentifier(String identifier);

    boolean existsByIdentifier(String identifier);
}

package com.shoes.store.repository;

import com.shoes.store.repository.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Long> {
    Optional<Roles> findByRoleName(String roleName);
}

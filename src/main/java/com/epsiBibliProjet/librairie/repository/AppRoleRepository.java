package com.epsiBibliProjet.librairie.repository;


import com.epsiBibliProjet.librairie.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}

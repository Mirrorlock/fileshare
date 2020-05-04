package com.fileshare.repositories;

import com.fileshare.auth.model.User;
import com.fileshare.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Integer> {
    Folder findByNameAndOwnerUsername(String name, String username);
}

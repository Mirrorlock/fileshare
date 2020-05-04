package com.fileshare.repositories;

import com.fileshare.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Integer> {
    ArrayList<File> findAllByOwnerUsername(String username);
}

package com.fileshare.controllers;

import com.fileshare.auth.repository.UserRepository;
import com.fileshare.auth.services.SecurityService;
import com.fileshare.models.File;
import com.fileshare.models.Folder;
import com.fileshare.repositories.FileRepository;
import com.fileshare.repositories.FolderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class FileController {

    private final FileRepository fileRepository;
    private final FolderRepository folderRepository;
    private final UserRepository userRepository;
    private final SecurityService securityService;

    public FileController(FileRepository fileRepository, FolderRepository folderRepository, UserRepository userRepository, SecurityService securityService) {
        this.fileRepository = fileRepository;
        this.folderRepository = folderRepository;
        this.userRepository = userRepository;
        this.securityService = securityService;
    }

    @GetMapping({"/", "/home"})
    public String index(Model model) {
        String username = securityService.findLoggedInUsername();
        //        System.out.println(userRepository.findAll());
        Folder rootFolder = folderRepository.findByNameAndOwnerUsername(username, username);
        System.out.println("Found root folder: " + rootFolder);
//        ArrayList<File> userFiles = fileRepository.findAllByOwnerUsername(securityService.findLoggedInUsername());
        model.addAttribute("userFiles", rootFolder.getFiles());
        model.addAttribute("isRoot", true);
        return "home";
    }


//    @GetMapping("/user/{userId}/files")
//    public ResponseEntity<List<File>> getAllFilesForUser(@PathVariable String userId){
//        return userRepository.findById(Long.parseLong(userId)).map(u -> {
//
//        }).orElse(ResponseEntity.notFound());
//    }
}

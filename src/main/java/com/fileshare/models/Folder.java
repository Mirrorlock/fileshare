package com.fileshare.models;

import com.fileshare.auth.model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "folder")
public class Folder {

    public Folder() {
    }

    public Folder(String name, User owner) {
        this.name = name;
        this.owner = owner;
        this.files = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "folder")
    private List<File> files;


    @ManyToOne
    @JoinColumn(name="folder_id")
    private Folder parent;

    @OneToMany(mappedBy = "folder")
    private List<Folder> subfolders;

    @Override
    public String toString() {
        return "Folder{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", files=" + files +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folder folder = (Folder) o;
        return Id == folder.Id &&
                Objects.equals(name, folder.name) &&
                Objects.equals(owner, folder.owner) &&
                Objects.equals(files, folder.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, owner, files);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}

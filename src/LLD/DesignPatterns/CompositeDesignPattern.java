package LLD.DesignPatterns;

import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.List;

interface FileSystem{
    void ls(int indent);
    void open(int indent);
    int getSize();
    String getName();
    boolean isFolder();
    FileSystem cd(String name);
}

class File implements FileSystem{
    private final String name;
    private final int size;

    public File(String name, int size){
        this.name = name;
        this.size = size;
    }

    @Override
    public void ls(int indent){
        String indentSpaces = " ".repeat(indent);
        System.out.println(indentSpaces + name);
    }

    @Override
    public void open(int indent){
        String indentSpaces = " ".repeat(indent);
        System.out.println(indentSpaces + name);
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public boolean isFolder(){
        return false;
    }

    public FileSystem cd(String name){
        return null;
    }

}

class Folder implements FileSystem{
    private List<FileSystem> fileSystems;
    private String name;

    public Folder(String name){
        this.name = name;
        this.fileSystems = new ArrayList<>();
    }

    public void addToList(FileSystem fileSystem){
        this.fileSystems.add(fileSystem);
    }

    @Override
    public void ls(int indent){
        String indentSpaces = " ".repeat(indent);
        for(FileSystem fileSystem : fileSystems){
            if(fileSystem.isFolder()) {
                System.out.println(indentSpaces + "+ " + fileSystem.getName());
            } else {
                System.out.println(indentSpaces + fileSystem.getName());
            }
        }
    }

    @Override
    public void open(int indent){
        String indentSpaces = " ".repeat(indent);
        System.out.println(indentSpaces + "+ " + name);
        for (FileSystem fileSystem : fileSystems) {
            fileSystem.open(indent + 4);
        }
    }

    @Override
    public int getSize(){
        int sz = 0;
        for(FileSystem fileSystem : fileSystems){
            sz+=fileSystem.getSize();
        }
        return sz;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public boolean isFolder(){
        return true;
    }

    public FileSystem cd(String target){
        for(FileSystem fileSystem : fileSystems){
            if(fileSystem.isFolder() && fileSystem.getName().equalsIgnoreCase(target))
                return fileSystem;
        }
        return null;
    }

}

public class CompositeDesignPattern {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        root.addToList(new File("file1.txt", 1));
        root.addToList(new File("file2.txt", 3));
        root.addToList(new File("file3.txt", 4));

        Folder docs = new Folder("docs");
        docs.addToList(new File("resume.pdf", 1));
        docs.addToList(new File("notes.txt", 1));
        root.addToList(docs);

        Folder images = new Folder("images");
        images.addToList(new File("photo.jpg", 1));
        root.addToList(images);

        root.ls(0);
        System.out.println("---------------------------");

        docs.ls(0);
        System.out.println("---------------------------");

        root.open(0);
        System.out.println("---------------------------");

        FileSystem cwd = root.cd("docs");
        if (cwd != null) {
            cwd.ls(0);
        } else {
            System.out.println("\nCould not cd into docs\n");
        }

        System.out.println("Size of root : "+root.getSize());
        System.out.println("Size of docs : "+docs.getSize());

    }
}


package LLD.LLDQuestions.DocumentEditor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Document element
interface DocumentElement{
    String render();
}

class TextElement implements DocumentElement{
    private final String text;
    public TextElement(String text){
        this.text = text;
    }
    public String render(){
        return text;
    }
}

class ImageElement implements DocumentElement{
    private String imagePath;
    public ImageElement(String imagePath){
        this.imagePath = imagePath;
    }
    public String render(){
        return "Image Path = [" + imagePath + "]";
    }
}

class NewLineElement implements DocumentElement{
    public final String render(){
        return "\n";
    }
}

// Persistence
interface Persistence{
    void save(String data);
}

class SaveToDB implements Persistence{
    public void save(String data){
        System.out.println("Saved the data to DB");
    }
}

class SaveToFile implements Persistence{
    public void save(String data){
        try {
            FileWriter outFile = new FileWriter("document.txt");
            outFile.write(data);
            outFile.close();
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}

// Document
class Document{
    private final List<DocumentElement> elements;
    public Document(){
        elements = new ArrayList<>();
    }

    public void addElements(DocumentElement element){
        elements.add(element);
    }

    public String render(){
        StringBuilder result = new StringBuilder();
        for(DocumentElement e: elements){
            result.append(e.render());
        }
        return result.toString();
    }
}

class DocumentEditorMaster{
    private final Persistence storage;
    private final Document doc;

    public DocumentEditorMaster(Document doc, Persistence storage){
        this.doc = doc;
        this.storage = storage;
    }
    public void addText(String data){
        doc.addElements(new TextElement(data));
    }

    public void addImage(String path){
        doc.addElements(new ImageElement(path));
    }

    public void addNewLine(){
        doc.addElements(new NewLineElement());
    }

    public String render(){
        return doc.render();
    }

    public void save(){
        storage.save(doc.render());
    }

}

public class DocumentEditor {
    public static void main(String[] args){
        Document doc = new Document();
        Persistence dbStorage = new SaveToDB();
        Persistence fileStorage = new SaveToFile();

        DocumentEditorMaster editor = new DocumentEditorMaster(doc, fileStorage);

        editor.addText("My Name is Ashish.");
        editor.addNewLine();
        editor.addText("I am father of Inder");
        editor.addImage("AshishProfile.jpg");

        System.out.println(editor.render());
        editor.save();

        System.out.println();

        DocumentEditorMaster editor1 = new DocumentEditorMaster(doc, dbStorage);
        editor1.addText("My Name is Inder.");
        editor1.addNewLine();
        editor1.addText("I am son of Ashish");
        editor1.addImage("InderProfile.jpg");

        System.out.println(editor1.render());

        editor1.save();

    }
}

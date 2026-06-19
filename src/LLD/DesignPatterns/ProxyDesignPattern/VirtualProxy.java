package LLD.DesignPatterns.ProxyDesignPattern;

interface Image{
    void display();
}

class RealImage implements Image{
    private String filename;

    public RealImage(String filename){
        this.filename = filename;
    }

    @Override
    public void display(){
        // this is expensive operation for loading image from disk
        System.out.println("[RealImage] Loading image from disk: " + filename);
    }
}

class ImageProxy implements Image{
    private Image image;
    private String filename;

    public ImageProxy(String filename){
        this.filename = filename;
        this.image = null;
    }

    @Override
    public void display(){
        // Lazy initialization of RealImage
        if(image==null) {
            System.out.println("Lazy loading of Real Image object");
            image = new RealImage(filename);
        }
        image.display();
    }
}

public class VirtualProxy {
    public static void main(String[] args) {
        Image image = new ImageProxy("image1");
        image.display();
    }
}

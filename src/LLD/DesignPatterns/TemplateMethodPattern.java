package LLD.DesignPatterns;

interface ModelTrainer{
    default void trainPipeline(String path){
        loadData(path);
        preprocessData();
        trainModel();
        evaluateResult();
        saveResult();
    }
    void loadData(String path);
    void preprocessData();
    void trainModel();
    void evaluateResult();
    void saveResult();
}

class NeuralNetworkTrainer implements ModelTrainer{
    public void loadData(String path){
        System.out.println("[NeuralNet] Loaded data from "+path);
    }
    public void preprocessData(){
        System.out.println("[NeuralNet] Splitting into train/test and normalizing");;
    }
    public void trainModel(){
        System.out.println("[NeuralNet] Training Neural Network for 100 epochs");
    }
    public void evaluateResult(){
        System.out.println("[NeuralNet] Evaluating accuracy and loss on validation set");
    }
    public void saveResult(){
        System.out.println("[NeuralNet] Serializing network weights to .h5 file");
    }
}

class DecisionTreeTrainer  implements ModelTrainer{
    public void loadData(String path){
        System.out.println("[DecisionTree] Loaded data from "+path);
    }
    public void preprocessData(){
        System.out.println("[DecisionTree] Splitting into train/test and normalizing");;
    }
    public void trainModel(){
        System.out.println("[DecisionTree] Building decision tree with max_depth=5");
    }
    public void evaluateResult(){
        System.out.println("[DecisionTree] Computing classification report (precision/recall)");
    }
    public void saveResult(){
        System.out.println("[DecisionTree]  Serializing network weights to .txt file");
    }
}

public class TemplateMethodPattern {
    public static void main(String[] args) {
        ModelTrainer neuralNetwork = new NeuralNetworkTrainer();
        ModelTrainer decisionTree = new DecisionTreeTrainer();

        neuralNetwork.trainPipeline("/downloads/neuralData.txt");
        System.out.println("\n--------------------------------------------\n");
        decisionTree.trainPipeline("/downloads/decisionTreedata.txt");

    }
}

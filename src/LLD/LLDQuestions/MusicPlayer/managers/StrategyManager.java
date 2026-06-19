package LLD.LLDQuestions.MusicPlayer.managers;

import LLD.LLDQuestions.MusicPlayer.strategies.PlayStrategy;
import LLD.LLDQuestions.MusicPlayer.strategies.RandomPlayStrategy;
import LLD.LLDQuestions.MusicPlayer.strategies.SequentialPlayStrategy;

public class StrategyManager {
    public static StrategyManager strategyManager;
    private PlayStrategy playStrategy;

    private StrategyManager(){
        playStrategy = null;
    }

    public static StrategyManager  getInstance(){
        if(strategyManager==null)
            strategyManager = new StrategyManager();
        return strategyManager;
    }

    public PlayStrategy getPlayStrategy(String type){
        if(type.equalsIgnoreCase("randon"))
            return new RandomPlayStrategy();
        return new SequentialPlayStrategy();
    }

}

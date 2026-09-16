 package LLD.DesignPatterns.DecoratorDP;

interface Character{
    String getAbilities();
}

class Mario implements Character{
    public String getAbilities(){
        return "Mario";
    }
}

abstract class CharacterDecorator implements Character{
    protected Character character;

    public CharacterDecorator(Character c){
        this.character = c;
    }
}

class HeightUp extends CharacterDecorator{
    public HeightUp(Character c){
        super(c);
    }

    public String getAbilities(){
        return character.getAbilities() + " with Height Up";
    }
}

class GunPowerUp extends CharacterDecorator{
    public GunPowerUp(Character c){
        super(c);
    }

    public String getAbilities(){
        return character.getAbilities() + " with Gun Power";
    }
}

class StarPowerUp  extends CharacterDecorator{
    public StarPowerUp (Character c){
        super(c);
    }

    public String getAbilities(){
        return character.getAbilities() + " with Star Power (Limited Time)";
    }
}

public class DecoratorDesignPattern {
    public static void main(String[] args){
        System.out.println("-------------------------Game 1----------------------------");
        Character mario = new Mario();
        System.out.println("Basic Character: " + mario.getAbilities());

        // Decorate Mario with a HeightUp power-up.
        mario = new HeightUp(mario);
        System.out.println("After HeightUp: " + mario.getAbilities());

        // Decorate Mario further with a GunPowerUp.
        mario = new GunPowerUp(mario);
        System.out.println("After GunPowerUp: " + mario.getAbilities());

        // Finally, add a StarPowerUp decoration.
        mario = new StarPowerUp(mario);
        System.out.println("After StarPowerUp: " + mario.getAbilities());

        System.out.println("\n--------------------------Game 2----------------------------");

        Character newMario = new StarPowerUp(new GunPowerUp(new Mario()));
        System.out.println("Abilities of new Mario : "+ newMario.getAbilities());

    }
}

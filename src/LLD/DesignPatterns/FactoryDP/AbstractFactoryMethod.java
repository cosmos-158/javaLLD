package LLD.DesignPatterns.FactoryDP;


// ================= PRODUCT FAMILY 1 =================

interface Sabji {
    void prepare();
}

class PaneerButterMasala implements Sabji {
    @Override
    public void prepare() {
        System.out.println("Preparing Paneer Butter Masala");
    }
}

class PalakPaneer implements Sabji {
    @Override
    public void prepare() {
        System.out.println("Preparing Palak Paneer");
    }
}

class MalaiKofta implements Sabji {
    @Override
    public void prepare() {
        System.out.println("Preparing Malai Kofta");
    }
}


// ================= PRODUCT FAMILY 2 =================

interface Bread {
    void prepare();
}

class ButterNaan implements Bread {
    @Override
    public void prepare() {
        System.out.println("Preparing Butter Naan");
    }
}

class TandooriRoti implements Bread {
    @Override
    public void prepare() {
        System.out.println("Preparing Tandoori Roti");
    }
}

class LachhaParatha implements Bread {
    @Override
    public void prepare() {
        System.out.println("Preparing Lachha Paratha");
    }
}


// ================= ABSTRACT FACTORY =================

interface DhabaFactory {
    Sabji createSabji();
    Bread createBread();
}


// ================= CONCRETE FACTORIES =================

class PunjabiDhabaFactory implements DhabaFactory {
    @Override
    public Sabji createSabji() {
        return new PaneerButterMasala();
    }

    @Override
    public Bread createBread() {
        return new ButterNaan();
    }
}


class HealthyDhabaFactory implements DhabaFactory {
    @Override
    public Sabji createSabji() {
        return new PalakPaneer();
    }

    @Override
    public Bread createBread() {
        return new TandooriRoti();
    }
}


class LuxuryDhabaFactory implements DhabaFactory {
    @Override
    public Sabji createSabji() {
        return new MalaiKofta();
    }

    @Override
    public Bread createBread() {
        return new LachhaParatha();
    }
}


// ================= CLIENT =================

class Meal {
    private final Sabji sabji;
    private final Bread bread;

    public Meal(DhabaFactory factory) {
        this.sabji = factory.createSabji();
        this.bread = factory.createBread();
    }

    public void serveMeal() {
        sabji.prepare();
        bread.prepare();
    }
}


// ================= MAIN =================

public class AbstractFactoryMethod {
    public static void main(String[] args) {
        System.out.println("---- Punjabi Dhaba Meal ----");
        DhabaFactory punjabiDhaba = new PunjabiDhabaFactory();
        Meal punjabiMeal = new Meal(punjabiDhaba);
        punjabiMeal.serveMeal();

        System.out.println("\n-----------------------------\n");

        System.out.println("---- Healthy Dhaba Meal ----");
        DhabaFactory healthyDhaba = new HealthyDhabaFactory();
        Meal healthyMeal = new Meal(healthyDhaba);
        healthyMeal.serveMeal();

        System.out.println("\n-----------------------------\n");

        System.out.println("---- Luxury Dhaba Meal ----");
        DhabaFactory luxuryDhaba = new LuxuryDhabaFactory();
        Meal luxuryMeal = new Meal(luxuryDhaba);
        luxuryMeal.serveMeal();
    }
}
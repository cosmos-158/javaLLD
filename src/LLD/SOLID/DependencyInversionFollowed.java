package LLD.SOLID;

interface SaveToDatabases{
    void save(String user);
}

class MongoDB implements SaveToDatabases{
    public void save(String user){
        System.out.println("Saving "+user +" details to Mongo DB");
    }
}

class SqlDB implements SaveToDatabases{
    public void save(String user){
        System.out.println("Saving "+user +" details to SQL DB");
    }
}

class UsersService{
    SaveToDatabases db; // dependency injection
    public UsersService(SaveToDatabases db){
        this.db = db;
    }

    public void storeUser(String user){
        this.db.save(user);
    }

}

public class DependencyInversionFollowed {
    public static void main(String[] args){
        SaveToDatabases mongo = new MongoDB();
        UsersService user1 = new UsersService(mongo);
        user1.storeUser("Ashish Chaurasia");

        SaveToDatabases sql = new SqlDB();
        UsersService user2 = new UsersService(sql);
        user2.storeUser("John Doe");
    }
}

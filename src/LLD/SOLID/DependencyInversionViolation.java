package LLD.SOLID;

class MySQLDatabase{
    public void saveToSQL(String data){
        System.out.println("Executing SQL Query: Insert INTO user Values ( "+ data+" );");
    }
}

class MongoSBDatabase{
    public void saveToMongo(String data){
        System.out.println("Executing MongoDB Function: db.users.insert ( "+ data+" );");
    }
}

class UserService{
    MySQLDatabase sqlDB = new MySQLDatabase();
    MongoSBDatabase mongoDB = new MongoSBDatabase();

    public void storeUserToSQL(String user){
        this.sqlDB.saveToSQL(user);
    }

    public void storeUserToMongo(String user){
        this.mongoDB.saveToMongo(user);
    }
}


public class DependencyInversionViolation {
    public static void main(String[] args){
        UserService service = new UserService();
        service.storeUserToMongo("Ashish Chaurasia");
        service.storeUserToSQL("Ashish Chaurasia");
    }
}

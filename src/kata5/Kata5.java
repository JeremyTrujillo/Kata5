package kata5;

public class Kata5 {

    public static void main(String[] args) {
        Database database = new Database("jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Kata5\\DB_SQLite\\kata5_DB.db");
        database.open();
        
        //...
        database.select();
        Person person = new Person("Santiago", "Sánchez", "Marketing");
        database.insert(person);
        
        System.out.println("");
        database.select();
        database.close();
    }
    
}

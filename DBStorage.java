package rs.ac.ni.pmf.oop2;

public class DBStorage implements Storage{
    @Override
    public void store(final String input){
        System.out.println("Database Storage : Successful");
    }
}

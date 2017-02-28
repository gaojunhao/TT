package Mode;

public interface Subject {
public void add(Observer observer);
public void delete(Observer observer);
public void notifyAllServer();
public void operation();
}

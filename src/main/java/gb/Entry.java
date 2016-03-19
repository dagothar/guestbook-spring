package gb;

public class Entry {
  private final int id;
  private final String message;
  
  public Entry(int id, String message) {
    this.id = id;
    this.message = message;
  }
  
  public int getId() {
    return id;
  }
  
  public String getMessage() {
    return message;
  }
  
  @Override
  public String toString() {
    return String.format("Entry[id='%d', message='%s']", id, message);
  }
  
};

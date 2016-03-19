package gb;

public class Entry {
  private int id;
  private String message;
  
  public Entry() {
  }
  
  public Entry(int id, String message) {
    this.id = id;
    this.message = message;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getMessage() {
    return message;
  }
  
  public void setMessage(String message) {
    this.message = message;
  }
  
  @Override
  public String toString() {
    return String.format("Entry[id='%d', message='%s']", id, message);
  }
  
};

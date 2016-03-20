package gb;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.*;
import org.joda.time.LocalDateTime;

public class Entry {

    private int id;

    @NotNull
    @Size(min = 1, max = 255, message = "Message cannot be empty!")
    private String message;

    @NotNull
    @Size(min = 1, max = 255, message = "Author signature cannot be empty!")
    private String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    public Entry() {
    }

    public Entry(int id, String message, String author, LocalDateTime dateTime) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.dateTime = dateTime;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

};

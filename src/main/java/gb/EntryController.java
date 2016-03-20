package gb;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
public class EntryController {

  @Autowired
  EntryRepository entryRepository;

  @RequestMapping(value = "/entries", method = RequestMethod.GET)
  public List<Entry> getAllEntries() {
    return entryRepository.findAll();
  }

  @RequestMapping(value = "/entries", method = RequestMethod.PUT)
  public void addNewEntry(@RequestBody @Valid Entry entry) {
    entryRepository.addEntry(entry);
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleException(MethodArgumentNotValidException exception) {
    return "error";
  }

};

package gb;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/entries")
public class EntryController {

  @Autowired
  EntryRepository entryRepository;

  @RequestMapping(method = RequestMethod.GET)
  public List<Entry> getAllEntries() {
    return entryRepository.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, params = {"from_id", "to_id"})
  public List<Entry> getEntriesForIdsBetween(@RequestParam(value = "from_id", defaultValue = "0") Long from, @RequestParam(value = "to_id", defaultValue = "9999") Long to) {
    return entryRepository.findForIdsBetween(from, to);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public void addNewEntry(@RequestBody @Valid Entry entry) {
    entryRepository.addEntry(entry);
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiError handleException(MethodArgumentNotValidException exception) {
    return new ApiError("error");
  }

};

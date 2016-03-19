package gb;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
public class EntryController {
  
  @Autowired
  EntryRepository entryRepository;
  
  @RequestMapping(value = "/entries", method = RequestMethod.GET)
  public List<Entry> getAllEntries() {
    return entryRepository.findAll();
  }
  
  @RequestMapping(value = "/entries", method = RequestMethod.PUT)
  public void addNewEntry(@RequestBody Entry entry) {
    entryRepository.addEntry(entry);
  }
  
};

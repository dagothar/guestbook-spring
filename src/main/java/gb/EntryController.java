package gb;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@RequestMapping("/entries")
public class EntryController {
  
  @Autowired
  EntryRepository entryRepository;
  
  @RequestMapping(method = RequestMethod.GET)
  public List<Entry> getAllEntries() {
    return entryRepository.findAll();
  }
  
};

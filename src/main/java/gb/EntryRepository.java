package gb;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Repository
public class EntryRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public List<Entry> findAll() {
    List<Entry> entries = new ArrayList<Entry>();

    List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM Entries");

    for (Map row : rows) {
      Entry entry = new Entry((Integer)row.get("id"), (String)row.get("message"));
      entries.add(entry);
    }

    return entries;
  }

  public List<Entry> findForIdsBetween(Long from, Long to) {
    String sql = "SELECT * FROM Entries WHERE id >= ? AND id <= ?";

    List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { from, to });

    List<Entry> entries = new ArrayList<Entry>();

    for (Map row : rows) {
      Entry entry = new Entry((Integer)row.get("id"), (String)row.get("message"));
      entries.add(entry);
    }

    return entries;
  }

  public void addEntry(Entry entry) {
    String sql = "INSERT INTO Entries(message) VALUES(?)";

    jdbcTemplate.update(sql, new Object[] { entry.getMessage() });
  }

};

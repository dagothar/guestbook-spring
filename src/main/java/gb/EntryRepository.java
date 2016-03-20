package gb;

import java.sql.Timestamp;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import org.joda.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EntryRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Entry> findAll() {
        List<Entry> entries = new ArrayList<Entry>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM Entries");

        for (Map row : rows) {
            Entry entry = new Entry((Integer) row.get("id"), (String) row.get("message"), (String) row.get("author"), new LocalDateTime(row.get("dateTime")));
            entries.add(entry);
        }

        return entries;
    }

    public List<Entry> findForIdsBetween(Long from, Long to) {
        String sql = "SELECT * FROM Entries WHERE id >= ? AND id <= ?";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[]{from, to});

        List<Entry> entries = new ArrayList<Entry>();

        for (Map row : rows) {
            Entry entry = new Entry((Integer) row.get("id"), (String) row.get("message"), (String) row.get("author"), new LocalDateTime(row.get("dateTime")));
            entries.add(entry);
        }

        return entries;
    }

    public void addEntry(Entry entry) {
        String sql = "INSERT INTO Entries(message, author, dateTime) VALUES(?, ?, NOW())";

        jdbcTemplate.update(sql, new Object[]{entry.getMessage(), entry.getAuthor()});
    }

};

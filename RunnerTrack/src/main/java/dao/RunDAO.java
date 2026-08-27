package dao;

import entity.Run;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RunDAO {

    private final JdbcTemplate jdbcTemplate;

    public RunDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void tabloOlustur() {
        String sql = "CREATE TABLE IF NOT EXISTS runs (id BIGINT AUTO_INCREMENT PRIMARY KEY, date DATE, distance DOUBLE, duration INT)";
        jdbcTemplate.execute(sql);
        System.out.println("Spring JDBC: Tablo hazırlandı.");
    }

    public void kosuEkle(Run run) {
        String sql = "INSERT INTO runs (date, distance, duration) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, run.getDate(), run.getDistance(), run.getDuration());
        System.out.println("Spring JDBC: Koşu başarıyla eklendi.");
    }

    public List<Run> tumKosulariGetir() {
        String sql = "SELECT * FROM runs";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Run run = new Run();
            run.setId(rs.getLong("id"));
            run.setDate(rs.getDate("date").toLocalDate());
            run.setDistance(rs.getDouble("distance"));
            run.setDuration(rs.getInt("duration"));
            return run;
        });
    }
}
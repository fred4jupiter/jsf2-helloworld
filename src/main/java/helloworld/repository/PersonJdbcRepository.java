package helloworld.repository;

import helloworld.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@NoRepositoryBean
public class PersonJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Person findPersonById(Long id) {
        final String sql = "Select id, first_name, last_name from person where id = ?";

        List<Person> personList = jdbcTemplate.query(sql, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Person(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"));
            }
        }, id);

        return DataAccessUtils.requiredSingleResult(personList);
    }

}

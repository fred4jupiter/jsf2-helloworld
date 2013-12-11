package helloworld.repository;

import helloworld.Application;
import helloworld.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class PersonJdbcRepositoryTest {

    @Autowired
    private PersonJdbcRepository personJdbcRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void findPersonByExecutingSql() {
        Person person = personRepository.saveAndFlush(new Person("Fred", "Feuerstein"));
        assertThat(person.getId(), notNullValue());

        Person foundPersonByJdbc = personJdbcRepository.findPersonById(person.getId());
        assertThat(foundPersonByJdbc, equalTo(person));
    }
}

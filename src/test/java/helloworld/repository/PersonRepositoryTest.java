package helloworld.repository;

import helloworld.AppConfig;
import helloworld.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void containsNone() {
        assertThat(personRepository.findAll().size(), equalTo(0));
    }

    @Test
    public void containsOne() {
        Person person = personRepository.saveAndFlush(new Person("Karl", "Cox"));
        assertThat(person.getId(), notNullValue());

        assertThat(personRepository.findAll().size(), equalTo(1));
        Person foundPerson = personRepository.findOne(person.getId());
        assertThat(foundPerson, equalTo(person));
    }
}

package mongo.crud.springboot.mongodbspringboot.controller;

import mongo.crud.springboot.mongodbspringboot.model.Person;
import mongo.crud.springboot.mongodbspringboot.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("all")
    public List<Person> getAll(){
        return personRepository.findAll();
    }

    @PostMapping("create")
    public Person createPerson(@RequestBody Person person){
        return personRepository.insert(person);
    }

    @PutMapping("update")
    public Person updatePerson(@RequestBody Person person){
        return personRepository.save(person);
    }
}

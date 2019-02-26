package mongo.crud.springboot.mongodbspringboot.controller;

import mongo.crud.springboot.mongodbspringboot.model.Hotel;
import mongo.crud.springboot.mongodbspringboot.model.Person;
import mongo.crud.springboot.mongodbspringboot.repository.HotelRepository;
import mongo.crud.springboot.mongodbspringboot.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private HotelRepository hotelRepository;
    private PersonRepository personRepository;

    public HotelController(HotelRepository hotelRepository, PersonRepository personRepository) {
        this.hotelRepository = hotelRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("all")
    public List<Hotel> getHotels(){
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels;
    }

    @PostMapping("create/{personId}")
    public Hotel createHotel(@RequestBody Hotel hotel,
                             @PathVariable String personId){
        Optional<Person> optionalPerson = personRepository.findById(personId);
        if (optionalPerson.isPresent()){
            hotel.setPerson(optionalPerson.get());
            return hotelRepository.insert(hotel);
        }
        else {
            return null;
        }
    }

    @PutMapping("update")
    public Hotel updateHotel(@RequestBody Hotel hotel){
            return hotelRepository.save(hotel);

    }

    @DeleteMapping("delete/{hotelId}")
    public void deleteHotel(@PathVariable String hotelId){
        hotelRepository.deleteById(hotelId);
    }
}

package com.example.demo.web.api;

import com.example.demo.Taco;
import com.example.demo.data.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoController {
    private TacoRepository tacoRepository;
    @Autowired
    EntityLinks entityLinks;
    public DesignTacoController(TacoRepository tacoRepository){
        this.tacoRepository = tacoRepository;
    }
    @GetMapping("/recent")
    public Iterable<Taco> recentTacos(){
        return tacoRepository.findAll();
    }
    @GetMapping("/{id}")
    public Taco tacoById(@PathVariable("id") Long id){
        Optional<Taco> optionalTaco = tacoRepository.findById(id);
        if(optionalTaco.isPresent()){
            return optionalTaco.get();
        }
        return null;
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco){
        return tacoRepository.save(taco);
    }
}

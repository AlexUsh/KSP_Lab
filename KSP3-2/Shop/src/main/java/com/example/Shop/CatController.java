package com.example.Shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatController {

     @Autowired
     CatRepository CatRepository;

    @GetMapping("/cats")
    public List<Cat> getCats() {
        return CatRepository.findAll();
    }

    @PostMapping("/cats")
    public Cat addCat(@RequestBody Cat cat) {
        CatRepository.save(cat);
        return cat;
    }

    @GetMapping("/cats/{id}")
    public Cat getCat(@PathVariable("id") int id){
        return CatRepository.findById(id).get();
    }

    @PostMapping("/cats/{id}")
    public Cat changeCat(@PathVariable("id") int id, @RequestBody Cat cat){
         Cat tmp = CatRepository.getOne(id);
         tmp.name = cat.name;
         tmp.price = cat.price;
         CatRepository.save(tmp);
         return tmp;
    }

    @DeleteMapping("/cats/{id}")
    public void removeCat(@PathVariable("id") int id){
        CatRepository.deleteById(id);
    }


}

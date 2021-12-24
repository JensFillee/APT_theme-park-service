package fact.it.apt_themeparkservice.controller;

import fact.it.apt_themeparkservice.model.Themepark;
import fact.it.apt_themeparkservice.repository.ThemeparkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ThemeparkCotroller {

    @Autowired
    private ThemeparkRepository themeparkRepository;

    @PostConstruct
    public void fillDB(){
        if(themeparkRepository.count()==0){
            themeparkRepository.save(new Themepark("1","Test themepark 1","straatlaan 2", 5000,"156545"));
            themeparkRepository.save(new Themepark("2","Test themepark 2","straatlaan 3", 5000,"156554"));
            themeparkRepository.save(new Themepark("3","bobbejaanland","straatlaan 4", 5000,"156884"));
            themeparkRepository.save(new Themepark("4","walibi","nederlandlaan 12", 80000,"156888"));

        }
        System.out.println(themeparkRepository.findThemeParkByThemeparkCode("156545").getName());
    }

    @GetMapping("/themeparks/name/{name}")
    public List<Themepark> getThemeparksByName(@PathVariable String name){
        return themeparkRepository.findThemeparkByNameContaining(name);
    }

    @GetMapping("/themeparks/{themeparkCode}")
    public Themepark getThemeparkByThemeparkCode(@PathVariable String themeparkCode){
        return themeparkRepository.findThemeParkByThemeparkCode(themeparkCode);
    }

    @GetMapping("/themeparks")
    public List<Themepark> getThemeparks() {
        return themeparkRepository.findAll();
    }

}

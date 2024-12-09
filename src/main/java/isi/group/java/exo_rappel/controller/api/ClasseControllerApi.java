package isi.group.java.exo_rappel.controller.api;

import isi.group.java.exo_rappel.entity.Classe;
import isi.group.java.exo_rappel.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classe")
public class ClasseControllerApi {

    @Autowired
    private ClasseService classeService;

    @GetMapping()
    public List<Classe> listClasse(){
        return classeService.listClasse();
    }

    @GetMapping("/{id}")
    public Classe getClasseById(@PathVariable Long id){
        return  classeService.getClasseById(id);
    }


    @PostMapping()
    public  Classe addClasse(@RequestBody Classe classe){

        return classeService.addClasse(classe);
    }

    @PutMapping("/{id}")
    public Classe updateClasse(@PathVariable Long id, @RequestBody Classe classe){
        return classeService.updateClasse(id, classe);
    }


    @DeleteMapping("/{id}")
    public void  deleteClasse(@PathVariable Long id){
        classeService.deleteClasse(id);
    }


}

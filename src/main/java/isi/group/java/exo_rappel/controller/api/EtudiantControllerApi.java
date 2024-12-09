package isi.group.java.exo_rappel.controller.api;

import isi.group.java.exo_rappel.entity.Etudiant;
import isi.group.java.exo_rappel.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/etudiants")
public class EtudiantControllerApi {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public List<Etudiant> findAll(){
        return etudiantService.listEtudiants();
    }

    @PostMapping
    private Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.addEtudiant(etudiant);
    }

    @GetMapping("/{id}")
    private Etudiant getEtudiant(@PathVariable Long id){
        return etudiantService.getEtudiantById(id);
    }

    @PutMapping("/{id}")
    private Etudiant updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant){
        return etudiantService.updateEtudiant(id, etudiant);
    }


    @DeleteMapping("/{id}")
    private void deleteEtudiant(@PathVariable Long id){
        etudiantService.deleteEtudiant(id);
    }



}

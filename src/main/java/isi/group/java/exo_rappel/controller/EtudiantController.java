package isi.group.java.exo_rappel.controller;

import isi.group.java.exo_rappel.entity.Etudiant;
import isi.group.java.exo_rappel.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;


    @GetMapping
    public String findAll(Model model) {
        List<Etudiant> etudiants = etudiantService.listEtudiants();
        model.addAttribute("etudiants", etudiants);
        return "etudiants/list";
    }

    @GetMapping("/add")
    public String showAddEtudiantForm(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "etudiants/add";
    }

    @PostMapping("/add")
    public String addEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantService.addEtudiant(etudiant); // Enregistre l'étudiant dans la base
        return "redirect:/etudiants"; // Redirige vers la liste des étudiants
    }

    @GetMapping("/{id}")
    private String getEtudiant(@PathVariable Long id){
         etudiantService.getEtudiantById(id);
        return "redirect:/etudiants";
    }


    @GetMapping("/edit/{id}")
    private String showEditEtudiant(Model model, @PathVariable Long id){
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        model.addAttribute("etudiant", etudiant);
        return "etudiants/edit";
    }

    @PostMapping("/edit/{id}")
    private String updateEtudiant(@PathVariable Long id, @ModelAttribute Etudiant etudiant){
        etudiantService.updateEtudiant(id, etudiant);
        return "redirect:/etudiants";
    }


    @PostMapping("/delete/{id}")
    private String deleteEtudiant(@PathVariable Long id){
        etudiantService.deleteEtudiant(id);
        return "redirect:/etudiants ";
    }



}

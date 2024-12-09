package isi.group.java.exo_rappel.service;

import isi.group.java.exo_rappel.entity.Etudiant;
import isi.group.java.exo_rappel.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    private EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public List<Etudiant> listEtudiants(){
        return etudiantRepository.findAll();
    }

    public Etudiant addEtudiant(Etudiant etudiant){
        Etudiant etudiant1;
        try {
            etudiant1 = etudiantRepository.save(etudiant);
        }catch (Exception message){
            throw new RuntimeException("Echec de l'ajout : "+message);
        }
        return etudiant1;
    }


    public Etudiant getEtudiantById(Long id){
        Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(id);
        if (!optionalEtudiant.isPresent()){
            throw new RuntimeException("Etudiant non trouvé !");
        }
        return optionalEtudiant.orElse(null);
    }


    public Etudiant updateEtudiant(Long id, Etudiant etudiant){
        Etudiant optionalDetail = etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé avec l'ID : " + id));

        optionalDetail.setCode(etudiant.getCode());
        optionalDetail.setNom(etudiant.getNom());
        optionalDetail.setPrenom(etudiant.getPrenom());
        optionalDetail.setAge(etudiant.getAge());
        optionalDetail.setTelephone(etudiant.getTelephone());

        return etudiantRepository.save(etudiant);
    }


    public void deleteEtudiant(Long id){
        etudiantRepository.deleteById(id);
    }

}

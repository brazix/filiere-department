package est.gi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import est.gi.DAO.FiliereRepository;
import est.gi.entities.Filiere;

@Service
public class FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;
    
    public Filiere createFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }
    
    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }
    
    public Filiere getFiliereById(Long id) {
        return filiereRepository.findById(id).orElse(null);
    }
    
    public Filiere updateFiliere(Long id, Filiere filiereDetails) {
        Filiere filiere = filiereRepository.findById(id).orElse(null);
        if (filiere != null) {
            filiere.setName(filiereDetails.getName());
            filiere.setDepartment(filiereDetails.getDepartment());
            // Mise à jour des autres attributs si nécessaire
            return filiereRepository.save(filiere);
        }
        return null;
    }
    
    public void deleteFiliere(Long id) {
        filiereRepository.deleteById(id);
    }
}

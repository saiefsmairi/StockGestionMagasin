package tn.esprit.spring.service;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;
import tn.esprit.entity.Facture;
import tn.esprit.entity.Fournisseur;
import tn.esprit.entity.Produit;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.repository.ProduitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class FournisseurServiceImpl implements IFournisseurService{

    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
	ProduitRepository produitRepository;
	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		   return fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
        return fournisseurRepository.save(f);

	}

	@Override
	public void deleteFournisseur(Long id) {
		fournisseurRepository.deleteById(id);

		
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		System.out.println(f);
		fournisseurRepository.updateFournisseur(f.getIdFournisseur(), f.getLibelle(), f.getAdresse(), f.getNumero());
		return null;
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		return fournisseurRepository.findById(id).orElse(null);

	}

	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		Produit p = produitRepository.findById(produitId) .orElse(null);
		Fournisseur f = fournisseurRepository.findById(fournisseurId) .orElse(null);
		
		System.out.println(fournisseurId);
		System.out.println("----------");

		System.out.println(produitId);

		f.getProduits().add(p);
		
	
		fournisseurRepository.save(f);
	}
	
	@Override
	public Set<Produit> retrieveProduitFournisseur(Long	fournisseurId) {
		Fournisseur f = fournisseurRepository.findById(fournisseurId) .orElse(null);
	
		   return f.getProduits();
	}
	
	
}

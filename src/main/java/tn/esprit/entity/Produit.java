package tn.esprit.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Produit {

@Id
@GeneratedValue( strategy = GenerationType.IDENTITY )
@Column
private long idproduit;

@Column 
String image;
@Column
String code;

@Column
String libelle;

@Column
Float prixUnitaire;
@Column 
String categoryName ;

@Column 
String stockName ;

@Column 
String description ;
@ManyToOne
private Stock stock;

@Column 
String idFournisseur ;

@OneToOne
@JsonBackReference(value="detailproduit")
private DetailProduit detailProduit;


@ManyToOne
@JsonBackReference(value="rayon")
private Rayon rayon;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "idFacture")
private List<detailFacture> detailFactures;

@ManyToMany(cascade = CascadeType.ALL)
@JsonBackReference
@JoinTable(name = "T_PRODUIT_FOURNISSEUR",joinColumns={@JoinColumn(name="idproduit")},inverseJoinColumns={@JoinColumn(name ="idFournisseur")})
private Set<Fournisseur> fournisseurs;



@Override
public String toString() {
	return "Produit [idproduit=" + idproduit + ", code=" + code + ", libelle=" + libelle + ", prixUnitaire="
			+ prixUnitaire + ", stock=" + stock + ", detailProduit=" + detailProduit + ", rayon=" + rayon
			+ ", detailFactures=" + detailFactures + ", fournisseurs=" + fournisseurs + "+ \", idFournisseur=\" + idFournisseur\r\n" + 
					"			+ \"]";
}



}

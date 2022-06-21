package org.example;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PRODUIT",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "PRO_ID" }) })

public class Produit {
    private Integer id;
    private String produit;
    private double prix;

    public Produit(){}

    public Produit(Integer id,String produit, double prix) {
        this.id = id;
        this.produit = produit;
        this.prix = prix;
    }

    @Id
    @Column(name="PRO_ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name="PRO_NOM")
    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    @Id
    @Column(name="PRO_PRIX")
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}

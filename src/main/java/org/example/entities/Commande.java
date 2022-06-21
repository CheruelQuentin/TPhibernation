package org.example.entities;


import java.sql.Time;
import java.util.Date;
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
@Table(name = "COMMANDE",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "COM_ID" }) })
public class Commande {
    private Integer id;
    private Date date;
    private Time heure;
    private Set<Produit> produits = new HashSet<Produit>(0);
    private Set<Client> clients = new HashSet<Client>(0);


    public Commande(Integer id, Date date, Time heure, Set<Produit> produits, Set<Client> clients) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.produits = produits;
        this.clients = clients;
    }

    @Id
    @Column(name="COM_ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="COM_DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Column(name="COM_HEURE")
    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}

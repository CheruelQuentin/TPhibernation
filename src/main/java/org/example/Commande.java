package org.example;


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
}

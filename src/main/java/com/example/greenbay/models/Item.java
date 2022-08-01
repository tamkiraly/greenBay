package com.example.greenbay.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private boolean sellable;
  @Column(name = "item_name")
  private String name;
  private String description;
  private String photoURL;
  private Integer startingPrice;
  private Integer purchasePrice;
  private Long lastOfferedBidId;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "item")
  private List<Bid> placedBids;
  @ManyToOne
  private User user;
}

package com.javaweb.entity.event;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="eventprizes")
public class EventPrizesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long PrizeID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="EventID")
	@JsonBackReference
	private EventEntity eventPrize;
	@Column(name="Ranking")
	private Integer rank;
	@Column(name="PrizeAmount", precision=10, scale=2)
	private Double amount;
	@Column(name="Description")
	private String description;
	public Long getPrizeID() {
		return PrizeID;
	}
	public void setPrizeID(Long prizeID) {
		PrizeID = prizeID;
	}
	
	public EventEntity getEventPrize() {
		return eventPrize;
	}
	public void setEventPrize(EventEntity eventPrize) {
		this.eventPrize = eventPrize;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

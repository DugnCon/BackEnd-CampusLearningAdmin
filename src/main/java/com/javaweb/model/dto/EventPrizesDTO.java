package com.javaweb.model.dto;

public class EventPrizesDTO {
	private Long PrizeID;
	private Long EventID;
	private Integer rank;
	private Double amount;
	private String description;
	public Long getPrizeID() {
		return PrizeID;
	}
	public void setPrizeID(Long prizeID) {
		PrizeID = prizeID;
	}
	
	public Long getEventID() {
		return EventID;
	}
	public void setEventID(Long eventID) {
		EventID = eventID;
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

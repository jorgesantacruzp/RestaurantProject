package com.restaurant.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_ticket")
public class Ticket {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ticket")
	private int id;
	@Column(name="ticket_number")
	private String number;
	@Column(name="issue_date")
	private Date issueDate;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy="ticket")
	private List<TicketDetails> listTicketDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TicketDetails> getListTicketDetails() {
		return listTicketDetails;
	}

	public void setListTicketDetails(List<TicketDetails> listTicketDetails) {
		this.listTicketDetails = listTicketDetails;
	}
	
}

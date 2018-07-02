package com.nisum.springwebfluxpoc;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class Score {

	@Id
	@JsonProperty
	private Long id;
	@JsonProperty
	private String player1;
	@JsonProperty
	private String player2;
	@JsonProperty
	private String player1Score;
	@JsonProperty
	private String player2Score;
	@JsonProperty
	private String totalScore;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlayer1() {
		return player1;
	}
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}
	public String getPlayer2() {
		return player2;
	}
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	public String getPlayer1Score() {
		return player1Score;
	}
	public void setPlayer1Score(String player1Score) {
		this.player1Score = player1Score;
	}
	public String getPlayer2Score() {
		return player2Score;
	}
	public void setPlayer2Score(String player2Score) {
		this.player2Score = player2Score;
	}
	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	@JsonIgnore
	@Override
	public String toString() {
		return "Score [id=" + id + ", player1=" + player1 + ", player2=" + player2 + ", player1Score=" + player1Score
				+ ", player2Score=" + player2Score + ", totalScore=" + totalScore + "]";
	}
	
	
}

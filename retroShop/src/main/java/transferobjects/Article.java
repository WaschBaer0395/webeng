package transferobjects;


import io.ebean.annotation.Length;
import io.ebean.annotation.NotNull;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;


@RequestScoped
@Named
@Entity
@Table(name = "articles")
public class Article implements Serializable {
	
	@NotNull @Length(30)
	private String name;
	private String desc;
	private float price;
	private float minPrice;
	private LocalDate releaseDate;
	private String imagePath;
	private int sellerId;
	@Id
	private long id;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setReleaseDate (LocalDate releaseDate){
		this.releaseDate = releaseDate;
	}
	public LocalDate getReleaseDate(){
		return this.releaseDate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}
	public void setImagePath(String path){
		this.imagePath = path;
	}
	public String getImagePath(){
		return this.imagePath;
	}
	public void setSellerId(int sellerId){
		this.sellerId = sellerId;
	}
	public int getSellerId(){
		return this.sellerId;
	}
}

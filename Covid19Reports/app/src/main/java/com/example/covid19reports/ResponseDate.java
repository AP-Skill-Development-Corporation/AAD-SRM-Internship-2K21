package com.example.covid19reports;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseDate implements Serializable {

	@SerializedName("CityCode")
	private String cityCode;

	@SerializedName("Recovered")
	private int recovered;

	@SerializedName("Lon")
	private String lon;

	@SerializedName("City")
	private String city;

	@SerializedName("Province")
	private String province;

	@SerializedName("Date")
	private String date;

	@SerializedName("Active")
	private int active;

	@SerializedName("Country")
	private String country;

	@SerializedName("Deaths")
	private int deaths;

	@SerializedName("ID")
	private String iD;

	@SerializedName("Confirmed")
	private int confirmed;

	@SerializedName("CountryCode")
	private String countryCode;

	@SerializedName("Lat")
	private String lat;

	public void setCityCode(String cityCode){
		this.cityCode = cityCode;
	}

	public String getCityCode(){
		return cityCode;
	}

	public void setRecovered(int recovered){
		this.recovered = recovered;
	}

	public int getRecovered(){
		return recovered;
	}

	public void setLon(String lon){
		this.lon = lon;
	}

	public String getLon(){
		return lon;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setProvince(String province){
		this.province = province;
	}

	public String getProvince(){
		return province;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setActive(int active){
		this.active = active;
	}

	public int getActive(){
		return active;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setDeaths(int deaths){
		this.deaths = deaths;
	}

	public int getDeaths(){
		return deaths;
	}

	public void setID(String iD){
		this.iD = iD;
	}

	public String getID(){
		return iD;
	}

	public void setConfirmed(int confirmed){
		this.confirmed = confirmed;
	}

	public int getConfirmed(){
		return confirmed;
	}

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDate{" + 
			"cityCode = '" + cityCode + '\'' + 
			",recovered = '" + recovered + '\'' + 
			",lon = '" + lon + '\'' + 
			",city = '" + city + '\'' + 
			",province = '" + province + '\'' + 
			",date = '" + date + '\'' + 
			",active = '" + active + '\'' + 
			",country = '" + country + '\'' + 
			",deaths = '" + deaths + '\'' + 
			",iD = '" + iD + '\'' + 
			",confirmed = '" + confirmed + '\'' + 
			",countryCode = '" + countryCode + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}
package com.example.popularmovies;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class ResultsItem implements Serializable {

	@SerializedName("adult")
	private boolean adult;

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("genre_ids")
	private List<Integer> genreIds;

	@SerializedName("id")
	private int id;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("original_title")
	private String originalTitle;

	@SerializedName("overview")
	private String overview;

	@SerializedName("popularity")
	private Object popularity;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("release_date")
	private String releaseDate;

	@SerializedName("title")
	private String title;

	@SerializedName("video")
	private boolean video;

	@SerializedName("vote_average")
	private Object voteAverage;

	@SerializedName("vote_count")
	private int voteCount;

	public void setAdult(boolean adult){
		this.adult = adult;
	}

	public boolean isAdult(){
		return adult;
	}

	public void setBackdropPath(String backdropPath){
		this.backdropPath = backdropPath;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public void setGenreIds(List<Integer> genreIds){
		this.genreIds = genreIds;
	}

	public List<Integer> getGenreIds(){
		return genreIds;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setOriginalLanguage(String originalLanguage){
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public void setOriginalTitle(String originalTitle){
		this.originalTitle = originalTitle;
	}

	public String getOriginalTitle(){
		return originalTitle;
	}

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setPopularity(Object popularity){
		this.popularity = popularity;
	}

	public Object getPopularity(){
		return popularity;
	}

	public void setPosterPath(String posterPath){
		this.posterPath = posterPath;
	}

	public String getPosterPath(){
		return posterPath;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setVideo(boolean video){
		this.video = video;
	}

	public boolean isVideo(){
		return video;
	}

	public void setVoteAverage(Object voteAverage){
		this.voteAverage = voteAverage;
	}

	public Object getVoteAverage(){
		return voteAverage;
	}

	public void setVoteCount(int voteCount){
		this.voteCount = voteCount;
	}

	public int getVoteCount(){
		return voteCount;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"adult = '" + adult + '\'' + 
			",backdrop_path = '" + backdropPath + '\'' + 
			",genre_ids = '" + genreIds + '\'' + 
			",id = '" + id + '\'' + 
			",original_language = '" + originalLanguage + '\'' + 
			",original_title = '" + originalTitle + '\'' + 
			",overview = '" + overview + '\'' + 
			",popularity = '" + popularity + '\'' + 
			",poster_path = '" + posterPath + '\'' + 
			",release_date = '" + releaseDate + '\'' + 
			",title = '" + title + '\'' + 
			",video = '" + video + '\'' + 
			",vote_average = '" + voteAverage + '\'' + 
			",vote_count = '" + voteCount + '\'' + 
			"}";
		}
}
package com.example.popularmovies;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class Repo implements Serializable {

	@SerializedName("page")
	private int page;

	@SerializedName("results")
	private List<ResultsItem> results;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("total_results")
	private int totalResults;

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}

	@Override
 	public String toString(){
		return 
			"Repo{" + 
			"page = '" + page + '\'' + 
			",results = '" + results + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			",total_results = '" + totalResults + '\'' + 
			"}";
		}
}
package com.shall.customercomplaints.network.response;

/**
 * 
 * @author Mohamed S. El-Shall
 * <a href="www.facebook.com/M.S.ElShall">Catch me</a>
 * @param <T> of type
 */

public class ResponseVO<T> {
	private T results;
	
	public ResponseVO(T results) {
		this.results = results;
	}
	
	public T getResults() {
		return this.results;
	}
}

package com.bayram.controller;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path(value = "/dosya")
public class DownDoaldService {
	
	
	
	private static final String PNG_ADRES = "C:/Users/bayram/Desktop/hedef//ornek.png";
	//	http://localhost:8080/RestfulRestEasyJAXBJettisonClient/rest/dosya/txtDownLoad
	@GET
	@Path("/txtDownLoad")
	@Produces({"image/png","application/pdf","application/vnd.ms-excel"})
	public Response txtIndir() {
		File file = new File(PNG_ADRES);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"inendosya.png\"");
		return response.build();
	}
	/*
	 
	private static final String TXT_ADRES = "C:/Users/bayram/Desktop/hedef//ornek.txt";
	http://localhost:8080/00012_RestfulRestEasyJAXBJettisonClient/rest/dosya/png
	@GET
	@Path("/png")
	@Produces({"image/png","application/pdf","application/vnd.ms-excel"})
	public Response pngIndir() {
		
		File file = new File(TXT_ADRES);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"inendosya.txt\"");
		return response.build();
	}
	*/

}

package com.bayram.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path(value = "/file")
public class UploadService {
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path(value = "/upload")
	public Response upload(@FormDataParam("file") InputStream uploadInputStream,
						   @FormDataParam("file") FormDataContentDisposition dosyaDetayý) {
		
		String yükle="C:/Users/bayram/Desktop/hedef/"+dosyaDetayý.getFileName();
		
		
		kaydet(uploadInputStream, yükle);
		String yükleme="Sonuc Basarili: "+dosyaDetayý.getFileName();
		
		return Response.status(200).entity(yükleme).build();
		
	}
	
	public void kaydet(InputStream uploadInputStream,String filePath) {
		OutputStream outputStream;
		try {
			 outputStream=new FileOutputStream(new File(filePath));
						
			byte[] bs=new byte[1024];
			
			int readData=uploadInputStream.read(bs);
			
			//outputStream=new FileOutputStream(new File(filePath));
			while (readData!=-1) {
			
				outputStream.write(bs,0, readData);
			}
			outputStream.flush();
			outputStream.close();
			
		} catch (Exception e) {
			
		}
	}


}

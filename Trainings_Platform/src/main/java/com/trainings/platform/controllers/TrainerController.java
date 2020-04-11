package com.trainings.platform.controllers;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Paths;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import com.trainings.platform.Models.Beneficiary;
import com.trainings.platform.Models.Trainer;
import com.trainings.platform.Repository.TrainerRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/trainer")
public class TrainerController {
	
	
	List<String> files = new ArrayList<String>();
	   private final Path rootLocation = Paths.get("/Users/anaslaamarti");
	   
	@Autowired
	TrainerRepository trainerRepository; 
	
	
	@GetMapping("/getone/{id}")
	Trainer getOne(@PathVariable("id") long id){
		
		return trainerRepository.findById(id).get();
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<Trainer> update(@RequestBody Trainer trainer) {

		
		try {
			Trainer b = trainerRepository.findById(trainer.getId()).get();
			b.setFirstName(trainer.getFirstName());
			b.setLastName(trainer.getLastName());
			b.setEmail(trainer.getEmail());
			b.setUsername(trainer.getUsername());
			
			trainerRepository.save(b);

		return new ResponseEntity<>(b, HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
		}
	
	@PostMapping("/savefile")
	   public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
	      String message;
	      String filename =SecurityContextHolder.getContext().getAuthentication().getName();
	      try {
	         try {
	            Files.copy(file.getInputStream(), this.rootLocation.resolve(filename+".pdf"));
	         } catch (Exception e) {
	            throw new RuntimeException("FAIL!");
	         }
	         files.add(file.getOriginalFilename());

	         message = "Successfully uploaded!";
	         return ResponseEntity.status(HttpStatus.OK).body(message);
	      } catch (Exception e) {
	         message = "Failed to upload!";
	         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	      }
	   }
	
	@GetMapping(
			  value = "/getfile/{name}",
			  produces = MediaType.APPLICATION_PDF_VALUE
			)
			public ResponseEntity<byte[]> getImageWithMediaType(HttpServletResponse response,@PathVariable("name") String name) throws IOException {
//			    InputStream in = getClass()
//			      .getResourceAsStream(this.rootLocation+"/"+name+".pdf");
//			    System.out.println(this.rootLocation+"/"+name+".pdf");
			    
//			    
//			    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
//			    DbxEntry.File downloadedFile = client.getFile("/" + filename, null, outputStream);
//			    return outputStream.toByteArray();
			    //return IOUtils.toByteArray(in);
			    
//			    File initialFile = new File(this.rootLocation+"/"+name+".pdf");
//			    InputStream targetStream = new FileInputStream(initialFile);
//			    
//			    
//			    return targetStream;
			    
//			    final File file = new File(this.rootLocation+"/"+name+".pdf");
//			    response.setContentType("application/octet-stream");
//			    response.setHeader("Content-Disposition", "attachment; filename=benebene");
//
//			    return new FileSystemResource(file);
			    
//			    File file = new File(this.rootLocation+"/"+name+".pdf");
//			    FileInputStream fileInputStream = new FileInputStream(file);
//			    Response.ResponseBuilder responseBuilder = javax.ws.rs.core.Response.ok((Object) fileInputStream);
//			    responseBuilder.type("application/pdf");
//			    responseBuilder.header("Content-Disposition",  "filename=restfile.pdf");
//			    return responseBuilder.build();
		
		Path pdfPath = Paths.get(this.rootLocation+"/"+name+".pdf");
	    byte[] pdf = Files.readAllBytes(pdfPath);
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
	    String filename = "output.pdf";
	    headers.setContentDispositionFormData(filename, filename);
	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    ResponseEntity<byte[]> r = new ResponseEntity<byte[]>(pdf, headers, HttpStatus.OK);
	    return r;
			    
			}
			
			
	
//	@GetMapping(value = "/getfile/{name}", produces = "application/pdf")
//	public ResponseEntity<byte[]> createPdf(HttpServletResponse response,@PathVariable("name") String name) {
//
//	    response.setContentType("application/pdf");
//
//	    byte[] contents = // populate pdf data
//
//	    HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
//	    headers.set("Content-Disposition", "inline");
//
//	    return new ResponseEntity<>(contents, headers, HttpStatus.OK);        
//	}

}

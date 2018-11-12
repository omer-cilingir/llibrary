package com.call.application.web.rest;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.call.application.service.base.RequestService;
import com.call.application.storage.StorageFileNotFoundException;
import com.call.application.storage.StorageService;


@RestController
@RequestMapping("/files")
public class FileUploadController {
	
	private final StorageService storageService;
    private final RequestService requestService;

    @Autowired
    public FileUploadController(StorageService storageService,RequestService requestService) {
    	this.requestService = requestService;
        this.storageService = storageService;
        this.storageService.init();
    }
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<String>> listUploadedFiles() throws IOException {
    	return ResponseEntity
    			.ok()
    			.body(this.storageService
    					.loadAll()
    					.map(path -> path.getFileName().toString())
    					.collect(Collectors.toList()));
    	
    }
    @CrossOrigin
    @GetMapping("/download/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveCakeOrderImage(@PathVariable String filename) {
 
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }
    @CrossOrigin
    @PostMapping("/upload/{id}")
    public ResponseEntity<String> handleImageUpload(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
        
         //LOGGER.info("Storing cake order image file : {}", filename);
    	
    
 
    	//String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    	
    	String filename = new Date().getTime() + "";
    	
        filename = this.storageService.store(filename, file);
 
         //LOGGER.info("Stored cake order image file : {}", filename);
        
         Map<String, Object> updateValues = new HashMap<>();
         updateValues.put("fileUrl", filename);
        
         this.requestService.update(id, updateValues);
 
        return ResponseEntity.ok().body("SUCCESS");
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}

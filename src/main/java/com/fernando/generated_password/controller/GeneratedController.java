package com.fernando.generated_password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.generated_password.dto.PasswordDto;
import com.fernando.generated_password.service.PasswordService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping("api/password")
public class GeneratedController {
	@Autowired
	private PasswordService passwordService;
	private PasswordDto passwordDto = new PasswordDto();
	@Operation(summary = "Gera um senha forte aleatoria")
	@GetMapping
	public ResponseEntity<String> generatedPassword(){
		return new ResponseEntity<String>(passwordService.generatedPassword(passwordDto,1).getValue(), HttpStatus.OK);
	}
	@Operation(summary = "Verifica se é uma senha forte")
	@GetMapping("/{password}")
	public ResponseEntity<Boolean> verifyPassword(@PathVariable("password") String password){
		passwordDto.setValue(password);
		if(passwordService.verifyPassword(passwordDto)) {
			return new ResponseEntity<Boolean>(passwordDto.getForte(), HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(passwordDto.getForte(), HttpStatus.BAD_REQUEST);
	}
	@Operation(summary = "Cria uma senhha customizada")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description="gera uma senha customizada"),
			@ApiResponse(responseCode = "400", description="Requisição malformada ou erro de sintaxe",
			content=@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,examples=@ExampleObject(value="BAD_REQUEST"))),
			@ApiResponse(responseCode="500",description="Foi gerada uma exceção",
			content=@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,examples=@ExampleObject(value="INTERNAL_SERVER_ERROR")))
	})
	@PostMapping
	public ResponseEntity<String> customizePassword(@RequestBody PasswordDto passwordDto){
		try {
			if(passwordService.customizePassword(passwordDto) == null) {
				return new ResponseEntity<>("All of the options are unable.", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<String>(passwordDto.getValue(),HttpStatus.OK) ;
		} catch (IllegalArgumentException e) {
			 return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}

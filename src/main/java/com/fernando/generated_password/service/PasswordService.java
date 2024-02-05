package com.fernando.generated_password.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.generated_password.dto.PasswordDto;
@Service
public class PasswordService {
	
	private PasswordDto passwordDto = new PasswordDto();
	Random random = new Random();
	private char randomChar() {
		char caracter =(char) (random.nextInt(26) + 97);
		return caracter;
	}
	private int randomNumber() {
		return random.nextInt(10);
	}
	private char randomSpecial() {
		char caracter =(char) (random.nextInt(14) + '!');
		return caracter;
	}
	
	public PasswordDto generatedPassword(PasswordDto passwordDto,int type) {
		StringBuilder password = new StringBuilder();
		if(type==1) {
			for(int i=0;i<passwordDto.getLength1();i++) {
				if(i==1) {
					password.append((char)(randomChar()-30));
				}
				if(i>1&&i<6) {
					password.append(randomChar());
				}
				if(i==6) {
					password.append(randomNumber());
				}else{
					password.append(randomSpecial());
				}
			
			  }
		 }
		if(type==2) {
			for(int i=0;i<passwordDto.getLength1();i++) {
				if(i==1) {
					password.append((char)(randomChar()-30));
				}
				if(i>1&&i<6) {
					password.append(randomChar());
				}
				if(i==6) {
					password.append((char)(randomChar()-30));
				}else {
					password.append((char)(randomChar()-30));
				}
			
			  }
		 }
		if(type==3) {
			for(int i=0;i<passwordDto.getLength1();i++) {
				if(i==1) {
					password.append(randomSpecial());
				}
				if(i>1&&i<6) {
					password.append(randomChar());
				}
				if(i==6) {
					
				}else{
					password.append(randomSpecial());
				}
			
			  }
		 }
		if(type==4) {
			for(int i=0;i<passwordDto.getLength1();i++) {
				if(i==1) {
					password.append((char)(randomChar()-30));
				}
				if(i>1&&i<6) {
					password.append(randomSpecial());
				}
				if(i==6) {
					password.append((char)(randomChar()-30));
				}else{
					password.append(randomSpecial());
				}
			
			  }
		 }
		if(type==5) {
			for(int i=0;i<passwordDto.getLength1();i++) {
					password.append(randomChar());
			}
		}	
		if(type==6) {
			for(int i=0;i<passwordDto.getLength1();i++) {
				password.append((char)(randomChar()-30));
			}
		 }
		if(type==7) {
			for(int i=0;i<passwordDto.getLength1();i++) {
				password.append(randomSpecial());
			}
		 }
		passwordDto.setValue(shufflePassword(password.toString()));
		return passwordDto;
	}
	
	public boolean verifyPassword(PasswordDto passwordDto) {
		boolean lowerCase=false;
		boolean upperCase=false;
		boolean special=false;
		boolean length1 = false;
		int i = 0;
		for(char caracter: passwordDto.getValue().toCharArray()) {
			i++;
			if(limits(97,122,(int)caracter)) {
				passwordDto.setLowerCase(true);
			}
			if(limits(65,90,(int)caracter)) {
				passwordDto.setUpperCase(true);
			}
			if(limits(33,47,(int)caracter) | limits(58,64,(int)caracter) |limits(91,96,(int)caracter) | limits(123,126,(int)caracter)) {
				passwordDto.setSpecial(true);
			}
			
		}
		if(i>=8){
			length1=true;
		}
		if(passwordDto.getLowerCase() && passwordDto.getUpperCase() && passwordDto.getSpecial()) {
			passwordDto.setForte(true);
			return true;
		}else {passwordDto.setForte(false);return false;}
	}
	private boolean limits(int lower,int above,int value) {
		if(value>=lower && value<=above) {
			return true;
		}
		return false;
	}
	
	public PasswordDto customizePassword(PasswordDto passwordDto) throws IllegalArgumentException{
		if(passwordDto.getLength1()<8) {
			 throw new IllegalArgumentException("Senha menor que 8 nao é permitido");
		}
		String value =  new String();
		if(passwordDto.getLowerCase() && passwordDto.getUpperCase() && passwordDto.getSpecial()) {
			return generatedPassword(passwordDto,1);
		}
		if(passwordDto.getLowerCase() && passwordDto.getUpperCase() ) {
			return generatedPassword(passwordDto,2);
		}
		if(passwordDto.getLowerCase() && passwordDto.getSpecial()) {
			return generatedPassword(passwordDto,3);	
		}
		if(passwordDto.getUpperCase()  && passwordDto.getSpecial()) {
			return generatedPassword(passwordDto,4);
		}
		if(passwordDto.getLowerCase()) {
			return generatedPassword(passwordDto,5);
		}
		if(passwordDto.getUpperCase() ) {
			return generatedPassword(passwordDto,6);	
		}
		if(passwordDto.getSpecial()) {
			return generatedPassword(passwordDto,7);
		}
		
		return null;
	}
	
	private String shufflePassword(String password) {
		List<Character> caracteres = new ArrayList<>();
        for (char c : password.toCharArray()) {
            caracteres.add(c);
        }
        Collections.shuffle(caracteres);
        StringBuilder result = new StringBuilder();
        for (char c : caracteres) {
            result.append(c);
        }
        return result.toString();
	}
}


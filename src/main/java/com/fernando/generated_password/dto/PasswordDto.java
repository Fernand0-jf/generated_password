package com.fernando.generated_password.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
public class PasswordDto {
	 @Schema(description = "Password with lowerCase letters", example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
	private Boolean lowerCase=null;
	 @Schema(description = "Password with upperCase letters", example = "false", requiredMode = Schema.RequiredMode.REQUIRED)
	private Boolean upperCase=null;
	 @Schema(description = "Password with special caracters", example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
	private Boolean special=null;
	 @Schema(description = "Password length", example = "10", requiredMode = Schema.RequiredMode.REQUIRED)
	private int  length1 = 8;
	 @Schema(description = "Password", example = "", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String value = null;
	 @Schema(description = "Password Status", example = "", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Boolean forte = null;
	
}

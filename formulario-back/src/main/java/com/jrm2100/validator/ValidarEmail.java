package com.jrm2100.validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidarEmail {
    public static void validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O e-mail não pode ser vazio");
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("E-mail inválido. Formato esperado: nome@dominio.com");
        }

        if (email.length() > 255) {
            throw new IllegalArgumentException("O e-mail não pode ter mais de 255 caracteres");
        }

        String domain = email.substring(email.indexOf('@') + 1);
        if (domain.indexOf('.') == -1) {
            throw new IllegalArgumentException("O domínio do e-mail é inválido");
        }
        if (domain.equals("example.com")) {
            throw new IllegalArgumentException("Domínio example.com não é permitido");
        }
    }
}
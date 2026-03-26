package com.cveradar.cveradar.utils.exceptions;

public class EmailJaCadastradoException extends RuntimeException {
    public EmailJaCadastradoException(String email) {
        super("O email "+ email + " ja está cadastrado!");
    }
}

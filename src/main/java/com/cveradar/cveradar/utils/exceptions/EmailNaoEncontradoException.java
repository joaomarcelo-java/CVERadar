package com.cveradar.cveradar.utils.exceptions;

public class EmailNaoEncontradoException extends RuntimeException {
    public EmailNaoEncontradoException(String email) {
        super("O email "+ email +" não foi encontrado no banco de dados.");
    }
}

package com.cveradar.cveradar.utils.exceptions;

public class SoftwareNaoEncontradoException extends RuntimeException {
    public SoftwareNaoEncontradoException(String email) {
        super("O software "+ email +" não foi encontrado");
    }
}

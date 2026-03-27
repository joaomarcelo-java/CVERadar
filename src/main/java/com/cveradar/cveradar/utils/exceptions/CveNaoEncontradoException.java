package com.cveradar.cveradar.utils.exceptions;

public class CveNaoEncontradoException extends RuntimeException {
    public CveNaoEncontradoException(String cveId) {
        super("O CVE de id "+ cveId +" não foi encontrado.");
    }
}

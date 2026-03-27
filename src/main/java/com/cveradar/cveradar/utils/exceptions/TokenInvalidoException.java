package com.cveradar.cveradar.utils.exceptions;

import java.util.UUID;

public class TokenInvalidoException extends RuntimeException {
    public TokenInvalidoException(UUID token) {
        super("O token "+ token +" é inválido.");
    }
}

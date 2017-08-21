package br.com.cassioliveira.sigeris.exceptions;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

}

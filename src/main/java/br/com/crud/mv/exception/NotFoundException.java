package br.com.crud.mv.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    public NotFoundException(){
        super("Não encontrado");
    }
}

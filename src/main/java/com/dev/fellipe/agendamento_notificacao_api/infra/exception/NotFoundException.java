package com.dev.fellipe.agendamento_notificacao_api.infra.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) { super(message); }
}

package com.dev.fellipe.agendamento_notificacao_api.controller;

import com.dev.fellipe.agendamento_notificacao_api.business.AgendamentoService;
import com.dev.fellipe.agendamento_notificacao_api.controller.dto.in.AgendamentoRecord;
import com.dev.fellipe.agendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoRecordOut> gravarAgentamentos(@RequestBody AgendamentoRecord agendamentoRecord) {

        var agendamentoGravado = agendamentoService.gravarAgendamento(agendamentoRecord);

        return ResponseEntity.ok(agendamentoGravado);
    }
}

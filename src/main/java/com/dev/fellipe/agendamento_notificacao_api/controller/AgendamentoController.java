package com.dev.fellipe.agendamento_notificacao_api.controller;

import com.dev.fellipe.agendamento_notificacao_api.business.AgendamentoService;
import com.dev.fellipe.agendamento_notificacao_api.controller.dto.in.AgendamentoRecord;
import com.dev.fellipe.agendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoRecordOut> buscarAgendamentoPorId(@PathVariable("id") Long id) {

        var agendamento = agendamentoService.buscarAgendamentoPorId(id);

        return ResponseEntity.ok(agendamento);
    }
}

package com.dev.fellipe.agendamento_notificacao_api.business;

import com.dev.fellipe.agendamento_notificacao_api.business.mapper.IAgendamentoMapper;
import com.dev.fellipe.agendamento_notificacao_api.controller.dto.in.AgendamentoRecord;
import com.dev.fellipe.agendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.dev.fellipe.agendamento_notificacao_api.infra.exception.NotFoundException;
import com.dev.fellipe.agendamento_notificacao_api.infra.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamento) {
        var agendamentoEntity = agendamentoMapper.paraEntity(agendamento);
        return agendamentoMapper.paraOut(repository.save(agendamentoEntity));
    }

    public AgendamentoRecordOut buscarAgendamentoPorId(Long id) {
        return agendamentoMapper.paraOut(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrado")));
    }
}


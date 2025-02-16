package com.dev.fellipe.agendamento_notificacao_api.business;

import com.dev.fellipe.agendamento_notificacao_api.business.mapper.IAgendamentoMapper;
import com.dev.fellipe.agendamento_notificacao_api.controller.dto.in.AgendamentoRecord;
import com.dev.fellipe.agendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.dev.fellipe.agendamento_notificacao_api.infra.entities.Agendamento;
import com.dev.fellipe.agendamento_notificacao_api.infra.enums.StatusNotificacaoEnum;
import com.dev.fellipe.agendamento_notificacao_api.infra.repositories.AgendamentoRepository;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AgendamentoServiceTest {

    @InjectMocks
    private AgendamentoService agendamentoService;

    @Mock
    private AgendamentoRepository agendamentoRepository;

    @Mock
    private IAgendamentoMapper agendamentoMapper;


    private AgendamentoRecord agendamentoRecord;
    private AgendamentoRecordOut agendamentoRecordOut;
    private Agendamento agendamentoEntity;

    @BeforeEach
    void setUp() {

        agendamentoEntity = Agendamento.builder()
                .id(1L)
                .dataHoraEnvio( LocalDateTime.of(2025, 2, 16, 15, 30, 0))
                .emailDestinatario("email@email.com")
                .telefoneDestinatario("55887996578")
                .mensagem("Favor retornar a loja com urgência")
                .dataHoraAgendamento(LocalDateTime.now())
                .build();

        agendamentoRecord = new AgendamentoRecord("email@email.com",
                "53981252831",
                "mensagem teste",
                LocalDateTime.of(2025, 2, 16, 15, 30, 0));

        agendamentoRecordOut = new AgendamentoRecordOut(1L,
                "email@email.com",
                "53981252831",
                "mensagem teste",
                LocalDateTime.of(2025, 2, 16, 15, 30, 0),
                StatusNotificacaoEnum.AGENDADO);
    }

    @Test
    void deveGravarAgendamentoComSucesso() {
        when(agendamentoMapper.paraEntity(agendamentoRecord))
                .thenReturn(agendamentoEntity);

        when(agendamentoRepository.save(agendamentoEntity))
                .thenReturn(agendamentoEntity);

        when(agendamentoMapper.paraOut(agendamentoEntity))
                .thenReturn(agendamentoRecordOut);

        AgendamentoRecordOut out = agendamentoService.gravarAgendamento(agendamentoRecord);

        verify(agendamentoMapper, times(1)).paraEntity(agendamentoRecord);
        verify(agendamentoRepository, times(1)).save(agendamentoEntity);
        verify(agendamentoMapper, times(1)).paraOut(agendamentoEntity);

        assertThat(out).usingRecursiveComparison().isEqualTo(agendamentoRecordOut);
    }
}

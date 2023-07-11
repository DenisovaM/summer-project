package ru.tinkoff.summer.taskmicroservice.application.usecase.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.summer.taskmicroservice.application.port.data.AttemptPort;
import ru.tinkoff.summer.taskmicroservice.application.usecase.ApplyResultUseCase;
import ru.tinkoff.summer.taskshareddomain.TotalExecutionResult;

@Service
@RequiredArgsConstructor
public class ApplyResultUseCaseImpl implements ApplyResultUseCase {
    private final AttemptPort port;
    @Override
    public void apply(TotalExecutionResult result) {
        var attempt = port.getById(result.getAttemptId());
        attempt.setStatus(result.getStatus());
        attempt.setErrorMessage(result.getErrorMessage());
        port.save(attempt);
    }
}

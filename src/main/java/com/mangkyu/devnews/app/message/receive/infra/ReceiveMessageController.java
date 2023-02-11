package com.mangkyu.devnews.app.message.receive.infra;

import com.mangkyu.devnews.app.message.receive.domain.ReceiveMessageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
class ReceiveMessageController {

    private final ReceiveMessageUseCase useCase;

    @PostMapping("/callback")
    public ResponseEntity<Void> receiveMessage(@Valid @RequestBody ReceiveMessageRequest request) {
        useCase.handle(request.toDomain());
        return ResponseEntity.ok().build();
    }

}

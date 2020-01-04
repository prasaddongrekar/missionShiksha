package com.rest.mshala;

import org.springframework.stereotype.Component;

@Component
public interface CommunicationService<S, B, T> {
    boolean sendMessage(S subject, B body, T to);
}

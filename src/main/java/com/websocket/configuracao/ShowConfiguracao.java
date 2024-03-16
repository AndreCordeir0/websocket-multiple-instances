package com.websocket.configuracao;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;


@ApplicationScoped
public class ShowConfiguracao {
    private static final Logger log = Logger.getLogger(ShowConfiguracao.class);
    @ConfigProperty(name = "mp.messaging.incoming.chat-in.group.id")
    String groupId;

    @ConfigProperty(name = "kafka.bootstrap-servers")
    String serverKafka;

    public void start(@Observes StartupEvent ev) {
        log.info("###Environments: ");
        log.info("Kafka Group: " + groupId);
        log.info("Server kafka: " + serverKafka);
    }
}

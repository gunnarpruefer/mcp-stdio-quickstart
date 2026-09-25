package org.acme;

import io.quarkiverse.mcp.server.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class MyPrompts {

    @Inject
    PingService pingService;

    @Prompt(description = "Ping prompt")
    PromptMessage foo(@PromptArg(description = "The name", defaultValue = "Max") String name) {
        return PromptMessage.withUserRole(new TextContent(pingService.ping(name)));
    }

    @Prompt(description = "Multi-message prompt")
    List<PromptMessage> conversationPrompt(String topic) {
        return List.of(
                PromptMessage.withAssistantRole(new TextContent("You are a helpful assistant.")),
                PromptMessage.withUserRole(new TextContent("Tell me about " + topic))
        );
    }

    @Prompt(description = "Prompt with logging")
    PromptMessage loggedPrompt(String input, McpLog log) {
        log.info("Processing prompt with input: %s", input);
        return PromptMessage.withUserRole(new TextContent("Processing: " + input));
    }

}

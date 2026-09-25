package org.acme;

import io.quarkiverse.mcp.server.Prompt;
import io.quarkiverse.mcp.server.PromptArg;
import io.quarkiverse.mcp.server.PromptMessage;
import io.quarkiverse.mcp.server.TextContent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MyPrompts {

    @Inject
    PingService pingService;

    @Prompt(description = "Ping prompt")
    PromptMessage foo(@PromptArg(description = "The name", defaultValue = "Max") String name) {
        return PromptMessage.withUserRole(new TextContent(pingService.ping(name)));
    }

}

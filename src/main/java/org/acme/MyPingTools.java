package org.acme;

import io.quarkiverse.mcp.server.TextContent;
import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;
import io.quarkiverse.mcp.server.ToolResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/// testing features ...
/// [...](https://docs.quarkiverse.io/quarkus-mcp-server/dev/guides-implementing-tools.html)
@ApplicationScoped
public class MyPingTools {

    @Inject
    PingService pingService;

    @Tool(title = "Ping!", name = "advanced ping", description = "Pinging via injected service. And with default values.")
    ToolResponse ping(@ToolArg(description = "The name", defaultValue = "Andy") String name) {
        return ToolResponse.success(
                new TextContent(pingService.ping(name)));
    }}

package org.acme;

import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;
import jakarta.enterprise.context.ApplicationScoped;

/// testing features ...
/// [...](https://docs.quarkiverse.io/quarkus-mcp-server/dev/index.html)
@ApplicationScoped
public class MathTools {

    @Tool(description = "Calculate the sum of two numbers")
    int add(
            @ToolArg(description = "First number") int a,
            @ToolArg(description = "Second number") int b
    ) {
        return a + b;
    }
}

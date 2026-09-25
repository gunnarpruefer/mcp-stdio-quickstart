package org.acme;

import io.quarkiverse.mcp.server.ToolManager;
import io.quarkiverse.mcp.server.ToolResponse;
import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProgrammaticTools {

    @Inject
    ToolManager toolManager;

    @Startup
    void addTool(){
        toolManager.newTool("toLowerCase")
                .setDescription("Converts input string to lower case.")
                .addArgument("value", "Value to convert", true, String.class)
                .setHandler(
                        toolArguments -> ToolResponse.success(
                                toolArguments.args()
                                        .get("value").toString().toLowerCase()))
                .register();
    }
}

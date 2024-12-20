tasks.register("sh") {
    description = "Executes a shell command"
    group = "Custom"
    val commands = project.findProperty("commands") as String?
    exec {
        commandLine("sh", "-c", "\"$commands\"")
        standardOutput = System.out
    }
}

tasks.register("curl") {
    description = "Executes a curl command"
    group = "Custom"
    val curlCommands = project.findProperty("curlCommands") ?: "--help"
    exec {
        commandLine("sh", "-c", "\"curl $curlCommands\"")
        standardOutput = System.out
    }
}
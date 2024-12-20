tasks.register("sh") {
    val commands = project.findProperty("commands") as String?
    exec {
        commandLine("sh", "-c", "\"$commands\"")
        standardOutput = System.out
    }
}

tasks.register("curl") {
    val curlCommands = project.findProperty("curlCommands") ?: "--help"
    exec {
        commandLine("sh", "-c", "\"curl $curlCommands\"")
        standardOutput = System.out
    }
}
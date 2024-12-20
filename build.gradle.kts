tasks.register("curl") {
    val curlCommands = project.findProperty("curlCommands") ?: "--help"
    exec {
        commandLine("sh", "-c", "\"curl $curlCommands\"")
        standardOutput = System.out
    }
}
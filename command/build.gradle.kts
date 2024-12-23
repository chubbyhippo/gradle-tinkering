import java.io.BufferedReader
import java.io.InputStreamReader

tasks.register("sh") {
    description = "Executes a shell command"
    group = "Custom"

    doLast {
        val commands = project.providers.gradleProperty("commands").get()
        try {
            // Create and start the process
            val process = ProcessBuilder(*commands.split(" ").toTypedArray())
                .redirectErrorStream(true) // Redirects error stream to output stream
                .start()

            // Capture output
            val reader = BufferedReader(InputStreamReader(process.inputStream))
            reader.useLines { lines -> lines.forEach { println(it) } }

            // Wait for the process to terminate and get exit code
            val exitCode = process.waitFor()
            println("Exit code: $exitCode")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
package org.hypejet.bakka

interface AmogusServer {
    fun stopCleanly() {
        AmogusServerImpl.INSTANCE.modules.forEach { it.disable() }
        AmogusServerImpl.serverProcess.stop()
    }
}
package org.hypejet.bakka

class ServerProcess {
    fun start(port: Int, address: String) {
        AmogusServerImpl.INSTANCE.modules.forEach { it.start() }
    }

    fun stop() {
        AmogusServerImpl.INSTANCE.modules.forEach { it.stop() }
    }
}
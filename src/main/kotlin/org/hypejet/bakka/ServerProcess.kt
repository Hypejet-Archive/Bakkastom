package org.hypejet.bakka

import java.net.SocketAddress

class ServerProcess {
    fun start(address: SocketAddress) {
        AmogusServer.modules.forEach { it.start() }
    }

    fun stop() {
        AmogusServer.modules.forEach { it.stop() }
    }
}
package org.hypejet.bakka

import org.hypejet.bakka.event.GlobalEventHandler
import org.hypejet.bakka.module.SussyModule
import java.net.InetSocketAddress
import java.net.SocketAddress
import kotlin.properties.Delegates

object AmogusServer {

    const val DEFAULT_ADDRESS = "0.0.0.0"
    const val DEFAULT_PORT = 443

    val modules = ArrayList<SussyModule>()

    lateinit var globalEventHandler: GlobalEventHandler
        private set

    lateinit var serverProcess: ServerProcess
        private set

    fun init() {
        globalEventHandler = GlobalEventHandler()
        modules.forEach { it.enable() }

        serverProcess = ServerProcess()
    }

    fun start(socketAddress: SocketAddress) {
        serverProcess.start(socketAddress)
    }

    fun start(address: String, port: Int) {
        start(InetSocketAddress(address, port))
    }

    fun stopCleanly() {
        modules.forEach { it.disable() }
        serverProcess.stop()
    }
}
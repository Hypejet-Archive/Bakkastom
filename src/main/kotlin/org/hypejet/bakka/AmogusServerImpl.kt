package org.hypejet.bakka

import org.hypejet.bakka.module.SussyModule
import kotlin.properties.Delegates
import kotlin.reflect.KClass

class AmogusServerImpl(address: String, port: Int, val modules: List<SussyModule>) : AmogusServer {

    companion object {
        private const val DEFAULT_ADDRESS = "0.0.0.0"
        private const val DEFAULT_PORT = 443

        lateinit var serverProcess: ServerProcess
            private set

        var PRODUCTION by Delegates.notNull<Boolean>()
            private set
        lateinit var INSTANCE: AmogusServerImpl
            private set
    }

    init {
        INSTANCE = this

        // Call enable function in modules
        modules.forEach { it.enable() }
        serverProcess = ServerProcess()
    }

    @Suppress("unused")
    class Builder {
        private var address = DEFAULT_ADDRESS
        private var port = DEFAULT_PORT

        private val modules = ArrayList<SussyModule>()

        private var production = false

        fun address(address: String) : Builder {
            this.address = address
            return this
        }

        fun port(port: Int) : Builder {
            this.port = port
            return this
        }

        fun module(module: SussyModule) : Builder {
            this.modules.add(module)
            return this
        }

        fun unmodule(module: KClass<out SussyModule>) : Builder {
            this.modules.removeAll { it.javaClass == module.java }
            return this
        }

        fun production() : Builder {
            this.production = true
            return this
        }

        fun commonModules() : Builder {
            return this
        }

        fun build() : AmogusServerImpl {
            PRODUCTION = this.production
            return AmogusServerImpl(
                this.address,
                this.port,
                this.modules
            )
        }
    }
}
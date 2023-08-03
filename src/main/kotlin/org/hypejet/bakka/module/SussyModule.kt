package org.hypejet.bakka.module

import org.hypejet.platform.Module
import java.nio.file.Path

abstract class SussyModule(private val name: String) : Module() {
    override val dataDirectory: Path
        get() = Path.of("modules", this.name)

    override fun disable() {}
    override fun enable() {}
    open fun stop() {}
    open fun start() {}
}
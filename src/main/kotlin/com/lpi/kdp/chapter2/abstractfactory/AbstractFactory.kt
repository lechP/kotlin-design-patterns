package com.lpi.kdp.chapter2.abstractfactory

interface Property {
    val name: String
    val value: Any
}

interface ServerConfiguration {
    val properties: List<Property>
}

data class PropertyImpl(
    override val name: String,
    override val value: Any
) : Property

data class ServerConfigurationImpl(
    override val properties: List<Property>
) : ServerConfiguration

// factory method
// not efficient because we lost information about type of property
fun property(prop: String): Property {
    val (name, value) = prop.split(":")
    return when (name) {
        "port" -> PropertyImpl(name, value.trim().toInt())
        "environment" -> PropertyImpl(name, value.trim())
        else -> throw RuntimeException("Unknown property: $name")
    }
}

data class IntProperty(
    override val name: String,
    override val value: Int
) : Property

data class StringProperty(
    override val name: String,
    override val value: String
) : Property

// improved factory but still not what we need
fun property2(prop: String): Property {
    val (name, value) = prop.split(":")
    return when (name) {
        "port" -> IntProperty(name, value.trim().toInt())
        "environment" -> StringProperty(name, value.trim())
        else -> throw RuntimeException("Unknown property: $name")
    }
}

fun main() {
    val portProperty = property("port: 8080")
    val environmentProperty = property("environment: production")

    // information about Int is lost, we have to cast it explicitly
    val port: Int = portProperty.value as Int

    val portProperty2 = property2("port: 8080")
    // cast is still required
    val port2: Int = (portProperty2 as IntProperty).value
    // or smart cast
    if (portProperty2 is IntProperty) {
        val port3: Int = portProperty2.value
    }
}

class Parser {
    companion object {
        fun property(prop: String): Property {
            val (name, value) = prop.split(":")
            return when (name) {
                "port" -> IntProperty(name, value.trim().toInt())
                "environment" -> StringProperty(name, value.trim())
                else -> throw RuntimeException("Unknown property: $name")
            }
        }

        fun server(propertyStrings: List<String>): ServerConfiguration =
            ServerConfigurationImpl(
                properties = propertyStrings.map { property(it) }
            )
    }
}
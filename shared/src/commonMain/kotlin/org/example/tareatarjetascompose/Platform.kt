package org.example.tareatarjetascompose

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
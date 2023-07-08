package org.anasoid.jmeter.cloud.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JmeterCloudAppApplication

fun main(args: Array<String>) {
	runApplication<JmeterCloudAppApplication>(*args)
}

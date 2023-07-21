package org.anasoid.jmeter.cloud.api.rest.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("\${openapi.jmeterCloudClient.base-path:/app}")
class PublicHomeController {


    @GetMapping("/")
    fun home(): String {
        return "public home"
    }
}
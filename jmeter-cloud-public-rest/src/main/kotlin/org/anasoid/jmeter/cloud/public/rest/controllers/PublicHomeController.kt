package org.anasoid.jmeter.cloud.public.rest.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/app")
class PublicHomeController {


    @GetMapping("/")
    fun home(): String {
        return "public home"
    }
}
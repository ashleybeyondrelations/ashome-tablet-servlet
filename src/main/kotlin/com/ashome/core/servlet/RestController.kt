package com.ashome.core.servlet.controller

import com.ashome.core.servlet.InternalStatic
import com.ashome.tablet.gesture.model.AhGestureRecorder
import com.ashome.tablet.model.AhTabletInput
import com.ashome.tablet.model.AhTabletInputType
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

internal open class InternalREST( url : String) {
    companion object {
        private val logger = KotlinLogging.logger {}
    }

    init {

    }



    @GetMapping("/keyEvent")
    fun keyEvent(@RequestParam(value = "key") key : String,
                 @RequestParam(value = "state") state : Boolean
    ) {
        logger.info { "saw  $key to $state" }

        InternalStatic.tablet.getButtonByKey(key)?.triggerStateChange(state)
    }


}

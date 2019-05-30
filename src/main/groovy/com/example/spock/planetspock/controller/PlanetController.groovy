package com.example.spock.planetspock.controller

import com.example.spock.planetspock.model.Planet
import com.example.spock.planetspock.serviece.PlanetService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.View
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
class PlanetController {
    private final PlanetService planetService
    PlanetController(PlanetService pService) {
        this.planetService = pService
    }
    @RequestMapping(
            value = "/planets/{planetName}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Planet retrieve(@PathVariable("planetName") String name) {
        return this.planetService.findOneByName(name)
    }

    @GetMapping("/redirectWithRedirectView")
        public RedirectView redirectWithUsingRedirectView(
            RedirectAttributes attributes) {
            attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
            attributes.addAttribute("attribute", "redirectWithRedirectView");
            return new RedirectView("redirectedUrl");
        }
    @PostMapping("/redirectPostToPost")
    public ModelAndView redirectPostToPost(HttpServletRequest request) {
        request.setAttribute(
                View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT)
        return new ModelAndView("redirect:/redirectedPostToPost");
    }
    @PostMapping("/redirectedPostToPost")
    public ModelAndView redirectedPostToPost() {
        return new ModelAndView("redirection");
    }

}

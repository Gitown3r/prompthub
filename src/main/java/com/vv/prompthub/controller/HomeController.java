package com.vv.prompthub.controller;

import com.vv.prompthub.entity.Prompt;
import com.vv.prompthub.repository.PromptRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final PromptRepository promptRepository;

    public HomeController(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (promptRepository.count() == 0) {
            promptRepository.save(new Prompt(
                    "Neon Cyberpunk City",
                    "A futuristic neon-lit cyberpunk cityscape at night with flying cars, holographic billboards...",
                    "Draw a highly detailed futuristic city at night, neon lights, 8k resolution, photorealistic, flying cars, rain, reflections.",
                    "neon",
                    "Design,Concept,Sci-Fi",
                    "/img/Cyberpunk.png"
            ));
            promptRepository.save(new Prompt(
                    "React Code Reviewer",
                    "You are an expert React developer. Review the following code for best practices...",
                    "Act as a Senior React Developer. I will provide you with a code snippet. Please review it for best practices, performance bottlenecks, and security issues.",
                    "react",
                    "Frontend,React,Code",
                    "/img/fluid_art.png"
            ));
            promptRepository.save(new Prompt(
                    "Surreal Dreamscape",
                    "Ethereal surreal landscape with floating islands, impossible geometry...",
                    "Ethereal surreal landscape with floating islands, impossible geometry, dreamlike atmosphere, soft lighting, 8k, Unreal Engine 5 render.",
                    "surreal",
                    "Fantasy,Surreal,Art",
                    "/img/dreamscape.png"
            ));
        }
        List<Prompt> allPrompts = promptRepository.findAll();

        model.addAttribute("prompts", allPrompts);

        return "index";
    }
}

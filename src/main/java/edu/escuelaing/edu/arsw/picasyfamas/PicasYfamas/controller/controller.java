package edu.escuelaing.edu.arsw.picasyfamas.PicasYfamas.controller;

import edu.escuelaing.edu.arsw.picasyfamas.PicasYfamas.logica.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class controller {
    
        private List<String> attempts= new ArrayList<>();
        int picas;
        int famas;
        int random;
        String num;
        Game game = new Game();
        
        public controller(){
            picas = 0;
            famas = 0;
            num = null;
            random = (int)(10000 * Math.random());
            System.out.println(random);
        }
        
        @GetMapping("/game")
	public String print(Model model) {
		model.addAttribute("picas",game.getPicas());
                model.addAttribute("famas",game.getFamas());
                model.addAttribute("random",game.getRandom());                
                model.addAttribute("attempts",game.getAttempts());
		return "game";
	}
        @PostMapping("/game")
        public String jugar(String currentAttempt) {
            attempts.add(currentAttempt);
            this.num = currentAttempt;
            this.picas = game.getPicas();
            this.famas = game.getFamas();
            this.attempts = game.getAttempts();
            game.calc(num);
            return "redirect:/game";
        }
        @RequestMapping(value = "/game", method = RequestMethod.POST, params = {"reset"})
        public String reiniciar() {
            game.reiniciar();
            return "redirect:/game";
        }
        
        
}

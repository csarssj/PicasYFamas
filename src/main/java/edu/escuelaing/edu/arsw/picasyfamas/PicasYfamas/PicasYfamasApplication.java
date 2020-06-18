package edu.escuelaing.edu.arsw.picasyfamas.PicasYfamas;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@Controller
public class PicasYfamasApplication {
    
        private List<String> attempts= new ArrayList<>();
        int picas;
        int famas;
        int random;
        String num;
        
        public PicasYfamasApplication(){
            picas = 0;
            famas = 0;
            num = null;
            random = (int)(10000 * Math.random());
            System.out.println(random);
        }
	public static void main(String[] args) {
		SpringApplication.run(PicasYfamasApplication.class, args);
	}
        @GetMapping("/game")
	public String print(Model model) {
		model.addAttribute("picas",picas);
                model.addAttribute("famas",famas);
                model.addAttribute("random",random);                
                model.addAttribute("attempts", attempts);
		return "game";
	}
        @PostMapping("/game")
        public String jugar(String currentAttempt) {
            attempts.add(currentAttempt);
            num = currentAttempt;
            calc();
            return "redirect:/game";
        }
        @RequestMapping(value = "/game", method = RequestMethod.POST, params = {"reset"})
        public String reiniciar() {
            attempts.clear();
            famas = 0;picas=0;
            random = (int)(10000 * Math.random());
            return "redirect:/game";
        }
        public void calc(){
            famas = 0;picas=0;
            String ram = Integer.toString(random); 
                for( int i = 0; i < num.length();i++){
                    int pos = ram.indexOf(num.charAt(i));
                    if(pos >=0){
                        if(pos == i){
                            famas++;
                        }else{
                            picas++;
                        }
                    }
                }
        }
}

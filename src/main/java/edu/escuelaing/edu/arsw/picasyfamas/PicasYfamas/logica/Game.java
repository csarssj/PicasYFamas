package edu.escuelaing.edu.arsw.picasyfamas.PicasYfamas.logica;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
public class Game {
    
        private List<String> attempts= new ArrayList<>();
        int picas;
        int famas;
        int random;
        String num;
        
        public Game(){
            picas = 0;
            famas = 0;
            num = null;
            random = (int)(10000 * Math.random());
            System.out.println(random);
        }


        public void reiniciar() {
            attempts.clear();
            famas = 0;picas=0;
            random = (int)(10000 * Math.random());
        }
        public void calc(String num){
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
        public int getFamas() {
            return famas;
        }
        public int getPicas() {
            return picas;
        }
        
        public String getNumero() {
            return num;
        }
        public int getRandom() {
            return random;
        }

        public List<String> getAttempts() {
            return attempts;
        }

 
}

package painel_atendimento.painel_atendimento;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/local")
public class teste {
        @GetMapping("/")
        public String testemap(){
            return "Teste deu certoooooooooooo";
        }
}

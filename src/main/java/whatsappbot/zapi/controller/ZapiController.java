package whatsappbot.zapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import whatsappbot.zapi.service.ZapiService;

@RestController
public class ZapiController {

    private final ZapiService zapiService;

    public ZapiController(ZapiService zapiService) {
        this.zapiService = zapiService;
    }

    @GetMapping("/teste")
    public String enviarMensagemDeTeste() {
        String numero = "5511913613885"; // número de teste
        String mensagem = "👋 Olá! Este é um teste de envio automático usando Z-API + Java + Spring Boot!\n" +
                "TOMA SUA SAFADA, TOMA TOMA TOMAAAA" +
                "\n" +
                "TEM QUE PAGAAAAAR PARA ENVIAR MENSAGEEEMMMM AUTOMATICA NO ZAP ZAP, NÃO DA MAIS PRA USAR NADA GRATIS NESSA PORRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

        zapiService.enviarMensagem(numero, mensagem);
        return "Mensagem enviada para " + numero;
    }
}

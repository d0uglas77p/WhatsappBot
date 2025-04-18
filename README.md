## WhatsAppBot API

Este projeto é uma API que permite enviar mensagens automatizadas via WhatsApp utilizando a Z-API, Spring Boot e Java. Ele oferece um endpoint simples para enviar mensagens para um número de teste do WhatsApp. Ideal para automação de comunicação no WhatsApp.

    Tecnologias Usadas: Java, Spring Boot, Z-API.

    Funcionalidade: Envio automático de mensagens via WhatsApp com autenticação Z-API.

    Endpoint: /teste para enviar mensagem de teste.
    
#

#### Obs: 
A Z-API oferece um teste gratuito limitado para o envio de mensagens automatizadas no WhatsApp. No entanto, para utilizar a API de forma contínua e sem limitações, é necessário adquirir um plano pago. O uso da API está sujeito a tarifas conforme o plano escolhido, e os usuários devem se registrar na Z-API para obter um token de autenticação válido e acesso completo à plataforma.

#

### Passo a Passo

1. Pré-requisitos

        Java 8 ou superior instalado.

        Maven ou Gradle para gerenciamento de dependências.

        Conta na Z-API (com um token de autenticação válido e instanceId).

        Spring Boot configurado no seu ambiente.

3. Configuração da Z-API

    Criar uma conta na Z-API. Registre-se para obter um token e o instanceId.

    Vá em Segurança > Ativar o Token de segurança da conta 

    Adicione suas credenciais no arquivo application.properties: Abra o arquivo src/main/resources/application.properties e adicione suas credenciais da Z-API:

    zapi.token=SEU_TOKEN_AQUI
    zapi.instanceId=SEU_INSTANCE_ID_AQUI

        Substitua SEU_TOKEN_AQUI pelo token gerado na Z-API.

        Substitua SEU_INSTANCE_ID_AQUI pelo instanceId fornecido na Z-API.

5. Configuração do número de telefone

    O número de telefone de destino (número de teste ou do administrador do grupo) deve ser configurado no código.

        Abra o arquivo src/main/java/whatsappbot/zapi/controller/ZapiController.java.

        Altere o número de telefone no método enviarMensagemDeTeste() para o número de teste desejado:

        String numero = "5511977430273"; // número de teste

6. Testando o Envio de Mensagem

    Com o projeto rodando, acessar o endpoint:

        http://localhost:8080/teste

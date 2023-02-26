### Desenvolva uma aplicação cliente/servidor multithread, com TCP ou UDP, para simular a comunicação de processos em uma topologia em estrela. Considere quatro processos. O fluxo de mensagens deve seguir o seguinte modelo:

* O elemento central dessa aplicação é o processo P1.
* P2, P3 e P4 devem estar conectados a P1. Então, todas as mensagens entre os processos P2, P3 e P4 devem passar por P1.
* Essa aplicação suporta duas operações:
  * Unicast: emissor enviar mensagem diretamente a um receptor específico.
  * Broadcast: emissor envia mensagem para todos os receptores ativos. 
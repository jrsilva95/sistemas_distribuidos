### Desenvolva uma aplicação cliente/servidor multithread, com UDP, para simular a comunicação de processos em uma topologia em anel. Considere quatro processos chamados de P1, P2, P3 e P4. Considere o seguinte esquema:

* P1 deve estar conectado a P2 e P4;
* P2 deve estar conectado a P1 e P3;
* P3 deve estar conectado a P2 e P4;
* P4 deve estar conectado a P3 e P1.

#### Observações:
* As mensagens podem ser enviadas por qualquer processo. A ideia é que elas circulem no anel de processos. Ou seja, se P1 enviar uma mensagem, ela deve passar por todos os processos do anel até chegar novamente em P1.
  * Você pode definir o sentido das mensagens (horário ou anti-horário).
* Basicamente, uma operação deve ser feita no anel:
  * Um processo deve enviar sei id.
  * Cada processo, ao receber a mensagem, deve avaliar duas situações:
    * Se o seu id for par, ele deve multiplicar o número recebido por 2, anexar o resultado em uma nova mensagem contendo o id do processo e o número gerado. Exemplo: P2 recebeu o valor 1. Então, a mensagem que P2 vai enviar para P3 é: [2 – 2].
    * Se o seu id for ímpar, ele deve apenas repassar o número recebido, anexar o resultado em uma nova mensagem contendo o id do processo e o número gerado. Exemplo: P3 ao receber a mensagem de P2, vai criar uma nova mensagem contendo [3 – 2] e enviará para P4.
    * Para entradas de outros tipos, o programa deve imprimir “Não é possível operar com esse tipo de dado. Tente outra vez!”.
  * Cada processo deve armazenar e imprimir na tela um log de mensagens recebidas e enviadas.
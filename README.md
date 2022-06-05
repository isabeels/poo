<h1 align="center">Sistema Bancário</h1>

<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge"/>
</p>

### Sobre
Projeto desenvolvido para a disciplina Programação Orientada a Objetos da residência em TIC/Software do SERRATEC. O objetivo foi promover o desenvolvimento de um pequeno sistema bancário utilizando os tópicos apresentados e desenvolvidos na disciplina.

### 🛠 Tecnologias

   <a href="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"  alt="Java" />
  </a>
   <a href="https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white">
    <img src="https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white"  alt="Eclipse" />
  </a>
  
---

### ✔️ Requisitos Mínimos:

- [x] O sistema deverá ter as seguintes classes obrigatoriamente:
<dl>
  <dt> ● Cliente </dt>
  <dt> ● Conta </dt>
  <dt> ● Conta Corrente </dt>
  <dt> ● Conta Poupança </dt>
  <dt> ● Funcionário </dt>
  <dd> ○ Gerente</dd>
  <dd>○ Diretor</dd>
  <dd>○ Presidente</dd>
  <dt> ● Sistema Interno (classe main) </dt>
</dl>

---

### Características de Funcionamento

Este sistema será executado como um menu interativo no console.  É esperado que o sistema seja populado com os valores
referentes aos clientes, contas e funcionários através da leitura de um arquivo de texto.

---

### Passos de Execução

- [x] No menu inicial o usuário deverá fornecer seu CPF e senha para logar. O sistema deve ser capaz de identificar, no momento do login se o usuário é um Cliente
(6 contas correntes e 6 contas poupança), Gerente (4), Diretor (2) ou Presidente (1).<br>
- [x] Caso o usuário seja um Cliente, o sistema fornecerá um menu com opções de :

<ol>
  <li> Movimentações na Conta </li>
  <ol type= a>
<li> Saque</li>
<li> Depósito</li>
<li>Transferência para outra conta</li>
  </ol>
  
  <li>Relatórios</li>
  <ol type= a>
<li>Saldo. O sistema deverá imprimir o saldo na tela do terminal;</li>
<li>Relatório de tributação da conta corrente</li>
  <ol type= I>
  <li>O relatório de tributação deverá apresentar o total gasto nas operações até o momento do relatório.</li>
<li> Adicionalmente deverão ser informados os valores que o banco cobra por cada operação bancária;</li>
<li> Para cada saque será cobrado o valor de R$0.10 (dez centavos);</li>
<li> Para cada depósito será cobrado o valor de R$0.10 (dez centavos);</li>
<li>Para cada transferência será cobrado o valor de R$0.20 (dez centavos) que deverá ser cobrado apenas do remetente;</li>
  </ol>
  <li> Relatório de Rendimento da poupança </li>
  <ol type= I>
<li> Retorna uma simulação do valor de rendimento da poupança no prazo informado. Neste caso o cliente deverá informar o valor em dinheiro e a quantidade de dias que pretende simular. O sistema deverá informar o rendimento desse dinheiro para o prazo informado;</li>
  </ol>
  </ol>
  </ol>

- [x] Caso o usuário seja um Funcionário no cargo de Gerente o sistema fornecerá um menu com opções de:
<ol>
<li>Relatórios</li>
  <ol type = a>
 <li>Relatório do número contas na mesma agência em que este gerente trabalha</li>
  </ol>
  </ol>

- [x] Caso o usuário seja um Funcionário no cargo de Diretor o sistema fornecerá um menu com todas as opções anteriores (caso 2), adicionando :
<ol>
<li>Relatórios</li>
  <ol type = a>
 <li>Relatório com as informações de Nome, CPF e Agência de todos os clientes do sistema em ordem alfabética</li>
  </ol>
  </ol>
  
- [x] Por fim, caso o usuário acessando o sistema seja um Funcionário no cargo de Presidente o sistema fornecerá um menu com todas as opções anteriores (caso 2 e caso 3), adicionando:

<ol>
<li>Relatórios</li>
  <ol type = a>
 <li>Relatório com o valor total do capital armazenado no banco.
</li>
  </ol>
  </ol>
  
---

### Restrições:
  
- Toda operação bancária (Saque, depósito e transferência) deverá ser registrada em um arquivo de texto de saída que armazena as operações realizadas durante aquela execução do sistema;
- Todo relatório gerado deve ser registrado em um arquivo texto de saída individual;
- O sistema deve realizar ao menos um tratamento de erros personalizado.
  
<br>
<br>
 <p align="center">
desenvolvido por • <a href="https://www.linkedin.com/in/isabelsantana2811/">Isabel Sant' Ana</a> •
<a href="https://www.linkedin.com/in/rosana-dantas-a1706910b/">Rosana Dantas</a> •
<a href="https://www.linkedin.com/in/vin%C3%ADcius-soares-43238b144/">Vinicius Soares</a> •
<a href="https://www.linkedin.com/in/gabriel-theophilo-32053a110/">Gabriel Theophilo</a> •
</p>


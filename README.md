# MJVProjetoWeb
Projeto criado para o processo seletivo de desenvolvedores Back-end da MJV.

Infelizmente, não consegui concluir o projeto à tempo, mas segue aqui até onde consegui chegar.

### Pré-requisitos

Eis o que é necessário para fazer o projeto rodar normalmente (todos os links estão disponíveis no final do texto).


* IDE Eclipse e Kit de Desenvolvimento Java ([Tutorial de Instalação](http://www.matera.com/blog/post/tutorial-instalacao-do-java-jdk-e-eclipse-no-windows))
* Servidor Tomcat ([Tutorial de Instalação](http://www.mhavila.com.br/topicos/java/tomcat.html#t02))
* Banco de Dados MySQL ([Tutorial de Instalação](https://www.devmedia.com.br/instalando-e-configurando-a-nova-versao-do-mysql/25813))


### Instalação do Projeto

Segue como acessar o projeto através da IDE do Eclipse:

1. Após criar uma workspace em algum lugar adequado. Cole a pasta do projeto (MJVProjetoWeb) dentro da sua pasta de Workspace.
Feito isso, abra a pasta à partir do diretório do sistema.

```
Clique em "File/Open projects from file system..."
```

2. Determine o diretório, encontre a pasta adequada e finalize.

```
Clique em "Directory" e localize o diretório onde colou a pasta, no caso o Workspace, tome cuidado para não importar os arquivos dentro da pasta "MJVProjetoWeb", você deve selecionar o diretório onde ela está, não a própria pasta. Em "Folder", clique na pasta "MJVProjetoWeb" e clique em "Finish".
```

3. Agora o projeto deve estar aparecendo no seu Project Explorer (caso contrário reinicie o seu Eclipse ou repita o processo, mas dessa vez importe o arquivo).


```
Para importar o arquivo vá em "File/Import...", selecione "General/Projects from Folder or Archive" e você chegará na mesma janela que antes. Repita o processo anterior.
```

4. Abra a estrutura de diretórios e localize a classe de banco de dados que estará dentro do DAO, o nome da classe é BD.

```
Em "Project Explorer" Expanda "MJVProjetoWeb", "Java Resources", "src", "br.com.mjv.dao" e abra a classe "BD.java"
```

5. Altere as configurações de login ao banco de dados, de acordo com como foi instalado o banco de dados na máquina do usuário. Altere também a porta do Mysql de acordo com a necessidade do usuário.

```
Na linha 18  temos o atributo "login" e na linha 19 o atributo "senha". Altere o "login" e a "senha" para serem os mesmos utilizados pelo usuário quando ele instalou o banco de dados.
Exemplo: Se o login for "admin" e a senha "123", o código deve ficar assim:
    final String login="admin";
    final String senha="123";
Na linha 22 temos um código onde pode-se ler: "jdbc:mysql://"+servidor+":3306/". Altere os números na frente do servidor de acordo com a porta utilizada pelo seu MySQL.
Exemplo: se porta for "9999", o código deve ficar asim:
    final String url = "jdbc:mysql://"+servidor+":9999/"+banco+"?useTimezone=true&serverTimezone=UTC";
```

6. Feito isso é possível que seja necessário construir o caminho da biblioteca ao conector do java, como eu deixei ele em uma pasta, basta localizá-lo em Web-Inf, dentro de Lib e fazer o "Build Path".

```
Partindo de "MJVProjetoWeb", expanda "Webcontent", "WEB-INF" e "lib", dentro dessa pasta deve estar "mysql-connector-java-8.0.11.jar". Muito provavelmente não será necessário executar o "Build Path", pois tudo que está nessa pasta tende a ser importado automaticamente, mas caso seja necessário, clique com o botão direito sobre esse arquivo e selecione a opção "Build Path" e "Configure Build Path", caso o "mysql-connector-java-8.0.11.jar" não estiver com uma marcação de "erro", basta voltar, caso contrário, selecione-o e clique em "edit", navegue novamente até a pasta "lib" e selecione o conector, feito isso, basta clicar "ok" e "apply and close".
```

7. Os dois últimos passos são: Ativar o banco de dados e ativar o tomcat. Para ativar o banco de dados, basta usar o script "DB.sql"

```
Após ter instalado o banco de dados MySQL, considerando que o mínimo necessário foi instalado, ele deve ter instalado o "MySQL 8.0 Command Line Client" no menu iniciar. Acesse esse "Client" e execute seu login digitando a mesma senha utilizada para configurar o banco de dados no passo 5., é possível abrir o arquivo "db.sql" utilizando "notepad++" ou qualquer editor de texto da sua preferência. Feito isso, basta inserir exatamente os mesmos códigos ali presentes na ordem que aparecem. 
```

8. Por fim, basta incializar o servidor através do eclipse. Para fazer os testes.

```
Existem várias formas de inicializar o servidor através do Eclipse, a mais fácil é:
Partindo de "MJVProjetoWeb", navegue até "WebContent" e clique com o botão direito sobre "Principal.html", selecione "Run as" e "Run on Server", selecione a pasta "Apache" e selecione o servidor "Tomcat v9.0 Server", feito isso, basta clicar em "Next" e em "Tomcat Installation Directory" navegar até a pasta onde ele está localizado, por fim, clique em "Finish", o servidor deve rodar e a página deve abrir normalmente.
```

9. Caso esse último passo dê errado, provavelmente falta algum plugin do eclipse. Baixe a versão "Web, XML, and Java EE Development" e "JST Server Adapters".


```
Isso tende a acontecer caso seu Eclipse não possui os plugins para trabalhar focado em desenvolvimento Web, para resolver isso, basta ir em "Help/Install new Software" em "Work with" selecione "--All Available Sites--" e em "Type filter text" comece a digitar "Web, XML, and Java EE Development", selecione a versão mais atual e baixe ela, clicando em "Finish" e depois aceitando os devidos contratos e dando "Next" até o IDE começar o download (note uma barra de progresso no canto inferior direito), quando terminar, permita que ele reinicie o Eclipse e volte em "Install new Software" para fazer a mesma coisa, porém com "JST Server Adapters" após seguir esses dois passos, repita a etapa 8.
```

### Execução do Aplicativo

Segue como executar o aplicativo:

  Após rodar a janela "Principal.html" através do servidor Tomcat, será possível inserir alguma informação nas caixas de texto "Usuário", "Título" e "Corpo do Texto".
  Ao clicar em "Enviar", o "Servlet" que está no package "br.com.mjv.servlet" dentro de "Java Resources" irá passar essa requisição para "Inserir.jsp" que está em "WEB-INF", que por sua fez passa as informações para o "UsuarioDao.java", onde a inserção no bando de dados é executada.
  Tecnicamente, as informações de titulo e corpo deveriam ser passadas para "ConteudoDao.java", porém, foi justamente nesse ponto que tive dificuldades.
   De qualquer modo, o "Insert" na tabela "user" ocorre como esperado e a mensagem "Cadastro de Usuário efetuado com sucesso." é exibida através do "inserir.jsp" pelo "UsuarioDao.java".
   Apesar de eu já ter criado os métodos para a exibição das tabelas (Método "Listar"), eu não tive tempo de aplicá-los na prática, então, será necessário se logar no banco de dados e digitar "SELECT * FROM USERS;" para ver os resultados.

## Tecnologias utilizadas

* [MySQL](https://dev.mysql.com/downloads/installer/) - Banco de Dados
* [Tomcat](https://tomcat.apache.org/download-90.cgi) - Servidor
* [Eclipse](https://www.eclipse.org/oxygen/) - IDE
* [Java](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) - Linguagem

## Autor

* **Pietro Pires Santos** - [LinkedIn](https://www.linkedin.com/in/pietropiressantos/)

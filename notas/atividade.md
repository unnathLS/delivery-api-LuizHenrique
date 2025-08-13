🔍 ATIVIDADE 3: CONSULTAS CUSTOMIZADAS E RELATÓRIOS
🧠 3.1 Consultas com @Query
Total de vendas por restaurante

Pedidos com valor acima de X

Relatório por período e status

🛢️ 3.2 Consultas Nativas (opcional)
Produtos mais vendidos

Ranking de clientes por nº de pedidos

Faturamento por categoria

🧩 3.3 Projeções e DTOs
Criar interfaces de projeção para relatórios

Consultas otimizadas retornando apenas campos necessários

🛠️ ATIVIDADE 4: CONFIGURAÇÃO E VALIDAÇÃO
🗃️ 4.1 Banco H2
Configurar application.properties para H2

Habilitar console H2

Configurar ddl-auto=create-drop

(Opcional) Inserir dados iniciais via data.sql

✅ 4.2 Validação da Estrutura
Verificar criação automática das tabelas

Confirmar relacionamentos no banco

Validar constraints e chaves estrangeiras

Testar integridade referencial

🪛 4.3 Logs e Debug
Habilitar logs SQL

Formatar queries no log

Mostrar parâmetros das consultas

Debug de performance básico

sse trecho faz parte de um teste unitário usando JUnit e Mockito em Java. Vou explicar os principais conceitos:

@Mock: Cria objetos simulados (mocks) das classes ClienteRepository, RestauranteRepository, etc. Esses objetos não executam lógica real, mas permitem testar o comportamento do código sem acessar o banco de dados.
@InjectMocks: Cria uma instância da classe DataLoader e injeta automaticamente os mocks nos campos dela. Assim, ao testar DataLoader, você controla suas dependências.
DataLoaderTest: É a classe de teste. Nela, você pode criar métodos anotados com @Test para verificar se o comportamento da classe DataLoader está correto.
Exemplo de método de teste:

Resumo:
Você usa mocks para simular dependências e verifica se os métodos corretos são chamados, garantindo que sua lógica funciona sem depender de recursos externos.
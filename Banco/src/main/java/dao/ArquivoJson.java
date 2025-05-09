package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import user.Usuario;
import java.io.*;
import java.lang.reflect.Type;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Aluno Caio Louback  matrícula 202335032
public class ArquivoJson {
    private static final String CAMINHO_ARQUIVO = "usuarios.json";
    private static final String CAMINHO_EXTRATO = "extrato.json";
    private static final String CAMINHO_CREDITO = "credito.json";
    private static final String CAMINHO_PEDIDO_SAQUE = "pedidosaque.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    
    public static void salvarUsuario(Usuario usuario) {
        List<Usuario> usuarios = lerUsuarios(); 
        usuarios.add(usuario); 

        try (FileWriter writer = new FileWriter(CAMINHO_ARQUIVO)) {
            gson.toJson(usuarios, writer);
            System.out.println("Usuario salvo com sucesso!");
        } catch (IOException e) {
        }
    }
    
    public static List<Usuario> lerUsuarios() {
        File file = new File(CAMINHO_ARQUIVO);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(CAMINHO_ARQUIVO)) {
            Type listType = new TypeToken<List<Usuario>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
  
   public static Usuario buscarUsuarioPorCPF(String cpf) {
        List<Usuario> usuarios = lerUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null; 
    }
   
   public static void attSaldo(String cpf, double novoSaldo){
       List<Usuario> usuarios = lerUsuarios();
       for(Usuario usuario : usuarios){
           if(usuario.getCpf().equals(cpf)) {
               usuario.setSaldo(novoSaldo);
           }
       }
       try (FileWriter writer = new FileWriter(CAMINHO_ARQUIVO)) {
            gson.toJson(usuarios, writer);
            System.out.println("Saldo atualizado!");
        } catch (IOException e) {
        }
   }
   
    public static void registrarMovimentacao(String cpf, String tipo, double valor) {
        File file = new File(CAMINHO_EXTRATO);
        Map<String, List<Map<String, Object>>> extratos;

        // Verifica se o arquivo existe e carrega os dados existentes
        if (file.exists()) {
            try (FileReader reader = new FileReader(CAMINHO_EXTRATO)) {
                Type type = new TypeToken<Map<String, List<Map<String, Object>>>>() {
                }.getType();
                extratos = gson.fromJson(reader, type);
            } catch (IOException e) {
                extratos = new HashMap<>();
            }
        } else {
            extratos = new HashMap<>();
        }

        // Adiciona nova movimentação para o CPF correspondente
        List<Map<String, Object>> movimentacoes = extratos.getOrDefault(cpf, new ArrayList<>());

        Map<String, Object> novaMovimentacao = new HashMap<>();
        novaMovimentacao.put("tipo", tipo);
        novaMovimentacao.put("valor", valor);

        movimentacoes.add(novaMovimentacao);
        extratos.put(cpf, movimentacoes);

        // Salvar no JSON
        try (FileWriter writer = new FileWriter(CAMINHO_EXTRATO)) {
            gson.toJson(extratos, writer);
            System.out.println("Movimentacao registrada com sucesso!");
        } catch (IOException e) {
        }
    }
    
    public static List<Map<String, Object>> lerExtrato(String cpf) {
        File file = new File(CAMINHO_EXTRATO);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(CAMINHO_EXTRATO)) {
            Type type = new TypeToken<Map<String, List<Map<String, Object>>>>() {
            }.getType();
            Map<String, List<Map<String, Object>>> extratos = gson.fromJson(reader, type);
            return extratos.getOrDefault(cpf, new ArrayList<>());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    
    public static String obterExtrato(String cpf) {
        List<Map<String, Object>> extrato = ArquivoJson.lerExtrato(cpf);
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")); // Formato monetário BR

        StringBuilder sb = new StringBuilder();
        sb.append("Extrato Bancário:\n\n");

        if (extrato.isEmpty()) {
            sb.append("Nenhuma movimentação encontrada.");
        } else {
            for (Map<String, Object> movimentacao : extrato) {
                String tipo = (String) movimentacao.get("tipo");
                double valor = (double) movimentacao.get("valor");
                sb.append(String.format("%s: %s\n", tipo, formatoMoeda.format(valor)));
            }
        }

        return sb.toString();
    }
    
    
    public static void solicitacaoDeCredito(String cpfSolicitante, double valor){
        Usuario user = buscarUsuarioPorCPF(cpfSolicitante);
        File file = new File(CAMINHO_CREDITO);
        Map<String, List<Map<String, Object>>> creditos;

        // Verifica se o arquivo existe e carrega os dados existentes
        if (file.exists()) {
            try (FileReader reader = new FileReader(CAMINHO_CREDITO)) {
                Type type = new TypeToken<Map<String, List<Map<String, Object>>>>() {
                }.getType();
                creditos = gson.fromJson(reader, type);
            } catch (IOException e) {
                creditos = new HashMap<>();
            }
        } else {
            creditos = new HashMap<>();
        }
        
        List<Map<String, Object>> solicitacoes = creditos.getOrDefault(cpfSolicitante, new ArrayList<>());
        
        Map<String, Object> novaSolicitacao = new HashMap<>();
        novaSolicitacao.put("nome", user.getNome());
        novaSolicitacao.put("cpf", user.getCpf()); // Usei dessa forma porque estou usando o CPF como chave do JSON
        novaSolicitacao.put("valor", valor);
        
        solicitacoes.add(novaSolicitacao);
        creditos.put(cpfSolicitante, solicitacoes);
        
        
        try (FileWriter writer = new FileWriter(CAMINHO_CREDITO)) {
            gson.toJson(creditos, writer);
            System.out.println("Solicitacao registrada com sucesso!");
        } catch (IOException e) {
        }  
    }
    
    
    public static String obterSolicitacoesCredito() {
        List<Map<String, Object>> creditos = lerSolicitacaoCredito();
        StringBuilder sb = new StringBuilder();
        sb.append("Solicitações de Crédito:\n\n");

        if (creditos.isEmpty()) {
            sb.append("Nenhuma solicitação encontrada.");
        } else {
            for (Map<String, Object> solicitacao : creditos) {
                String nome = (String) solicitacao.get("nome");
                double valor = (double) solicitacao.get("valor");
                sb.append(String.format("Nome: %s | Valor: R$ %.2f\n", nome, valor));
            }
        }

        return sb.toString();
    }
    
    
    public static List<Map<String, Object>> lerSolicitacaoCredito() {
        File file = new File(CAMINHO_CREDITO);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(CAMINHO_CREDITO)) {
            Type type = new TypeToken<Map<String, List<Map<String, Object>>>>() {
            }.getType();
            Map<String, List<Map<String, Object>>> creditos = gson.fromJson(reader, type);

            // Criar uma lista única com todas as solicitações de crédito
            List<Map<String, Object>> todasSolicitacoes = new ArrayList<>();
            for (List<Map<String, Object>> lista : creditos.values()) {
                todasSolicitacoes.addAll(lista);
            }

            return todasSolicitacoes;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
   
    public static void removerSolicitacaoCredito(String cpfSolicitante, double valor) {
        File file = new File(CAMINHO_CREDITO);
        Map<String, List<Map<String, Object>>> creditos;

        // Verifica se o arquivo existe e carrega os dados existentes
        if (file.exists()) {
            try (FileReader reader = new FileReader(CAMINHO_CREDITO)) {
                Type type = new TypeToken<Map<String, List<Map<String, Object>>>>() {
                }.getType();
                creditos = gson.fromJson(reader, type);
            } catch (IOException e) {
                creditos = new HashMap<>();
            }
        } else {
            creditos = new HashMap<>();
        }

        // Verifica se o CPF existe na lista de créditos
        List<Map<String, Object>> solicitacoes = creditos.getOrDefault(cpfSolicitante, new ArrayList<>());

        // Itera sobre as solicitações para encontrar e remover a solicitação com o valor
        solicitacoes.removeIf(solicitacao
                -> solicitacao.get("valor").equals(valor)
        );

        // Se a lista de solicitações de um CPF ficar vazia, removemos o CPF
        if (solicitacoes.isEmpty()) {
            creditos.remove(cpfSolicitante);
        } else {
            creditos.put(cpfSolicitante, solicitacoes);
        }

        // Grava o arquivo atualizado
        try (FileWriter writer = new FileWriter(CAMINHO_CREDITO)) {
            gson.toJson(creditos, writer);
            System.out.println("Solicitação de crédito removida com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gravar as atualizações no arquivo.");
        }
    } 
    
    public static void pedidoSaque(String cpfSolicitante, double valor) {
        Usuario user = buscarUsuarioPorCPF(cpfSolicitante);
        File file = new File(CAMINHO_PEDIDO_SAQUE);
        Map<String, List<Map<String, Object>>> saques;

        // Verifica se o arquivo existe e carrega os dados existentes
        if (file.exists()) {
            try (FileReader reader = new FileReader(CAMINHO_PEDIDO_SAQUE)) {
                Type type = new TypeToken<Map<String, List<Map<String, Object>>>>() {
                }.getType();
                saques = gson.fromJson(reader, type);
            } catch (IOException e) {
                saques = new HashMap<>();
            }
        } else {
            saques = new HashMap<>();
        }

        List<Map<String, Object>> pedidos = saques.getOrDefault(cpfSolicitante, new ArrayList<>());

        Map<String, Object> novoPedido = new HashMap<>();
        novoPedido.put("nome", user.getNome());
        novoPedido.put("cpf", user.getCpf());
        novoPedido.put("valor", valor);

        pedidos.add(novoPedido);
        saques.put(cpfSolicitante, pedidos);

        try (FileWriter writer = new FileWriter(CAMINHO_PEDIDO_SAQUE)) {
            gson.toJson(saques, writer);
            System.out.println("Pedido de saque registrado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao registrar o pedido de saque.");
        }
    }
    
    public static String obterPedidosSaque() {
        List<Map<String, Object>> saques = lerPedidosSaque();
        StringBuilder sb = new StringBuilder();
        sb.append("Pedidos de Saque:\n\n");

        if (saques.isEmpty()) {
            sb.append("Nenhum pedido de saque encontrado.");
        } else {
            for (Map<String, Object> pedido : saques) {
                String nome = (String) pedido.get("nome");
                double valor = (double) pedido.get("valor");
                sb.append(String.format("Nome: %s | Valor: R$ %.2f\n", nome, valor));
            }
        }
        return sb.toString();
    }

    public static List<Map<String, Object>> lerPedidosSaque() {
        File file = new File(CAMINHO_PEDIDO_SAQUE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (FileReader reader = new FileReader(CAMINHO_PEDIDO_SAQUE)) {
            Type type = new TypeToken<Map<String, List<Map<String, Object>>>>() {
            }.getType();
            Map<String, List<Map<String, Object>>> saques = gson.fromJson(reader, type);

            List<Map<String, Object>> todosPedidos = new ArrayList<>();
            for (List<Map<String, Object>> lista : saques.values()) {
                todosPedidos.addAll(lista);
            }
            return todosPedidos;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void removerPedidoSaque(String cpfSolicitante, double valor) {
        File file = new File(CAMINHO_PEDIDO_SAQUE);
        Map<String, List<Map<String, Object>>> saques;

        if (file.exists()) {
            try (FileReader reader = new FileReader(CAMINHO_PEDIDO_SAQUE)) {
                Type type = new TypeToken<Map<String, List<Map<String, Object>>>>() {
                }.getType();
                saques = gson.fromJson(reader, type);
            } catch (IOException e) {
                saques = new HashMap<>();
            }
        } else {
            saques = new HashMap<>();
        }

        List<Map<String, Object>> pedidos = saques.getOrDefault(cpfSolicitante, new ArrayList<>());
        pedidos.removeIf(pedido -> pedido.get("valor").equals(valor));

        if (pedidos.isEmpty()) {
            saques.remove(cpfSolicitante);
        } else {
            saques.put(cpfSolicitante, pedidos);
        }

        try (FileWriter writer = new FileWriter(CAMINHO_PEDIDO_SAQUE)) {
            gson.toJson(saques, writer);
            System.out.println("Pedido de saque removido com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gravar as atualizações no arquivo.");
        }
    }
    
}

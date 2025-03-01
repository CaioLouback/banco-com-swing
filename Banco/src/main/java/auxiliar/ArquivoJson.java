package auxiliar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import usuario.Usuario;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ArquivoJson {
    private static final String CAMINHO_ARQUIVO = "usuarios.json";
    private static final String CAMINHO_EXTRATO = "extrato.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    
    public static void salvarUsuario(Usuario usuario) {
        List<Usuario> usuarios = lerUsuarios(); // Carrega os usuários já salvos
        usuarios.add(usuario); // Adiciona o novo usuário

        try (FileWriter writer = new FileWriter(CAMINHO_ARQUIVO)) {
            gson.toJson(usuarios, writer);
            System.out.println("Usuario salvo com sucesso!");
        } catch (IOException e) {
        }
    }
    
    
    public static List<Usuario> lerUsuarios() {
        File file = new File(CAMINHO_ARQUIVO);
        if (!file.exists()) {
            return new ArrayList<>(); // Se o arquivo não existir, retorna lista vazia
        }

        try (FileReader reader = new FileReader(CAMINHO_ARQUIVO)) {
            Type listType = new TypeToken<List<Usuario>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    
    public static void removerUsuarioPorCPF(String cpf) {
        try {
            // Ler o JSON
            Gson gson = new Gson();
            String FILE_PATH = null;
            Reader reader = new FileReader(FILE_PATH);
            Type listType = new TypeToken<List<Map<String, String>>>() {}.getType();
            List<Map<String, String>> usuarios = gson.fromJson(reader, listType);
            reader.close();

            // Remover o usuário com o CPF fornecido
            usuarios.removeIf(usuario -> usuario.get("cpf").equals(cpf));

            // Salvar o JSON atualizado
            Writer writer = new FileWriter(FILE_PATH);
            gson.toJson(usuarios, writer);
            writer.close();

            System.out.println("Usuario removido com sucesso!");

        } catch (IOException e) {
        }
    }
    
   public static Usuario buscarUsuarioPorCPF(String cpf) {
        List<Usuario> usuarios = lerUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null; // Retorna null se o usuário não for encontrado
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
            System.out.println("Movimentação registrada com sucesso!");
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

        StringBuilder sb = new StringBuilder();
        sb.append("Extrato Bancário:\n\n");

        if (extrato.isEmpty()) {
            sb.append("Nenhuma movimentação encontrada.");
        } else {
            for (Map<String, Object> movimentacao : extrato) {
                String tipo = (String) movimentacao.get("tipo");
                double valor = (double) movimentacao.get("valor");
                sb.append(String.format("%s: R$ %.2f\n", tipo, valor));
            }
        }

        return sb.toString();
    }

   
   
}

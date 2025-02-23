
package auxiliar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import usuario.Usuario;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ArquivoJson {
    private static final String CAMINHO_ARQUIVO = "usuarios.json"; // Nome do arquivo JSON
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public static void salvarUsuario(Usuario usuario) {
        List<Usuario> usuarios = lerUsuarios(); // Carrega os usuários já salvos
        usuarios.add(usuario); // Adiciona o novo usuário

        try (FileWriter writer = new FileWriter(CAMINHO_ARQUIVO)) {
            gson.toJson(usuarios, writer);
            System.out.println("Usuário salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    
   /* public static Usuario buscarUsuarioPorCPF(String cpf) {
        List<Usuario> usuarios = lerUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }*/
     
}

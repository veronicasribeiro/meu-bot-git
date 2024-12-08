import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GitAutoCommitBot {

    private static void executarComando(String comando) throws IOException {
        Process process = Runtime.getRuntime().exec(comando);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }

    public static void main(String[] args) {
        try {
            String diretorio = "C:/Users/User/meu-bot-git";

            // Passo 1: Adicionar arquivos ao stage
            String comandoGitAdd = "cmd /c cd " + diretorio + " && git add .";
            System.out.println("Executando: " + comandoGitAdd);
            executarComando(comandoGitAdd);

            // Passo 2: Fazer o commit
            String mensagemCommit = "Commit automático via bot em Java";
            String comandoGitCommit = "cmd /c cd " + diretorio + " && git commit -m \"" + mensagemCommit + "\"";
            System.out.println("Executando: " + comandoGitCommit);
            executarComando(comandoGitCommit);

            // Passo 3: Fazer o push
            String comandoGitPush = "cmd /c cd " + diretorio + " && git push origin main";
            System.out.println("Executando: " + comandoGitPush);
            executarComando(comandoGitPush);

            System.out.println("Push realizado com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao executar o comando: " + e.getMessage());
        }
    }
}




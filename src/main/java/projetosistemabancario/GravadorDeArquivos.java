package projetosistemabancario;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeArquivos {
    public static final String ARQUIVO_CONTAS = "contas.dat";

    public HashMap<String, Conta> recuperarConta() throws IOException {
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTAS));
            return (HashMap<String, Conta>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar os contatos");
            throw new IOException("Não foi possível recuperar os dados do arquivo "+ARQUIVO_CONTAS);

        } finally {
            if (in!=null){
                in.close();
            }
        }
    }

    public void salvarConta(Map<String, Conta> contatos) throws IOException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTAS));
            out.writeObject(contatos);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar os contatos no arquivo "+ARQUIVO_CONTAS);
        }
    }
}
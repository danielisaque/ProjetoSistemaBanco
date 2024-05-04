package projetosistemabancario;

import java.io.*;

public class GravadorObjeto {

    public static boolean gravarObjeto( Object obj, String caminho ){
        // o parametro do tipo object aceita qualquer objeto
        // segundo parametro é o caminho do arquivo
        File arquivo = new File(caminho);
        if (!arquivo.exists()) {
            try{
                arquivo.createNewFile();

            } catch (Exception e){
                e.printStackTrace();
                return false;
            }
        } try {
            FileOutputStream fileOutput = new FileOutputStream(arquivo);
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);

            objOutput.writeObject(obj); // escrevendo o objeto dentro da file
            objOutput.flush(); // confirmando as operações
            fileOutput.flush();

            objOutput.close();
            fileOutput.close();

            return true; // caso tudo dê certo na gravação, vai retornar esse true
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    // Diuary: acima, eu importei a file Io, do próprio java
    // e criei uma new file, o meu if tá verificando se o arquivo ja
    // existe, ele vai tentar criar um novo arquivo, e pega uma exceção caso dê errado
    // após isso vou criar um fluxo de saída para o arquivo, no caso, file output que é o canal de comunição,
    // depois objectOutput, que joga o objeto lá dentro da file
    public static Object recuperarObjeto(String caminho){
        // retorna o objeto gravado no arquivo,
        // o caminho também é passado como parametro
        File arquivo = new File(caminho);
        try{
            FileInputStream fileInput = new FileInputStream(arquivo);
            ObjectInputStream objInput = new ObjectInputStream(fileInput);

           Object retorno = objInput.readObject();

           objInput.close();
           fileInput.close();
            return retorno;

        } catch( Exception e){
            e.printStackTrace();
            return null;
        }

    }
}

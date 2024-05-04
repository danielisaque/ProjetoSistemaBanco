package projetosistemabancario;

import projetosistemabancario.Conta;

public class GravadorArquivos {

    public static void main(String [] args){
        String caminho = "arquivo.txt"; // diuary: definindo o caminho como uma string pra facilitar mudanças

        Conta c1 = new Conta("65468414772", "2451547",
                "Brigadeiro", "Rua Brigadeiro de lima", 1000.0,"");
        boolean gravou = GravadorObjeto.gravarObjeto(c1, caminho);
        Object clienteSalvo = GravadorObjeto.recuperarObjeto(caminho);
        System.out.println(clienteSalvo);

    }
}

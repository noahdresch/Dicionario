package controlas;
import model.Palavra;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Noa
 */
public class Dicionario {
    
    private ArrayList<Palavra> palavras = new ArrayList();
    private int serial = 1;
    
    public int getProximoSerial()
    {
        return serial++;
    }
    
    public void addPalavra( Palavra novoObjeto )
    {
        if ( consultarPalavraExata( novoObjeto.nome ) == null )
        {
            novoObjeto.codigo = getProximoSerial();
            palavras.add( novoObjeto );

            JOptionPane.showMessageDialog( null, "Palavra cadastrada com sucesso!" );
        }

        else
        {
            JOptionPane.showMessageDialog( null, "Palavra com o nome " + novoObjeto.nome + " já existe!");
        }
    }
    
    public Palavra consultarPalavraPorCodigo( int codigo )
    {
        for ( Palavra palvaraDentroDoArray : palavras )
        {
            if ( palvaraDentroDoArray.codigo == codigo )
            {
                return palvaraDentroDoArray;
            }
        }
        
        return null;
    }
    public Palavra consultarPalavraExata( String textoParaBuscar )
    {
        for ( Palavra palvaraDentroDoArray : palavras )
        {
            if ( palvaraDentroDoArray.nome.equals( textoParaBuscar ) )
            {
                return palvaraDentroDoArray;
            }
        }
        
        return null;
    }
    
    public ArrayList<Palavra> consultarPalavra( String textoParaBuscar )
    {
        ArrayList<Palavra> palavrasFiltradas = new ArrayList();
        
        for ( Palavra palvaraDentroDoArray : palavras )
        {
            if ( palvaraDentroDoArray.nome.toLowerCase().contains( textoParaBuscar.toLowerCase() ) ||
                 palvaraDentroDoArray.significado.contains( textoParaBuscar ) )
            {
                palavrasFiltradas.add( palvaraDentroDoArray );
            }
        }
        
        return palavrasFiltradas;
    }
    
    public ArrayList<Palavra> getPalavras()
    {
        return palavras;
    }
    
    public void removerPalavra(String nome) {
        Palavra palavra = consultarPalavraExata(nome);
        if (palavra != null) {
            palavras.remove(palavra);
            JOptionPane.showMessageDialog( null,"Palavra removida com sucesso!");
        } else {
            JOptionPane.showMessageDialog( null,"Palavra não encontrada no dicionário" );
        }
    }
    
     public void alterarPalavra(int codigo, String novoNome, String novoSignificado) {
        Palavra palavra = consultarPalavraPorCodigo(codigo);
        if (palavra != null) {
            palavra.nome = novoNome;
            palavra.significado = novoSignificado;
           JOptionPane.showMessageDialog( null, "Palavra Alterada" );
        } else {
            JOptionPane.showMessageDialog( null,"Palavra não encontrada no dicionário" );
        }
    }

    
    public void imprimeDicionario()
    {
        for ( Palavra p : palavras )
        {
            JOptionPane.showMessageDialog( null, "codigo: " + p.codigo + "\n" + 
                                "palavra: " + p.nome + "\n" + 
                                "significado: " + p.significado );
        }
    }
}

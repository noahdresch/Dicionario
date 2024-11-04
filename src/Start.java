import util.Entrada;
import model.Palavra;
import controlas.Dicionario;
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
public class Start
{
   public static void main( String[] args )
    {
    Dicionario aurelio  = new Dicionario();
        
        while( true )
        {
            int opcao = Entrada.leiaInt( "Menu \n "+
                                         "[1] - Cadastrar Palavra \n" +
                                         "[2] - Consultar Palavra Exata\n" +
                                         "[3] - Consultar Palavra (Pedaço)\n" +
                                         "[4] - Alterar Palavra e significado\n" +
                                         "[5] - Remover Palavra\n" +
                                         "[6] - Imprimir Dicionario \n" +
                                         "[7] - Sair"
                                         );
            
            if ( opcao == 1 )
            {
                Palavra novaPalavra = new Palavra();
                //será controlado pelo Dicionario (serial++)
                //novaPalavra.codigo = Entrada.leiaInt( "Código: " );
                novaPalavra.nome = Entrada.leiaString( "Nome: " );
                novaPalavra.significado = Entrada.leiaString( "Significado: " );
                
                aurelio.addPalavra( novaPalavra );
            }
            
            else if ( opcao == 2 )
            {
                String nomeDigitadoPeloUsuario = Entrada.leiaString( "Qual palavar você quer consultar?" );
                
                Palavra palavaEncontrada = aurelio.consultarPalavraExata( nomeDigitadoPeloUsuario );
                
                if ( palavaEncontrada != null )
                {
                    
                    JOptionPane.showMessageDialog( null, "codigo: " + palavaEncontrada.codigo + "\n" + 
                                "palavra: " + palavaEncontrada.nome + "\n" + 
                                "significado: " + palavaEncontrada.significado );

                }
                
                else
                {
                    JOptionPane.showMessageDialog( null, "Palavra não encontrada no dicionário" );
                }
            }
            
            else if ( opcao == 3 )
            {
                String nomeDigitadoPeloUsuario = Entrada.leiaString( "Qual \"pedaço\"palavra você quer consultar?" );
                
                ArrayList<Palavra> palavrasFiltradas = aurelio.consultarPalavra( nomeDigitadoPeloUsuario );
                
                if ( ! palavrasFiltradas.isEmpty() )
                {
                    JOptionPane.showMessageDialog( null, "Foram encontradas " + palavrasFiltradas.size() + "!" );
                  
                    for ( Palavra palavraFiltrada : palavrasFiltradas )
                    {
                        
                        JOptionPane.showMessageDialog( null, "codigo: " + palavraFiltrada.codigo + "\n" + 
                                "palavra: " + palavraFiltrada.nome + "\n" + 
                                "significado: " + palavraFiltrada.significado );
                      
                    }
                }
                
                else
                {
                    JOptionPane.showMessageDialog( null, "Não foi encontrada nenhuma palavra!" );
                }
            }  
            
            else if (opcao == 4) {
                int codigo = Entrada.leiaInt("Digite o código da palavra a ser alterada: ");
                String novoNome = Entrada.leiaString("Digite o novo nome: ");
                String novoSignificado = Entrada.leiaString("Digite o novo significado: ");

                aurelio.alterarPalavra(codigo, novoNome, novoSignificado);
                }
                
            else if (opcao == 5) {
                String nome = Entrada.leiaString("Digite o nome da palavra a ser removida: ");
                aurelio.removerPalavra(nome);
            }
          
            else if ( opcao == 6 )
            {
                aurelio.imprimeDicionario();
            }
            
            else if ( opcao == 7 )
            {
                JOptionPane.showMessageDialog( null, "Tchau!" );
                System.exit( 0 );
            }
                    
        }
    }
     
}

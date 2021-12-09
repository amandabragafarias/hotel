/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controle;

import hotel.entidades.Pessoa;
import hotel.entidades.PessoaVip;
import hotel.entidades.Quarto;
import hotel.entidades.Reserva;
import hotel.exceptions.DIException;
import hotel.exceptions.PJCException;
import hotel.exceptions.PNEException;
import hotel.exceptions.QJCException;
import hotel.exceptions.QJRException;
import hotel.exceptions.QNEException;
import hotel.exceptions.RNEException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Amanda
 */
public class HotelMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException{
        // TODO code application logic here
        menu();
        Scanner ler = new Scanner(System.in);
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Hotel hotel = new Hotel();
        int op = ler.nextInt();
       int op2 = 9;
       int op3 =9;
       int op4 = 9;
       
        while(op!=0 && op2!=0 && op3!=0 && op4!=0){
            if(op==1){
                menuPessoa();
                 op2=ler.nextInt();
                if(op2==1){
                    System.out.println("[1] - Pessoa Comum");
                    System.out.println("[2] - Pessoa Vip");
                    int tipopessoa = ler.nextInt();
                    if(tipopessoa==1){
                    System.out.println("Digite seu nome");
                    String nome = ler.next();
                     System.out.println("Qual seu sexo?");
                     System.out.println("[F] - Feminino");
                     System.out.println("[M] - Masculino");
                     String s=ler.next();
                     String sexo = null;
                     if(s.equals("f") || s.equals("F")){
                        sexo="Feminino";
                     }
                     if(s.equals("m") || s.equals("M")){
                        sexo="Masculino";
                     }
                    System.out.println("Digite o número do seu CPF");
                    String cpf = ler.next();
                    Pessoa pessoa = new Pessoa(nome, sexo, cpf);
                    pessoa.setNome(nome);
                    pessoa.setSexo(sexo);
                    pessoa.setCpf(cpf);
                    try{
                        hotel.cadastrarPessoa(pessoa);
                        System.out.println("Pessoa cadastrada com sucesso!");
                    }catch(PJCException e){
                        System.out.println("Erro: "+e.getMessage());
                    }
                    }
                    if(tipopessoa==2){
                        System.out.println("Digite seu nome");
                    String nome = ler.next();
                    System.out.println("Qual seu sexo?");
                    System.out.println("[F] - Feminino");
                    System.out.println("[M] - Masculino");
                    String s=ler.next();
                    String sexo = null;
                    if(s.equals("f") || s.equals("F")){
                        sexo="Feminino";
                    }
                    if(s.equals("m") || s.equals("M")){
                        sexo="Masculino";
                    }
                    System.out.println("Digite o número do seu CPF");
                    String cpf = ler.next();
                    double taxaDesconto=100.0;
                    Pessoa pessoa = new PessoaVip(nome, sexo, cpf, taxaDesconto);
                    pessoa.setNome(nome);
                    pessoa.setSexo(sexo);
                    pessoa.setCpf(cpf);
                    ((PessoaVip) pessoa).setTaxaDesconto(taxaDesconto);
                    try{
                        hotel.cadastrarPessoa(pessoa);
                        System.out.println("Pessoa cadastrada com sucesso");
                    }catch(PJCException e){
                        System.out.println("Erro: "+e.getMessage());
                    }
                    }
                    
                    
                }
                if(op2==2){
                    System.out.println("Digite o número do CPF");
                    String cpf = ler.next();
                    try{
                        hotel.removerPessoaPorCpf(cpf);
                        System.out.println("Pessoa removida com sucesso.");
                    }
                    catch(PNEException e){
                        System.out.println("Erro: "+e.getMessage());
                    }
                }
                if(op2==3){
                    System.out.println("Digite o CPF da pessoa que deseja encontrar");
                    String cpf=ler.next();
                    try{
                        Pessoa pessoa = hotel.buscarPessoaPorCpf(cpf);
                        System.out.println("[PESSOA]:");
                        System.out.println("Nome: "+pessoa.getNome());
                        System.out.println("Sexo: "+pessoa.getSexo());
                        System.out.println("CPF: "+pessoa.getCpf()); 
                        if(pessoa instanceof PessoaVip){
                       System.out.println("Taxa de Desconto Vip: "+((PessoaVip) pessoa).getTaxaDesconto());
                    }
                    }
                    catch(PNEException e){
                        System.out.println("Erro: "+e.getMessage());
                    }
                }
                if(op2==4){
                    System.out.println("Digite o nome da pessoa que deseja encontrar");
                    String nome = ler.next();
                    try{
                        ArrayList<Pessoa> pessoa = hotel.buscarPessoaPorNome(nome);
                        for(int i=0;i<pessoa.size();i++){
                            Pessoa p = pessoa.get(i);
                            System.out.println("[PESSOA]:");
                            System.out.println("Nome: "+p.getNome());
                            System.out.println("Sexo: "+p.getSexo());
                            System.out.println("CPF: "+p.getCpf());
                            if(p instanceof PessoaVip){
                                System.out.println("Taxa de Desconto Vip: "+((PessoaVip)p).getTaxaDesconto());
                            }
                  }
                    }catch(PNEException e){
                      System.out.println("Erro: "+e.getMessage());
                          }
                    }
               
            }
            if(op==2){
                menuQuarto();
                op3=ler.nextInt();
                
                        
        if(op3==1){
                     System.out.println("Digite o andar");
                int andar = ler.nextInt();
                System.out.println("Digite o número do quarto");
                int numero = ler.nextInt();
                System.out.println("Digite o tipo");
                System.out.println("[1] - Suite:  R$ 600");
                System.out.println("[2] - Suite Master: R$ 750");
                System.out.println("[3] - Presidencial: R$ 900");
                System.out.println("[4] - Quarto Simples: R$ 500");
                int t=ler.nextInt();
                String tipo=null;
                double diaria=0.0;
                   if(t==1){
                       tipo ="Suite";
                       diaria = 600.0;
                   }
                   if(t==2){
                       tipo = "Suite Master";
                       diaria = 750.0;
                   }
                   if(t==3){
                       tipo = "Presidencial";
                       diaria = 900.0;
                   }
                   if(t==4){
                       tipo="Quarto Simples";
                       diaria=500.0;
                   }
                 Quarto quarto = new Quarto(andar, numero, tipo, diaria);
                quarto.setAndar(andar);
                quarto.setNumero(numero);
                quarto.setTipo(tipo);
                quarto.setDiaria(diaria);
                
            try {
                hotel.cadastrarQuarto(quarto);
                System.out.println("Operação realizada com sucesso!"); 
            }
            catch (QJCException e) {
		System.out.println("Erro: " + e.getMessage());
	}
            
                }
       if(op3==2){
           System.out.println("Digite o número do quarto");
           int numero = ler.nextInt();
           try{
               Quarto quarto = hotel.buscarQuartoPorNumero(numero);
               
               System.out.println("[QUARTO]:");
               System.out.println("Andar: "+quarto.getAndar());
               System.out.println("Numero: "+quarto.getNumero());
               System.out.println("Tipo: "+quarto.getTipo());
               System.out.println("Diária: "+quarto.getDiaria());
       }
           catch(QNEException e){
               System.out.println("Erro: "+e.getMessage());
           }
    
            }
       if(op3==3){
           System.out.println("Digite o número do quarto que deseja remover");
           int numero=ler.nextInt();
           try{
               hotel.removerQuartoPorNumero(numero);
               System.out.println("Quarto removido com sucesso.");
           }catch(QNEException e){
               System.out.println("Erro: "+e.getMessage());
           }
       }
       if(op3==4){
            System.out.println("Digite o andar");
                int andar = ler.nextInt();
                try{
                    ArrayList<Quarto> quarto = hotel.buscarQuartoPorAndar(andar);
                       for(int i=0;i<quarto.size();i++){
                       Quarto q = quarto.get(i);
                       System.out.println("[QUARTO]:");
                       System.out.println("Andar: "+q.getAndar());
                       System.out.println("Número:"+q.getNumero());
                       System.out.println("Tipo: "+q.getTipo());
                       System.out.println("Diária: "+q.getDiaria());
                       }
                   }
                
                catch(QNEException e){
                    System.out.println("Erro: "+ e.getMessage());
                }
            }
      
            }
            
            if(op==3){
                menuReserva();
                op4 = ler.nextInt();
                if(op4==1){
                   System.out.println("Digite o número do quarto");
                      int numero = ler.nextInt();
                      Quarto quarto=null;
                      try{
                    quarto = hotel.buscarQuartoPorNumero(numero);
                      }catch(QNEException e){
                          System.out.println("Erro: "+e.getMessage());
                      }
                     System.out.println("Digite o número do CPF");
                     String cpf=ler.next();
                     Pessoa pessoa=null;
                     try{
                    pessoa = hotel.buscarPessoaPorCpf(cpf);
                     }catch(PNEException e){
                         System.out.println("Erro: "+e.getMessage());
                     }
                     
                    System.out.println("Digite a data do aluguel __/__/__");
                    
                    String da=ler.next();
                    Date dataDoAluguel=(Date) formatador.parse(da);
                    
                       System.out.println("Digite a data de devolução");
                    String dd=ler.next();
                    Date dataDevolucao=(Date) formatador.parse(dd);
                    int ano=(dataDevolucao.getYear()-dataDoAluguel.getYear())*365;
                    int dia=dataDevolucao.getDate()-dataDoAluguel.getDate();
                    int mes=(dataDevolucao.getMonth()-dataDoAluguel.getMonth())*30;
                    int dias=ano+dia+mes;
                    double valorReserva=dias*quarto.getDiaria();
                    if(pessoa instanceof PessoaVip){
                       valorReserva = valorReserva-((PessoaVip)pessoa).getTaxaDesconto();
                    }
                    int cod = hotel.retornarCodigo();
                    cod++;
                    String codigo =  Integer.toString(cod);
                    Reserva reserva = new Reserva(pessoa, quarto, dataDoAluguel,dataDevolucao, codigo, valorReserva);
                    reserva.setPessoa(pessoa);
                    reserva.setQuarto(quarto);
                    reserva.setDataDoAluguel(dataDoAluguel);
                    reserva.setDataDevolucao(dataDevolucao);
                    reserva.setCodigo(codigo);
                    reserva.setValorReserva(valorReserva);
                    try{
                        hotel.reservarQuarto(reserva);
                        System.out.println("Reserva realizada com sucesso.");
                        System.out.println("Codigo: "+reserva.getCodigo());
                        System.out.println("Valor da reserva: "+reserva.getValorReserva());
                    }catch(QJRException e){
                        System.out.println("Erro: "+e.getMessage());
                    }catch(DIException e){
                        System.out.println("Erro: "+e.getMessage());
                    }
                    
                }
                
               if(op4==2){
                    System.out.println("Digite o código da reserva");
                    String codigo = ler.next();
                    try{
                        hotel.cancelarReserva(codigo);
                        System.out.println("Reserva cancelada com sucesso.");
                    }catch(RNEException e){
                        System.out.println("Erro: "+e.getMessage());
                    }
                        
            }
                if(op4==3){
                    System.out.println("Digite o número do quarto");
                    int numero=ler.nextInt();
                    try{
                       ArrayList<Reserva> reservas = hotel.buscarReservaPorQuarto(numero);
                       for(int i=0;i<reservas.size();i++){
                           Reserva reserva = reservas.get(i);
                           Pessoa pessoa = reserva.getPessoa();
                           Quarto quarto = reserva.getQuarto();
                          System.out.println("[RESERVA]:");
                          System.out.println("Pessoa: "+pessoa.getNome());
                          System.out.println("Número do quarto: "+quarto.getNumero());
                          System.out.println("Data do aluguel: "+formatador.format(reserva.getDataDoAluguel()));
                          System.out.println("Data de devolução: "+formatador.format(reserva.getDataDevolucao()));
                          System.out.println("Código: "+reserva.getCodigo());
                          System.out.println("Valor da reserva: "+reserva.getValorReserva());
                       }
                    }catch(RNEException e){
                        System.out.println("Erro: "+e.getMessage());
                    }
                    
                }
                if(op4==4){
                    System.out.println("Digite o código da reserva");
                    String codigo=ler.next();
                    try{
                         Reserva reserva = hotel.buscarReservaPorCodigo(codigo);
                         Pessoa pessoa = reserva.getPessoa();
                         Quarto quarto = reserva.getQuarto();
                          System.out.println("[RESERVA]:");
                          System.out.println("Pessoa: "+pessoa.getNome());
                          System.out.println("Número do quarto: "+quarto.getNumero());
                          System.out.println("Data do aluguel: "+formatador.format(reserva.getDataDoAluguel()));
                          System.out.println("Data de devolução: "+formatador.format(reserva.getDataDevolucao()));
                          System.out.println("Código: "+reserva.getCodigo());
                          System.out.println("Valor da reserva: "+reserva.getValorReserva());
                    }
                    catch(RNEException e){
                        System.out.println("Erro: "+e.getMessage());
                }
                
         }
                if(op4==5){
                    System.out.println("Digite o número do CPF");
                    String cpf = ler.next();
                    try{
                        ArrayList<Reserva> reservas = hotel.buscarReservaPorCpfPessoa(cpf);
                        for(int i=0;i<reservas.size();i++){
                            Reserva reserva = reservas.get(i);
                            Pessoa pessoa = reserva.getPessoa();
                            Quarto quarto = reserva.getQuarto();
                           
                          System.out.println("[RESERVA]:");
                          System.out.println("Pessoa: "+pessoa.getNome());
                          System.out.println("Número do quarto: "+quarto.getNumero());
                          System.out.println("Data do aluguel: "+formatador.format(reserva.getDataDoAluguel()));
                          System.out.println("Data de devolução: "+formatador.format(reserva.getDataDevolucao()));
                          System.out.println("Código: "+reserva.getCodigo());
                          System.out.println("Valor da reserva: "+reserva.getValorReserva());
                        }
                }catch(RNEException e){
                    System.out.println("Erro: "+e.getMessage());
                }
            
                
         }
            
    }
            menu();
       op=ler.nextInt(); }
        
    
    }
    public static void menu(){
        System.out.println("--------Hotel--------");
        System.out.println("[1] - Menu Cliente");
        System.out.println("[2] - Menu Quarto");
        System.out.println("[3] - Menu Reserva");
        System.out.println("[0] - Digite 0 para sair");  
        
    }
    public static void menuPessoa(){
        System.out.println("--------Hotel--------");
        System.out.println("--------Menu Cliente--------");
        System.out.println("[1] - Cadastrar pessoa");
        System.out.println("[2] - Remover pessoa por CPF");
        System.out.println("[3] - Buscar pessoa por CPF");
        System.out.println("[4] - Buscar pessoa por nome");
        System.out.println("[0] - Digite 0 para sair");
    }
    public static void menuQuarto(){
        System.out.println("--------Hotel--------");
        System.out.println("-------- Menu Quarto--------");
        System.out.println("[1] - Cadastrar Quarto");
        System.out.println("[2] - Buscar quarto por número");
        System.out.println("[3] - Remover quarto por número");
        System.out.println("[4] - Buscar quarto por andar");
        System.out.println("[0] - Digite 0 para sair");
    }
    public static void menuReserva(){
        System.out.println("--------Hotel--------");
        System.out.println("--------Menu Reserva--------");
        System.out.println("[1] - Reservar Quarto");
        System.out.println("[2] - Cancelar reserva");
        System.out.println("[3] - Buscar reserva por quarto");
        System.out.println("[4] - Buscar reserva por código");
        System.out.println("[5] - Buscar reserva por CFP do cliente");
        System.out.println("[0] - Digite 0 para sair");
    }
    
}
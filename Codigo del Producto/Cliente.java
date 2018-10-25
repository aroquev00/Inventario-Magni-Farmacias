
import java.io.*;

/*
Armando Roque Villasana A01138717
Ultima edicion: 18/10/2017
Clase Cliente
*/

public class Cliente{
  
  //Declaración de atributos
  private String nombreCliente;
  private String apellidoCliente;
  private String telefonoCliente;
  private String emailCliente;
  private int codigoCliente;
  private int numeroComprasCliente;
  private double valorComprasCliente;

  //Constructores 
  //Constructor sin parámetros
  public Cliente(){
    this.nombreCliente = "";
    this.apellidoCliente = "";
    this.telefonoCliente = "";
    this.emailCliente = "";
    this.codigoCliente = 0;
    this.numeroComprasCliente = 0;
    this.valorComprasCliente = 0;
  }
  
    //Constructor con parámetos
  public Cliente(String nombre, String apellido, String telefono, String email, int codigo, int numero, int valor){
    this.nombreCliente = nombre;
    this.apellidoCliente = apellido;
    this.telefonoCliente = telefono;
    this.emailCliente = email;
    this.codigoCliente = codigo;
    this.numeroComprasCliente = numero;
    this.valorComprasCliente = valor;
  }

  //Métodos set
  public void setNombreCliente(String nombre){
   this.nombreCliente = nombre; 
  }
  
  public void setApellidoCliente(String apellido){
   this.apellidoCliente = apellido; 
  }
  
  public void setTelefonoCliente(String telefono){
   this.telefonoCliente = telefono; 
  }
  
  public void setEmailCliente(String email){
   this.emailCliente = email; 
  }
  
  public void setCodigoCliente(int codigo){
   this.codigoCliente = codigo; 
  }
  
  public void setNumeroComprasCliente(int numero){
   this.numeroComprasCliente = numero; 
  }
  
  public void setValorComprasCliente(double valor){
   this.valorComprasCliente = valor; 
  }

  //Métodos get
  public String getNombreCliente(){
   return nombreCliente; 
  }
  
  public String getApellidoCliente(){
   return apellidoCliente; 
  }
  
  public String getTelefonoCliente(){
   return telefonoCliente; 
  }
  
  public String getEmailCliente(){
   return emailCliente; 
  }
  
  public int getCodigoCliente(){
   return codigoCliente; 
  }
  
  public int getNumeroComprasCliente(){
   return numeroComprasCliente; 
  }
  
  public double getValorComprasCliente(){
   return valorComprasCliente; 
  }
  
  //Métodos de la clase
  //Metodo para registrar un nuevo cliente
  public static void nuevoCliente(String nombreCliente, String apellidoCliente, String telefonoCliente, String emailCliente) throws IOException{
    
      //Se crean los objetos necesarios para crear un nuevo cliente y guararlo en el archivo de texto
      //Será el nuevo cliente
      Cliente esteCliente = new Cliente();
      //Para llegar los arreglos
    ArchivosBinarios ab = new ArchivosBinarios();
    //Se llena el arreglo de clientes con los datos de los clientes existentes
    Cliente[] arrCliente = ab.llenarArregloCliente();
    
    //Se guarda el codigo del cliente (el numero es el que siga del numero de clientes actuales)
    esteCliente.setCodigoCliente(arrCliente.length+1);
    
    //Se guarda el nombre del cliente
    esteCliente.setNombreCliente(nombreCliente);
    
    //Se guarda el apellido del cliente
    esteCliente.setApellidoCliente(apellidoCliente);
    
    //Se guarda el telefono del cliente
    esteCliente.setTelefonoCliente(telefonoCliente);
    
    //Se guarda el email del cliente
    esteCliente.setEmailCliente(emailCliente);
    
    //Se guarda el numero de compras del cliente
    esteCliente.setNumeroComprasCliente(0);
    
    //Se guarda el valor de las compras del cliente
    esteCliente.setValorComprasCliente(0.0);
    
    //Guardar el nuevo cliente en el archivo de clientes
    PrintWriter out1 = new PrintWriter(new FileOutputStream("Clientes.txt", true));
    out1.println(esteCliente.getCodigoCliente() + "#" + esteCliente.getNombreCliente() + "#" + esteCliente.getApellidoCliente() + "#" + esteCliente.getTelefonoCliente() + "#" + esteCliente.getEmailCliente() + "#" + esteCliente.getNumeroComprasCliente() + "#" + esteCliente.getValorComprasCliente());
    out1.close();
    
      
  }
  
  
  
}
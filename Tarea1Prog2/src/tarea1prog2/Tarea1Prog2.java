
package tarea1prog2;

import java.util.ArrayList;
import java.util.Date;

class Efectivo extends Pago{
    public Efectivo(float m,Date f){
        super(m,f);
    }
    public float calcDevolucion(float precio,float monto){
        if(monto > precio){
            return monto - precio;
        }
        else return 0;
    }
    public String toString(){
        return "Los datos del pago son\nTipo : Efectivo" + super.toString();
    }
}
class Transferencia extends Pago{
    private String Banco;
    private String numCuenta;
    public Transferencia(float m, Date f,String b,String nc){
        super(m,f);
        Banco = b;
        numCuenta = nc;
    }
    public String toString(){
        return "Los datos del pago son\nTipo : Transferencia" + super.toString() + "\nBanco : " + Banco + "\nNumero de Cuenta : " + numCuenta;
    }
}
class Tarjeta extends Pago{
    private String Tipo;
    private String numTransaccion;
    public Tarjeta(float m, Date f,String t,String nt){
        super(m,f);
        Tipo = t;
        numTransaccion = nt;
    }
    public String toString(){
        return "Los datos del pago son\nTipo : Tarjeta" + super.toString() + "\nTipo : " + Tipo + "\nNumero de Transaccion : " + numTransaccion;
    }
}
class Pago{
    private float monto;
    private Date fecha;
    private OrdenCompra OrdenCompra;
    public Pago(float m,Date f){
        monto = m;
        fecha = f;
    }
    public String toString(){
        return "\nMonto : " + monto + "CLP\nFecha : " + fecha; 
    }
    public float getMonto(){
        return monto;
    }
}

class Boleta extends DocTributario{
    public Boleta(String n,String r,Date f){
        super(n,r,f);
    }
    public String toString(){
        return "Los datos de la Boleta son:\nNumero: " + super.getNumero() + "\nRut: " + super.getRut() + "\nFecha: " + super.getFecha();
    }
}
class Factura extends DocTributario{
    public Factura(String n,String r,Date f){
        super(n,r,f);
    }
    public String toString(){
        return "Los datos de la Factura son:\nNumero: " + super.getNumero() + "\nRut: " + super.getRut() + "\nFecha: " + super.getFecha();
    }
}
class DocTributario{
    private String numero;
    private String rut;
    private Date fecha;
    private OrdenCompra OrdenCompra;
    private Direccion direccion;
    public DocTributario(String n,String r, Date f){
        numero = n;
        rut= r;
        fecha = f;
    }
    public String toString(){
        return "Los datos del Documento Tributario son:\nNumero: " + numero + "\nRut: " + rut + "\nFecha: " + fecha;
    }
    public String getNumero(){
        return numero;
    }
    public String getRut(){
        return rut;
    }
    public Date getFecha(){
        return fecha;
    }
}
class Direccion{
    private String direccion;
    private ArrayList<DocTributario> DocTributarioAR;
    private ArrayList<Cliente> ClienteAR;
    public Direccion(String d){
        direccion = d;
    }
    public String getDireccion(){
        return direccion;
    }
    public String toString(){
        return direccion;
    }
}
class Cliente{
    private String nombre;
    private String rut;
    private Direccion direccion;
    private ArrayList<OrdenCompra> OrdenCompraAR;
    public Cliente(String n,String r){
        nombre = n;
        rut = r;
    }
    public void setDireccion(Direccion d){
        direccion = d;
    }
    public String getnombre(){
        return nombre;
    }
    public String getrut(){
        return rut;
    }
    public String toString(){
        return "Los datos del cliente son: \nNombre: " + nombre + " \nRut: " + rut + " \nDireccion: " + direccion.toString();
    }
}
class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    private ArrayList<DetalleOrden> DetalleOrdenAR;
    public Articulo(float pe,String n, String d,float pr){
        peso = pe;
        nombre = n;
        descripcion = d;
        precio = pr;
    }
    public float getpeso(){
        return peso;
    }
    public float getprecio(){
        return precio;
    }
    public String toString(){
        return "\nNombre: " + nombre + "\nDescripcion: " + descripcion + "\nPrecio: " + precio + " CLP\nPeso: " + peso + " kg";
    }
}
class DetalleOrden{
    private int cantidad;
    private Articulo Articulo;
    private OrdenCompra OrdenCompra;
    public DetalleOrden(int c){
        cantidad = c;
    }
    public void setArticulo(Articulo a){
        Articulo = a;
    }
    public Articulo getArticulo(){
        return Articulo;
    }
    public int getCantidad(){
        return cantidad;
    }
    public float calcPrecio(){
        return calcPrecioSinIVA() + calcIVA();
    }
    public float calcPrecioSinIVA(){
        return (float)cantidad * Articulo.getprecio();
    }
    public float calcIVA(){
        return (calcPrecioSinIVA() * 19) / 100;
    }
    public float calcPeso(){
        return (float)cantidad * Articulo.getpeso();
    }
    public String toString(){
        return "Los datos del detalle de orden son \nArticulo " + Articulo + "\nCantidad : " + cantidad;
    }
    
    
}
class OrdenCompra{
    private DocTributario DocTributario;
    private Date fecha;
    private String estado;
    private ArrayList<DetalleOrden> DetalleOrdenAR;
    private Cliente Cliente;
    private ArrayList<Pago> PagoAR;
    public OrdenCompra(Date f, String e){
        fecha = f;
        estado = e;
        DetalleOrdenAR = new ArrayList();
    }
    public void add(DetalleOrden DO){
       DetalleOrdenAR.add(DO); 
    }
    public DetalleOrden getDetalleOrden(int i){
        return DetalleOrdenAR.get(i);
    }
    public int sizeDetalleOrdenAR(){
        return DetalleOrdenAR.size();
    }
    public int sizePagoAR(){
        return PagoAR.size();
    }
    public void setDocTributario(DocTributario dt){
        DocTributario = dt;
    }
    public void setCliente(Cliente c){
        Cliente = c;
    }
    public float calcPrecio(){
        return calcPrecioSinIVA() + calcIVA();
    }
    public float calcPrecioSinIVA(){
        float aux = 0;
        for(int i=0;i<DetalleOrdenAR.size();i=i+1){
            aux = DetalleOrdenAR.get(i).calcPrecioSinIVA() + aux;
        }
        return aux;
    }
    public float calcIVA(){
        return (calcPrecioSinIVA() * 19) / 100;
    }
    public float calcPeso(){
        float aux = 0;
        for(int i=0;i<DetalleOrdenAR.size();i=i+1){
            aux = DetalleOrdenAR.get(i).calcPeso() + aux;
        }
        return aux;
    }
    public String toString(){
        return "Los datos de la Orden de Compra son\nEstado : " + estado + "\nFecha : " + fecha;
    }
}
        
public class Tarea1Prog2 {
    public static void main(String[] args) {
        Articulo A1 = new Articulo((float)0.7,"pantalon","azul", 50000);
        Articulo A2 = new Articulo((float)0.2,"polera","azul", 40000);
        Articulo A3 = new Articulo((float)0.7,"poleron","azul", 60000);
        Articulo A4 = new Articulo((float)0.8,"zapato","azul", 40000);
        Articulo A5 = new Articulo((float)0.1,"gorro","azul", 15000);
        
        Cliente C1 = new Cliente("Pedro","21.624.917-1");
        Direccion D1 = new Direccion("Los Nardos 5089, Talcahuano, Bío Bío");
        C1.setDireccion(D1);
        Cliente C2 = new Cliente("Juan","20.953.216-8");
        Direccion D2 = new Direccion("Volcán Copahue 574, Talcahuano, Bío Bío");
        C2.setDireccion(D2);
        
        Date F1 = new Date();
        
        OrdenCompra OC1 = new OrdenCompra(F1,"Entregado");
        DetalleOrden DO10 = new DetalleOrden(5);
        DO10.setArticulo(A5);
        DetalleOrden DO11 = new DetalleOrden(3);
        DO11.setArticulo(A2);
        DetalleOrden DO12 = new DetalleOrden(1);
        DO12.setArticulo(A1);
        OC1.add(DO10);
        OC1.add(DO11);
        OC1.add(DO12);
        Factura DT1 = new Factura("45174",C1.getrut(),F1);
        OC1.setDocTributario(DT1);
        Efectivo P1 = new Efectivo(300000,F1);
        
        OrdenCompra OC2 = new OrdenCompra(F1,"Entregado");
        DetalleOrden DO20 = new DetalleOrden(3);
        DO20.setArticulo(A1);
        DetalleOrden DO21 = new DetalleOrden(2);
        DO21.setArticulo(A3);
        OC2.add(DO20);
        OC2.add(DO21);
        Boleta DT2 = new Boleta("35134",C2.getrut(),F1);
        OC2.setDocTributario(DT2);
        Transferencia P2 = new Transferencia(12000,F1,"Estado","2109214");
        Transferencia P3 = new Transferencia(12000,F1,"Estado","2109214");
        
        OrdenCompra OC3 = new OrdenCompra(F1,"Entregado");
        DetalleOrden DO30 = new DetalleOrden(7);
        DO30.setArticulo(A4);
        OC3.add(DO30);
        Boleta DT3 = new Boleta("21374",C2.getrut(),F1);
        OC3.setDocTributario(DT3);
        Tarjeta P4 = new Tarjeta(12000,F1,"Debito","2184");
        
        
        
        System.out.println("Orden de compra 1\n" + OC1 + "\n\n" + C1 + "\n\n" + DT1 + "\n");
        for(int i=0;i<OC1.sizeDetalleOrdenAR();i=i+1){
            System.out.println("Detalle " + (i+1) + "\n" + OC1.getDetalleOrden(i) + "\n");
        }
        System.out.println("Peso total : " + OC1.calcPeso() 
                + "kg\nPrecio sin IVA : " + OC1.calcPrecioSinIVA() + "CLP\nIVA : " 
                + OC1.calcIVA() + "CLP\nPrecio total : " + OC1.calcPrecio() 
                + "CLP\nPago\n" + P1 + "CLP\nDevolucion : " 
                + P1.calcDevolucion(OC1.calcPrecio(),P1.getMonto()));
        
        System.out.print("\n---------------------------------------------------------------------------------\n");
        
        System.out.println("\nOrden de compra 2\n" + OC2 + "\n\n" + C2 + "\n\n" + DT2 + "\n");
        for(int i=0;i<OC2.sizeDetalleOrdenAR();i=i+1){
            System.out.println("Detalle " + (i+1) + "\n" + OC2.getDetalleOrden(i) + "\n");
        }
        System.out.println("Peso total : " + OC2.calcPeso() 
                + "kg\nPrecio sin IVA : " + OC2.calcPrecioSinIVA() + "CLP\nIVA : " 
                + OC2.calcIVA() + "CLP\nPrecio total : " + OC2.calcPrecio() 
                + "CLP\nPago 1\n" + P2 + "\nPago2\n" + P3);
        
        System.out.print("\n---------------------------------------------------------------------------------\n");
        
        System.out.println("\nOrden de compra 3\n" + OC3 + "\n\n" + C2 + "\n\n" + DT3 + "\n");
        for(int i=0;i<OC3.sizeDetalleOrdenAR();i=i+1){
            System.out.println("Detalle " + (i+1) + "\n" + OC3.getDetalleOrden(i) + "\n");
        }
        System.out.println("Peso total : " + OC3.calcPeso() 
                + "kg\nPrecio sin IVA : " + OC3.calcPrecioSinIVA() + "CLP\nIVA : " 
                + OC3.calcIVA() + "CLP\nPrecio total : " + OC3.calcPrecio() 
                + "CLP\nPago 1\n" + P4);
    }
    
}
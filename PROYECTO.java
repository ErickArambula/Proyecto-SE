
/*************************************************************************************************************

Diseñador:   Erick Alejandrop Arambula Saldaña 
Registro:    21110401
Grupo:       7.F
 

                                   Proyecto: "CONRTRL DE LIBROS"      
							  Titulo:  "MOSCOW BOOKS"								


**************************************************************************************************************/

import javax.swing.*;   //Necesario para diseñar ventanas
import java.awt.*;       //Neceasario para el manejo de fuentes color e imagen
import java.awt.event.*; //Necesario para disparar eventos 
import javax.swing.event.*;
import java.sql.*;       //Necesaria para la base de datos 


public class PROYECTO extends JFrame implements ActionListener, MouseListener, ItemListener, ChangeListener, FocusListener, KeyListener{

  public JPanel vista11, vista12, vista13,  vista21, vista22, vista23, vista31, vista32, vista33; 
  public JPanel vista121, vista221, vista321;

  public JTextArea TAregistroLibros, TAmodificarLibros, TAconsultarLibros; 
  public JTextArea TAregistroUsuarios, TAmodificarUsuarios, TAconsultarUsuarios;
  public JTextArea TAregistroPrestamos, TAmodificarPrestamos, TAconsultarPrestamos;
  public JTextArea TAactLibros, TAactPrestamos, TAactUsuarios;

  public JLabel ETHelp, etiqueta0, etiqueta, etiqueta1, etiqueta2, etiqueta3, etiqueta4, etiqueta5, etiqueta6;
  public JLabel ETlogo, ETportada1, ETportada2;

  public JButton botonP1, BregistrarL, BregistrarU, BbuscarL, BactL, BactP, BborrarL, BborrarU, BbuscarU, BactU;
  public JButton BguardarL, BguardarU, BverL, BverU, BverP, BregistrarP;
  public JButton BbuscarP, BborrarP, BbuscarL1, BbuscarU1, BbuscarP1, BguardarP;

  public ButtonGroup OPCusuario, OPCusuarioAct;
  public JRadioButton radio1, radio11, radio2, radio22, radio3, radio33;

  public JTextField CTcodigo, CTtitulo, CTautor, CTeditorial, CTcategoria, CTmodificarL;
  public JTextField CTnombre, CTdomicilio, CTtelefono, CTcorreo, CTmodificarU, CTmodificarP;
  public JTextField CTnombreAct, CTdomicilioAct, CTtelefonoAct, CTcorreoAct;
  public JTextField CTfecha, CTtelefonoPre, CTfechaAct;
  public JTextField CTtituloPre, CTtituloAct, CTautorAct, CTeditorialAct, CTcodigoAct; 
  public JTextField CTtelefonoBus, CTtelefonoBusPre, CTtituloActPre, CTtelefonoActPre;
  
  public JMenuBar MenuP;
  public JMenu LibrosM, UsuariosM, PrestamosM;
  public JMenuItem LibrosM1, LibrosM2, LibrosM3, UsuariosM1, UsuariosM2, UsuariosM3, PrestamosM1, PrestamosM2, PrestamosM3;
  
  public JComboBox <String> CBcategoria, CBcategoriaBus, CBcategoriaAct, CBplazo, CBplazoAct;

  public String Vcat, Vplazo, Vplazo1, Vplazo2, Vplazo3, Vsexo1, Vsexo2, Vsexo3, VcatAct, VcatCon;
  public String V1="hola";
  public String Vcodigo, Vtitulo, Vautor, Vcategoria, Veditorial;
  public String VcodigoAct, VtituloAct, VautorAct, VcategoriaAct, VeditorialAct;
  public String Vnombre, Vdomicilio, Vtelefono, Vcorreo, Vsexo;
  public String VnombreAct, VdomicilioAct, VtelefonoAct, VcorreoAct, VsexoAct;
  public String Vtitulo1, Vtelefono1, Vfecha, Vfecha1;
  public String Vtitulo2, Vtelefono2, Vfecha2;
  public String CadenaLibros, CadenaUsuarios, CadenaPrestamos;
  public String CadenaLibrosAct, CadenaUsuariosAct, CadenaPrestamosAct;

  public JScrollPane scrollL, scrollU, scrollP;

//-------------------------------------------------CONSTRUCTOR---------------------------------------------------

public PROYECTO(){
  setLayout(null);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setTitle("MOSCOW BOOKS");
  getContentPane().setBackground(Color.BLACK);    

 //******************DISEÑO DE MENU ITEMS**********************

  MenuP=new JMenuBar();
  setJMenuBar(MenuP);

 
  LibrosM=new JMenu("LIBROS    ");
  UsuariosM=new JMenu("USUARIOS    ");
  PrestamosM=new JMenu("PRESTAMOS    ");
  MenuP.add(LibrosM);
  MenuP.add(UsuariosM);
  MenuP.add(PrestamosM);
  
  LibrosM1=new JMenuItem("Registrar");
  LibrosM2=new JMenuItem("Modificar");
  LibrosM3=new JMenuItem("Consultar");

  UsuariosM1=new JMenuItem("Registrar");
  UsuariosM2=new JMenuItem("Modificar");
  UsuariosM3=new JMenuItem("Consultar");

  PrestamosM1=new JMenuItem("Solicitar");
  PrestamosM2=new JMenuItem("Modificar");
  PrestamosM3=new JMenuItem("Consultar");

  LibrosM.add(LibrosM1);
  LibrosM.add(LibrosM2);
  LibrosM.add(LibrosM3);

  UsuariosM.add(UsuariosM1);
  UsuariosM.add(UsuariosM2);
  UsuariosM.add(UsuariosM3);

  PrestamosM.add(PrestamosM1);
  PrestamosM.add(PrestamosM2);
  PrestamosM.add(PrestamosM3);

  LibrosM1.addActionListener(this);
  LibrosM2.addActionListener(this);
  LibrosM3.addActionListener(this);
  UsuariosM1.addActionListener(this);
  UsuariosM2.addActionListener(this);
  UsuariosM3.addActionListener(this);
  PrestamosM1.addActionListener(this);
  PrestamosM2.addActionListener(this);
  PrestamosM3.addActionListener(this);

 //******************DISEÑO DE VISTAS**********************

 //*******************VISA 1******************************
  
  vista11=new JPanel();
  vista11.setLayout(null);
  vista11.setBounds(0,30,1000,520);
  vista11.setBackground(Color.YELLOW);
  vista11.setVisible(false); 
  add(vista11);

   etiqueta=new JLabel("REGISTRO DE LIBROS:");
  etiqueta.setBounds(30,30,180,30);
  vista11.add(etiqueta);
   etiqueta1=new JLabel("Codigo:");
  etiqueta1.setBounds(60,90,180,15);
  vista11.add(etiqueta1);
   etiqueta2=new JLabel("Titulo:");
  etiqueta2.setBounds(60,125,180,15);
  vista11.add(etiqueta2);
   etiqueta3=new JLabel("Autor:");
  etiqueta3.setBounds(60,160,180,15);
  vista11.add(etiqueta3);
   etiqueta4=new JLabel("Editorial:");
  etiqueta4.setBounds(60,195,180,15);
  vista11.add(etiqueta4);
   etiqueta5=new JLabel("Categoria:");
  etiqueta5.setBounds(60,230,180,15);
  vista11.add(etiqueta5);

  CTcodigo=new JTextField();
  CTcodigo.setBounds(130,87,185,25);
  vista11.add(CTcodigo);
  CTtitulo=new JTextField();
  CTtitulo.setBounds(130,122,185,25);
  vista11.add(CTtitulo);
  CTautor=new JTextField();
  CTautor.setBounds(130,157,185,25);
  vista11.add(CTautor);
  CTeditorial=new JTextField();
  CTeditorial.setBounds(130,192,185,25);
  vista11.add(CTeditorial);

  CBcategoria=new JComboBox <String>();
  CBcategoria.setBounds(130,227,185,25);
  vista11.add(CBcategoria);
  CBcategoria.setEditable(true);
  CBcategoria.setSelectedItem("      seleccione...");
  CBcategoria.setEditable(false);
  CBcategoria.addItem("Filosofia");
  CBcategoria.addItem("Ciencias exactas");
  CBcategoria.addItem("Ciencias naturales");
  CBcategoria.addItem("Ciencias de la salud");
  CBcategoria.addItem("Arte");
  CBcategoria.addItem("Biografia");
  CBcategoria.addItem("Novela");
  CBcategoria.addItem("Economia");
  CBcategoria.addItem("Literatura");
  CBcategoria.addItem("Diccionario");
  CBcategoria.addItem("Autoayuda");
  CBcategoria.addItem("Derecho");
  CBcategoria.addItem("Otro");

  BregistrarL=new JButton("REGISTRAR LIBRO");
  BregistrarL.setBounds(65,280,220,35);
  vista11.add(BregistrarL);

  TAregistroLibros=new JTextArea();
  TAregistroLibros.setBounds(340,38,300,400);	
  TAregistroLibros.setEditable(false);
  vista11.add(TAregistroLibros);

//-------------------------------------

  vista12=new JPanel();
  vista12.setLayout(null);
  vista12.setBounds(0,30,1000,520);
  vista12.setBackground(Color.YELLOW);
  vista12.setVisible(false);
  add(vista12);
  
   etiqueta=new JLabel("MODIFICAR LIBROS:");
  etiqueta.setBounds(30,30,180,30);
  vista12.add(etiqueta);
   etiqueta1=new JLabel("Escribe el codigo del libro que deseas modificar:");
  etiqueta1.setBounds(40,90,300,15);
  vista12.add(etiqueta1);
   etiqueta2=new JLabel("Codigo:");
  etiqueta2.setBounds(60,125,180,15);
  vista12.add(etiqueta2);
   
  CTmodificarL=new JTextField();
  CTmodificarL.setBounds(130,122,185,25);
  vista12.add(CTmodificarL);

  BbuscarL=new JButton("Buscar");
  BbuscarL.setBounds(65,175,200,25);
  vista12.add(BbuscarL);
  
  BborrarL=new JButton("Borrar");
  BborrarL.setBounds(20,280,150,35);
  vista12.add(BborrarL);
 
  BactL=new JButton("Actualizar");
  BactL.setBounds(180,280,150,35);
  vista12.add(BactL);

  TAmodificarLibros=new JTextArea();
  TAmodificarLibros.setBounds(340,38,300,400);	
  TAmodificarLibros.setEditable(false);
  vista12.add(TAmodificarLibros);

//--------------------------------------

  vista13=new JPanel();
  vista13.setLayout(null);
  vista13.setBounds(0,30,1000,520);
  vista13.setBackground(Color.YELLOW);
  vista13.setVisible(false);
  add(vista13);
   
   etiqueta=new JLabel("CONSULTAR	 LIBROS:");
  etiqueta.setBounds(30,30,180,30);
  vista13.add(etiqueta);
   etiqueta1=new JLabel("Seleccione la categoria del libro que deseas buscar:");
  etiqueta1.setBounds(40,90,300,15);
  vista13.add(etiqueta1);
   etiqueta2=new JLabel("Categoria:");
  etiqueta2.setBounds(60,125,180,15);
  vista13.add(etiqueta2);
   
  CBcategoriaBus=new JComboBox <String>();
  CBcategoriaBus.setBounds(130,122,185,25);
  vista13.add(CBcategoriaBus);
  CBcategoriaBus.setEditable(true);
  CBcategoriaBus.setSelectedItem("      seleccione...");
  CBcategoriaBus.setEditable(false);
  CBcategoriaBus.addItem("Filosofia");
  CBcategoriaBus.addItem("Ciencias exactas");
  CBcategoriaBus.addItem("Ciencias naturales");
  CBcategoriaBus.addItem("Ciencias de la salud");
  CBcategoriaBus.addItem("Arte");
  CBcategoriaBus.addItem("Biografia");
  CBcategoriaBus.addItem("Novela");
  CBcategoriaBus.addItem("Economia");
  CBcategoriaBus.addItem("Literatura");
  CBcategoriaBus.addItem("Diccionario");
  CBcategoriaBus.addItem("Autoayuda");
  CBcategoriaBus.addItem("Derecho");
  CBcategoriaBus.addItem("Otro");

  BbuscarL1=new JButton("Buscar");
  BbuscarL1.setBounds(65,175,200,25);
  vista13.add(BbuscarL1);

  BverL=new JButton("Ver todos");
  BverL.setBounds(65,340,200,32);
  vista13.add(BverL);

  TAconsultarLibros=new JTextArea();
  scrollL=new JScrollPane(TAconsultarLibros);
  scrollL.setBounds(340,38,300,400);	
  TAconsultarLibros.setEditable(false);
  vista13.add(scrollL);

 //*******************VISA 2******************************
  
  vista21=new JPanel();
  vista21.setLayout(null);
  vista21.setBounds(0,30,1000,520);
  vista21.setBackground(Color.GREEN);
  vista21.setVisible(false);
  add(vista21);

   etiqueta=new JLabel("REGISTRO DE USUARIO	:");
  etiqueta.setBounds(30,30,180,30);
  vista21.add(etiqueta);
   etiqueta1=new JLabel("Nombre:");
  etiqueta1.setBounds(60,90,180,15);
  vista21.add(etiqueta1);
   etiqueta2=new JLabel("Domicilio:");
  etiqueta2.setBounds(60,125,180,15);
  vista21.add(etiqueta2);
   etiqueta3=new JLabel("Telefono:");
  etiqueta3.setBounds(60,160,180,15);
  vista21.add(etiqueta3);
   etiqueta4=new JLabel("E-mail:");
  etiqueta4.setBounds(60,195,180,15);
  vista21.add(etiqueta4);
   etiqueta5=new JLabel("Sexo:");
  etiqueta5.setBounds(60,230,180,15);
  vista21.add(etiqueta5);


  CTnombre=new JTextField();
  CTnombre.setBounds(130,87,185,25);
  vista21.add(CTnombre);
  CTdomicilio=new JTextField();
  CTdomicilio.setBounds(130,122,185,25);
  vista21.add(CTdomicilio);
  CTtelefono=new JTextField();
  CTtelefono.setBounds(130,157,185,25);
  vista21.add(CTtelefono);
  CTcorreo=new JTextField();
  CTcorreo.setBounds(130,192,185,25);
  vista21.add(CTcorreo);

  OPCusuario=new ButtonGroup();
  radio1=new JRadioButton("Masculino");
  radio1.setBounds(60,250,110,20);
  vista21.add(radio1);
  OPCusuario.add(radio1);

  radio2=new JRadioButton("Femenino");
  radio2.setBounds(60,270,110,20);
  vista21.add(radio2);
  OPCusuario.add(radio2);
  radio3=new JRadioButton("Otro");
  radio3.setBounds(60,290,110,20);
  vista21.add(radio3);
  OPCusuario.add(radio3);

  BregistrarU=new JButton("REGISTRAR USUARIO");
  BregistrarU.setBounds(65,320,220,35);
  vista21.add(BregistrarU);

  TAregistroUsuarios=new JTextArea();
  TAregistroUsuarios.setBounds(340,38,300,400);	
  TAregistroUsuarios.setEditable(false);
  vista21.add(TAregistroUsuarios);

//-------------------------------------------

  vista22=new JPanel();
  vista22.setLayout(null);
  vista22.setBounds(0,30,1000,520);
  vista22.setBackground(Color.GREEN);
  vista22.setVisible(false);
  add(vista22);
    
   etiqueta=new JLabel("MODIFICAR USUARIOS:");
  etiqueta.setBounds(30,30,180,30);
  vista22.add(etiqueta);
   etiqueta1=new JLabel("Escribe el telefono del usuario que deseas modificar:");
  etiqueta1.setBounds(40,90,300,15);
  vista22.add(etiqueta1);
   etiqueta2=new JLabel("Telefono:");
  etiqueta2.setBounds(60,125,180,15);
  vista22.add(etiqueta2);
   
  CTmodificarU=new JTextField();
  CTmodificarU.setBounds(130,122,185,25);
  vista22.add(CTmodificarU);

  BbuscarU=new JButton("Buscar");
  BbuscarU.setBounds(65,175,200,25);
  vista22.add(BbuscarU);
  
  BborrarU=new JButton("Borrar");
  BborrarU.setBounds(20,280,150,35);
  vista22.add(BborrarU);
 
  BactU=new JButton("Actualizar");
  BactU.setBounds(180,280,150,35);
  vista22.add(BactU);

  TAmodificarUsuarios=new JTextArea();
  TAmodificarUsuarios.setBounds(350,38,290,400);	
  TAmodificarUsuarios.setEditable(false);
  vista22.add(TAmodificarUsuarios);


//-----------------------------------------------

  vista23=new JPanel();
  vista23.setLayout(null);
  vista23.setBounds(0,30,1000,520);
  vista23.setBackground(Color.GREEN);
  vista23.setVisible(false);
  add(vista23);
   etiqueta=new JLabel("CONSULTAR  USUARIOS:");
  etiqueta.setBounds(30,30,180,30);
  vista23.add(etiqueta);
   etiqueta1=new JLabel("Escribe el numero del usuario que deseas buscar:");
  etiqueta1.setBounds(40,90,300,15);
  vista23.add(etiqueta1);
   etiqueta2=new JLabel("Numero:");
  etiqueta2.setBounds(60,125,180,15);
  vista23.add(etiqueta2);
   
  CTtelefonoBus=new JTextField();
  CTtelefonoBus.setBounds(130,122,185,25);
  vista23.add(CTtelefonoBus);

  BbuscarU1=new JButton("Buscar");
  BbuscarU1.setBounds(65,175,200,25);
  vista23.add(BbuscarU1);

  BverU=new JButton("Ver todos");
  BverU.setBounds(65,340,200,32);
  vista23.add(BverU);

  TAconsultarUsuarios=new JTextArea();
  scrollU=new JScrollPane(TAconsultarUsuarios);
  scrollU.setBounds(340,38,300,400);	
  TAconsultarUsuarios.setEditable(false);
  vista23.add(scrollU);

 //*******************VISA 3******************************
  
  vista31=new JPanel();
  vista31.setLayout(null);
  vista31.setBounds(0,30,1000,520);
  vista31.setBackground(Color.RED);
  vista31.setVisible(false);
  add(vista31);
   etiqueta=new JLabel("SOLICITUD DE PRERSTAMO:");
  etiqueta.setBounds(30,30,180,30);
  vista31.add(etiqueta);
   etiqueta1=new JLabel("Titulo:");
  etiqueta1.setBounds(60,90,180,15);
  vista31.add(etiqueta1);
   etiqueta2=new JLabel("Telefono:");
  etiqueta2.setBounds(60,125,180,15);
  vista31.add(etiqueta2);
   etiqueta3=new JLabel("Fecha:");
  etiqueta3.setBounds(60,160,180,15);
  vista31.add(etiqueta3);
   etiqueta4=new JLabel("Plazo:");
  etiqueta4.setBounds(60,195,180,15);
  vista31.add(etiqueta4);

  CTtituloPre=new JTextField();
  CTtituloPre.setBounds(130,87,185,25);
  vista31.add(CTtituloPre);
  CTtelefonoPre=new JTextField();
  CTtelefonoPre.setBounds(130,122,185,25);
  vista31.add(CTtelefonoPre);
  CTfecha=new JTextField();
  CTfecha.setBounds(130,157,185,25);
  vista31.add(CTfecha);

  CBplazo=new JComboBox <String>();
  CBplazo.setBounds(130,192,185,25);
  vista31.add(CBplazo);
  CBplazo.setEditable(true);
  CBplazo.setSelectedItem("      seleccione...");
  CBplazo.setEditable(false);
  CBplazo.addItem("3 Dias");
  CBplazo.addItem("5 Dias");
  CBplazo.addItem("10 Dias");
  CBplazo.addItem("15 Dias");
  CBplazo.addItem("30 Dias");
  CBplazo.addItem("No especificado");

  BregistrarP=new JButton("SOLICITAR PRESTAMO");
  BregistrarP.setBounds(65,280,220,35);
  vista31.add(BregistrarP);

  TAregistroPrestamos=new JTextArea();
  TAregistroPrestamos.setBounds(340,38,300,400);	
  TAregistroPrestamos.setEditable(false);
  vista31.add(TAregistroPrestamos); 

//--------------------------------------------

  vista32=new JPanel();
  vista32.setLayout(null);
  vista32.setBounds(0,30,1000,520);
  vista32.setBackground(Color.RED);
  vista32.setVisible(false);
  add(vista32);
   etiqueta=new JLabel("MODIFICAR PRESATAMO:");
  etiqueta.setBounds(30,30,180,30);
  vista32.add(etiqueta);
   etiqueta1=new JLabel("Escribe el numero de telefono del usuario:");
  etiqueta1.setBounds(40,90,300,15);
  vista32.add(etiqueta1);
   etiqueta2=new JLabel("Telefono:");
  etiqueta2.setBounds(60,125,180,15);
  vista32.add(etiqueta2);
   
  CTmodificarP=new JTextField();
  CTmodificarP.setBounds(130,122,185,25);
  vista32.add(CTmodificarP);

  BbuscarP=new JButton("Buscar");
  BbuscarP.setBounds(65,175,200,25);
  vista32.add(BbuscarP);
  
  BborrarP=new JButton("Borrar");
  BborrarP.setBounds(20,280,150,35);
  vista32.add(BborrarP);
 
  BactP=new JButton("Actualizar");
  BactP.setBounds(180,280,150,35);
  vista32.add(BactP);

  TAmodificarPrestamos=new JTextArea();
  TAmodificarPrestamos.setBounds(340,38,300,400);	
  TAmodificarPrestamos.setEditable(false);
  vista32.add(TAmodificarPrestamos);

//---------------------------------------------

  vista33=new JPanel();
  vista33.setLayout(null);
  vista33.setBounds(0,30,1000,520);
  vista33.setBackground(Color.RED);
  vista33.setVisible(false);
  add(vista33);
   etiqueta=new JLabel("CONSULTAR	 PRESTAMOS:");
  etiqueta.setBounds(30,30,180,30);
  vista33.add(etiqueta);
   etiqueta1=new JLabel("Escribe el numero del usuario que deseas buscar:");
  etiqueta1.setBounds(40,90,300,15);
  vista33.add(etiqueta1);
   etiqueta2=new JLabel("Numero:");
  etiqueta2.setBounds(60,125,180,15);
  vista33.add(etiqueta2);
   
  CTtelefonoBusPre=new JTextField();
  CTtelefonoBusPre.setBounds(130,122,185,25);
  vista33.add(CTtelefonoBusPre);

  BbuscarP1=new JButton("Buscar");
  BbuscarP1.setBounds(65,175,200,25);
  vista33.add(BbuscarP1);

  BverP=new JButton("Ver todos");
  BverP.setBounds(65,340,200,32);
  vista33.add(BverP);

  TAconsultarPrestamos=new JTextArea();
  scrollP=new JScrollPane(TAconsultarPrestamos);
  scrollP.setBounds(340,38,300,400);	
  TAconsultarPrestamos.setEditable(false);
  vista33.add(scrollP);

//******************VISTAS SECUNDARIAS**********************

vista121=new JPanel();
  vista121.setLayout(null);
  vista121.setBounds(0,30,1000,520);
  vista121.setBackground(Color.YELLOW);
  vista121.setVisible(false);
  add(vista121);  
   etiqueta=new JLabel("ACTUALIZAR LIBRO");
  etiqueta.setBounds(30,30,180,30);
  vista121.add(etiqueta);
   etiqueta1=new JLabel("Ingresa los nuevos datos del libro:");
  etiqueta1.setBounds(45,68,250,15);
  vista121.add(etiqueta1);
   etiqueta2=new JLabel("Titulo:");
  etiqueta2.setBounds(60,125,180,15);
  vista121.add(etiqueta2);
   etiqueta3=new JLabel("Autor:");
  etiqueta3.setBounds(60,160,180,15);
  vista121.add(etiqueta3);
   etiqueta4=new JLabel("Editorial:");
  etiqueta4.setBounds(60,195,180,15);
  vista121.add(etiqueta4);
   etiqueta5=new JLabel("Categoria:");
  etiqueta5.setBounds(60,230,180,15);
  vista121.add(etiqueta5);
  /* etiqueta6=new JLabel("Codigo:");
  etiqueta6.setBounds(60,90,180,15);
  vista121.add(etiqueta6);*/


  CTtituloAct=new JTextField();
  CTtituloAct.setBounds(130,122,185,25);
  vista121.add(CTtituloAct);
  CTautorAct=new JTextField();
  CTautorAct.setBounds(130,157,185,25);
  vista121.add(CTautorAct);
  CTeditorialAct=new JTextField();
  CTeditorialAct.setBounds(130,192,185,25);
  vista121.add(CTeditorialAct);
  /*CTcodigoAct=new JTextField();
  CTcodigoAct.setBounds(130,88,185,25);
  vista121.add(CTcodigoAct);*/

  CBcategoriaAct=new JComboBox <String>();
  CBcategoriaAct.setBounds(130,227,185,25);
  vista121.add(CBcategoriaAct);
  CBcategoriaAct.setEditable(true);
  CBcategoriaAct.setSelectedItem("      seleccione...");
  CBcategoriaAct.setEditable(false);
  CBcategoriaAct.addItem("Filosofia");
  CBcategoriaAct.addItem("Ciencias exactas");
  CBcategoriaAct.addItem("Ciencias naturales");
  CBcategoriaAct.addItem("Ciencias de la salud");
  CBcategoriaAct.addItem("Arte");
  CBcategoriaAct.addItem("Biografia");
  CBcategoriaAct.addItem("Novela");
  CBcategoriaAct.addItem("Economia");
  CBcategoriaAct.addItem("Literatura");
  CBcategoriaAct.addItem("Diccionario");
  CBcategoriaAct.addItem("Autoayuda");
  CBcategoriaAct.addItem("Derecho");
  CBcategoriaAct.addItem("Otro");

  BguardarL=new JButton("GUARDAR");
  BguardarL.setBounds(65,280,220,35);
  vista121.add(BguardarL);

  TAactLibros=new JTextArea();
  TAactLibros.setBounds(340,38,300,400);	
  TAactLibros.setEditable(false);
  vista121.add(TAactLibros);
//----------------------------------------------------------------

vista221=new JPanel();
  vista221.setLayout(null);
  vista221.setBounds(0,30,1000,520);
  vista221.setBackground(Color.GREEN);
  vista221.setVisible(false);
  add(vista221);
   etiqueta0=new JLabel("Ingresa los nuevos datos del usuario:");
  etiqueta0.setBounds(45,70,250,15);
  vista221.add(etiqueta0);
   etiqueta=new JLabel("ACTUALIZAR USUARIO	:");
  etiqueta.setBounds(30,30,180,30);
  vista221.add(etiqueta);
   etiqueta1=new JLabel("Nombre:");
  etiqueta1.setBounds(60,90,180,15);
  vista221.add(etiqueta1);
   etiqueta2=new JLabel("Domicilio:");
  etiqueta2.setBounds(60,125,180,15);
  vista221.add(etiqueta2);
   etiqueta3=new JLabel("Telefono:");
  etiqueta3.setBounds(60,160,180,15);
  vista221.add(etiqueta3);
   etiqueta4=new JLabel("E-mail:");
  etiqueta4.setBounds(60,195,180,15);
  vista221.add(etiqueta4);
   etiqueta5=new JLabel("Sexo:");
  etiqueta5.setBounds(60,230,180,15);
  vista221.add(etiqueta5);

  CTnombreAct=new JTextField();
  CTnombreAct.setBounds(130,87,185,25);
  vista221.add(CTnombreAct);
  CTdomicilioAct=new JTextField();
  CTdomicilioAct.setBounds(130,122,185,25);
  vista221.add(CTdomicilioAct);
  CTtelefonoAct=new JTextField();
  CTtelefonoAct.setBounds(130,157,185,25);
  vista221.add(CTtelefonoAct);
  CTcorreoAct=new JTextField();
  CTcorreoAct.setBounds(130,192,185,25);
  vista221.add(CTcorreoAct);

  OPCusuarioAct=new ButtonGroup();
  radio11=new JRadioButton("Masculino");
  radio11.setBounds(60,250,110,20);
  vista221.add(radio11);
  OPCusuarioAct.add(radio11);

  radio22=new JRadioButton("Femenino");
  radio22.setBounds(60,270,110,20);
  vista221.add(radio22);
  OPCusuarioAct.add(radio22);
  radio33=new JRadioButton("Otro");
  radio33.setBounds(60,290,110,20);
  vista221.add(radio33);
  OPCusuarioAct.add(radio33);

  BguardarU=new JButton("GUARDAR");
  BguardarU.setBounds(65,320,220,35);
  vista221.add(BguardarU);

  TAactUsuarios=new JTextArea();
  TAactUsuarios.setBounds(340,38,300,400);	
  TAactUsuarios.setEditable(false);
  vista221.add(TAactUsuarios);

//---------------------------------------------------------------

vista321=new JPanel();
  vista321.setLayout(null);
  vista321.setBounds(0,30,1000,520);
  vista321.setBackground(Color.RED);
  vista321.setVisible(false);
  add(vista321);
   etiqueta=new JLabel("MODIFICAR PRERSTAMO:");
  etiqueta.setBounds(30,30,180,30);
  vista321.add(etiqueta);
   etiqueta1=new JLabel("Titulo:");
  etiqueta1.setBounds(60,90,180,15);
  vista321.add(etiqueta1);
   etiqueta2=new JLabel("Telefono:");
  etiqueta2.setBounds(60,125,180,15);
  vista321.add(etiqueta2);
   etiqueta3=new JLabel("Fecha:");
  etiqueta3.setBounds(60,160,180,15);
  vista321.add(etiqueta3);
   etiqueta4=new JLabel("Plazo:");
  etiqueta4.setBounds(60,195,180,15);
  vista321.add(etiqueta4);
   etiqueta5=new JLabel("Ingresa los nuevos datos del prestamo:");
  etiqueta5.setBounds(45,60,300,15);
  vista321.add(etiqueta5);

  CTtituloActPre=new JTextField();
  CTtituloActPre.setBounds(130,87,185,25);
  vista321.add(CTtituloActPre);
  CTtelefonoActPre=new JTextField();
  CTtelefonoActPre.setBounds(130,122,185,25);
  vista321.add(CTtelefonoActPre);
  CTfechaAct=new JTextField();
  CTfechaAct.setBounds(130,157,185,25);
  vista321.add(CTfechaAct);

  CBplazoAct=new JComboBox <String>();
  CBplazoAct.setBounds(130,192,185,25);
  vista321.add(CBplazoAct);
  CBplazoAct.setEditable(true);
  CBplazoAct.setSelectedItem("      seleccione...");
  CBplazoAct.setEditable(false);
  CBplazoAct.addItem("3 Dias");
  CBplazoAct.addItem("5 Dias");
  CBplazoAct.addItem("10 Dias");
  CBplazoAct.addItem("15 Dias");
  CBplazoAct.addItem("30 Dias");
  CBplazoAct.addItem("No especificado");

  BguardarP=new JButton("GUARDAR");
  BguardarP.setBounds(65,280,220,35);
  vista321.add(BguardarP);

  TAactPrestamos=new JTextArea();
  TAactPrestamos.setBounds(340,38,300,400);	
  TAactPrestamos.setEditable(false);
  vista321.add(TAactPrestamos);


 //---------------------------------------------------------------------------- 
  

//*******************************DISEÑO DE IMAGENES******************************
 
  setIconImage(new ImageIcon(getClass().getResource("MB_ICONO.PNG")).getImage());
 
  ImageIcon imagen =new ImageIcon("MOSCOW_BOOKS_LOGO.PNG");
  ETlogo=new JLabel(imagen);
  ETlogo.setBounds(15,25,300,60); 
  Icon icono=new ImageIcon(imagen.getImage().getScaledInstance(ETlogo.getWidth(),ETlogo.getHeight(),Image.SCALE_DEFAULT)); 
  ETlogo.setIcon(icono);
  add(ETlogo);

  ImageIcon imagen1 =new ImageIcon("IMAGEN_PORTADA1.PNG");
  ETportada1=new JLabel(imagen1);
  ETportada1.setBounds(40,70,590,220); 
  Icon icono1=new ImageIcon(imagen1.getImage().getScaledInstance(ETportada1.getWidth(),ETportada1.getHeight(),Image.SCALE_DEFAULT)); 
  ETportada1.setIcon(icono1);
  add(ETportada1);

  ImageIcon imagen2 =new ImageIcon("IMAGEN_PORTADA2.PNG");
  ETportada2=new JLabel(imagen2);
  ETportada2.setBounds(100,295,480,150); 
  Icon icono2=new ImageIcon(imagen2.getImage().getScaledInstance(ETportada2.getWidth(),ETportada2.getHeight(),Image.SCALE_DEFAULT)); 
  ETportada2.setIcon(icono2);
  add(ETportada2);

//--------------------------------------------------------------------------------


  botonP1=new JButton("Pagina Principal");
  botonP1.setBounds(285,5,150,20);
  add(botonP1);

  /*botonP2=new JButton("USUARIOS");
  botonP2.setBounds(140,5,120,20);
  add(botonP2);

  botonP3=new JButton("PRESTAMOS");
  botonP3.setBounds(270,5,120,20);
  add(botonP3);*/

  ETHelp=new JLabel("Help ( ! )");
  ETHelp.setBounds(585,10,180,15);
  ETHelp.setForeground(Color.YELLOW);
  add(ETHelp);

  BregistrarL.addActionListener(this);
  BregistrarU.addActionListener(this);
  BregistrarP.addActionListener(this);
  BbuscarL.addActionListener(this);
  BbuscarL1.addActionListener(this);
  BbuscarU.addActionListener(this);
  BbuscarU1.addActionListener(this);
  BbuscarP.addActionListener(this);
  BbuscarP1.addActionListener(this);
  BborrarL.addActionListener(this);
  BborrarU.addActionListener(this);
  BborrarP.addActionListener(this);
  BactL.addActionListener(this);
  BactP.addActionListener(this);
  BactU.addActionListener(this);
  BguardarL.addActionListener(this);
  BguardarU.addActionListener(this);
  BguardarP.addActionListener(this);
  BverL.addActionListener(this);
  BverU.addActionListener(this);
  BverP.addActionListener(this);
  botonP1.addActionListener(this);
  ETHelp.addMouseListener(this);

  radio1.addChangeListener(this);
  radio2.addChangeListener(this);
  radio3.addChangeListener(this);
  radio11.addChangeListener(this);
  radio22.addChangeListener(this);
  radio33.addChangeListener(this);

  CBcategoria.addItemListener(this);
  CBcategoriaBus.addItemListener(this);
  CBcategoriaAct.addItemListener(this);
  CBplazo.addItemListener(this);
  CBplazoAct.addItemListener(this);

  CTcodigo.addFocusListener(this);
  CTtitulo.addFocusListener(this);
  CTautor.addFocusListener(this);
  CTeditorial.addFocusListener(this);
  CTtituloAct.addFocusListener(this);
  CTautorAct.addFocusListener(this);
  CTeditorialAct.addFocusListener(this);
  CTnombre.addFocusListener(this);
  CTdomicilio.addFocusListener(this);
  CTtelefono.addFocusListener(this);
  CTcorreo.addFocusListener(this);
  CTnombreAct.addFocusListener(this);
  CTdomicilioAct.addFocusListener(this);
  CTtelefonoAct.addFocusListener(this);
  CTcorreoAct.addFocusListener(this);
  CTtituloPre.addFocusListener(this);
  CTtelefonoPre.addFocusListener(this);
  CTfecha.addFocusListener(this);
  CTtituloActPre.addFocusListener(this);
  CTtelefonoActPre.addFocusListener(this);
  CTfechaAct.addFocusListener(this);

  addKeyListener(this);
  setFocusable(true);


}//Fin del constructor 


//------------------------------------KEY -------------------------------------------

public void keyPressed(KeyEvent t){
}  

public void keyReleased(KeyEvent e){ 
  int codigo=e.getKeyCode();
  System.out.println(codigo);

  if(e.getKeyCode()==27){
	System.exit(0);
  }
}

public void keyTyped(KeyEvent e){}

//************************Fin de metodo Key **************************



//------------------------------------MOUSE LISTENER-------------------------------------------

	public void mouseEntered(MouseEvent accion){
	}

	public void mouseExited(MouseEvent accion){
	}

	public void mousePressed(MouseEvent e){
	  if(e.getSource()==ETHelp){
		JOptionPane.showMessageDialog(null,"En la parte superior encuentras tres apartados principales de este programa:\n      LIBROS: En este apartado podras registrar, modificar y consultar los libros de la biblioteca.\n      USUARIOS: En este apartado tendras la oportunidad de dar de alta un nuevo usuario asi como modificar y consultar los datos de los mismos.\n      PRESTAMOS: En el apartado de prestamos es donde podras solicitar la disponibilidad y el prestamo de algun libro deseado asi como el modificarlo.");
  	  }
	}

	public void mouseReleased(MouseEvent accion){
	}

	public void mouseClicked(MouseEvent accion){
	}

//************************Fin de metodos Mouse Listener**************************


//------------------------------------FOCUS-------------------------------------------

public void focusGained(FocusEvent e){}

public void focusLost(FocusEvent e){
  String cadena1= CTcodigo.getText();
  String cadena2= CTtitulo.getText();
  String cadena3= CTautor.getText();
  String cadena4= CTeditorial.getText();
  String cadena5= CTtituloAct.getText();
  String cadena6= CTautorAct.getText();
  String cadena7= CTeditorialAct.getText();

  String cadena8= CTnombre.getText();
  String cadena9= CTdomicilio.getText();
  String cadena10= CTtelefono.getText();
  String cadena11= CTcorreo.getText();
  String cadena12= CTnombreAct.getText();
  String cadena13= CTdomicilioAct.getText();
  String cadena14= CTtelefonoAct.getText();
  String cadena15= CTcorreoAct.getText();

  String cadena16= CTtituloPre.getText();
  String cadena17= CTtelefonoPre.getText();
  String cadena18= CTfecha.getText();
  String cadena19= CTtituloActPre.getText();
  String cadena20= CTtelefonoActPre.getText();
  String cadena21= CTfechaAct.getText();

  //----------------------------------------
  if(cadena1.equals("")){
	BregistrarL.setEnabled(false);
  }else{
	BregistrarL.setEnabled(true);
  }

  if(cadena2.equals("")){
	BregistrarL.setEnabled(false);
  }else{
	BregistrarL.setEnabled(true);
  }

  if(cadena3.equals("")){
	BregistrarL.setEnabled(false);
  }else{
	BregistrarL.setEnabled(true);
  }

  if(cadena4.equals("")){
	BregistrarL.setEnabled(false);
  }else{
	BregistrarL.setEnabled(true);
  }

//---------------------------------------------
  if(cadena5.equals("")){
	BguardarL.setEnabled(false);
  }else{
	BguardarL.setEnabled(true);
  }

  if(cadena6.equals("")){
	BguardarL.setEnabled(false);
  }else{
	BguardarL.setEnabled(true);
  }

  if(cadena7.equals("")){
	BguardarL.setEnabled(false);
  }else{
	BguardarL.setEnabled(true);
  }
//--------------------------------------------

  if(cadena8.equals("")){
	BregistrarU.setEnabled(false);
  }else{
	BregistrarU.setEnabled(true);
  }

  if(cadena9.equals("")){
	BregistrarU.setEnabled(false);
  }else{
	BregistrarU.setEnabled(true);
  }

  if(cadena10.equals("")){
	BregistrarU.setEnabled(false);
  }else{
	BregistrarU.setEnabled(true);
  }

  if(cadena11.equals("")){
	BregistrarU.setEnabled(false);
  }else{
	BregistrarU.setEnabled(true);
  }

//--------------------------------------------

  if(cadena12.equals("")){
	BguardarU.setEnabled(false);
  }else{
	BguardarU.setEnabled(true);
  }

  if(cadena13.equals("")){
	BguardarU.setEnabled(false);
  }else{
	BguardarU.setEnabled(true);
  }

  if(cadena17.equals("")){
	BguardarU.setEnabled(false);
  }else{
	BguardarU.setEnabled(true);
  }

  if(cadena15.equals("")){
	BguardarU.setEnabled(false);
  }else{
	BguardarU.setEnabled(true);
  }

//--------------------------------------------

}//Fin de Focus lost

//************************Fin de metodo focus **************************



//------------------------------------STATE CHANGED-------------------------------------------
	
  	public void stateChanged(ChangeEvent evento){

		if(radio1.isSelected()==true){
	  	  Vsexo1="";
	 	  Vsexo1="Masculino";
	  	}
     		if(radio2.isSelected()==true){
	    	  Vsexo1="";
	 	  Vsexo1="Femenino";
		}
     		if(radio3.isSelected()==true){
	  	  Vsexo1="";
	 	  Vsexo1="Otro";
		}
		if(radio11.isSelected()==true){
		  Vsexo2="";
	 	  Vsexo2="Masculino";
	  	}
     		if(radio22.isSelected()==true){
		  Vsexo2="";
	 	  Vsexo2="Femenino";
		}
     		if(radio33.isSelected()==true){
		  Vsexo2="";
	 	  Vsexo2="Otro";
		}
	}
	
//************************Fin de metodo state changed**************************

//------------------------------------ITEM STATE CHANGED-------------------------------------------

  	public void itemStateChanged(ItemEvent accion){
	  	Vcat="";
		Vcat=CBcategoria.getSelectedItem().toString();
	  	VcatAct="";
		VcatAct=CBcategoriaAct.getSelectedItem().toString();
		VcatCon="";
		VcatCon=CBcategoriaBus.getSelectedItem().toString();
		Vplazo="";
		Vplazo=CBplazo.getSelectedItem().toString();
		Vplazo2="";
		Vplazo2=CBplazoAct.getSelectedItem().toString();
	}
	
//************************Fin de metodo item state changed**************************



//------------------------------------ACTION PERFORMED-------------------------------------------

public void actionPerformed(ActionEvent accion){
	
  	if(accion.getSource()==botonP1){
	  vista11.setVisible(false);
	  vista12.setVisible(false);
	  vista13.setVisible(false);
	  vista21.setVisible(false);
	  vista22.setVisible(false);
	  vista23.setVisible(false);
	  vista31.setVisible(false);
	  vista32.setVisible(false);
	  vista33.setVisible(false); 
	  vista121.setVisible(false);
	  vista221.setVisible(false);
	  vista321.setVisible(false);
	  TAregistroLibros.setText("");
	  TAmodificarLibros.setText(""); 
	  TAconsultarLibros.setText("");
	  TAregistroUsuarios.setText(""); 
	  TAmodificarUsuarios.setText(""); 
	  TAconsultarUsuarios.setText("");
 	  TAregistroPrestamos.setText("");
	  TAmodificarPrestamos.setText(""); 
	  TAconsultarPrestamos.setText("");
	  TAactLibros.setText("");
	  TAactPrestamos.setText(""); 
	  TAactUsuarios.setText("");
	  CTmodificarL.setText("");
	  CTmodificarU.setText("");
	  CTmodificarP.setText("");
	  CTtelefonoBusPre.setText("");
	  CTtelefonoBus.setText("");
	}

  	if(accion.getSource()==LibrosM1){
	  vista11.setVisible(true);
	  vista12.setVisible(false);
	  vista13.setVisible(false);
	  vista21.setVisible(false);
	  vista22.setVisible(false);
	  vista23.setVisible(false);
	  vista31.setVisible(false);
	  vista32.setVisible(false);
	  vista33.setVisible(false);
	  vista121.setVisible(false);
	  vista221.setVisible(false);
	  vista321.setVisible(false);
	  TAregistroLibros.setText("");
	  TAmodificarLibros.setText(""); 
	  TAconsultarLibros.setText("");
	  TAregistroUsuarios.setText(""); 
	  TAmodificarUsuarios.setText(""); 
	  TAconsultarUsuarios.setText("");
 	  TAregistroPrestamos.setText("");
	  TAmodificarPrestamos.setText(""); 
	  TAconsultarPrestamos.setText("");
	  TAactLibros.setText("");
	  TAactPrestamos.setText(""); 
	  TAactUsuarios.setText("");
	  CTmodificarU.setText("");
	  CTmodificarP.setText("");
	  CTtelefonoBusPre.setText("");
	  CTtelefonoBus.setText("");
	}

  	if(accion.getSource()==LibrosM2){
	  vista11.setVisible(false);
	  vista12.setVisible(true);
	  vista13.setVisible(false);
	  vista21.setVisible(false);
	  vista22.setVisible(false);
	  vista23.setVisible(false);
	  vista31.setVisible(false);
	  vista32.setVisible(false);
	  vista33.setVisible(false);
	  vista121.setVisible(false);
	  vista221.setVisible(false);
	  vista321.setVisible(false);
	  TAregistroLibros.setText("");
	  TAmodificarLibros.setText(""); 
	  TAconsultarLibros.setText("");
	  TAregistroUsuarios.setText(""); 
	  TAmodificarUsuarios.setText(""); 
	  TAconsultarUsuarios.setText("");
 	  TAregistroPrestamos.setText("");
	  TAmodificarPrestamos.setText(""); 
	  TAconsultarPrestamos.setText("");
	  TAactLibros.setText("");
	  TAactPrestamos.setText(""); 
	  TAactUsuarios.setText("");
	  CTmodificarU.setText("");
	  CTmodificarP.setText("");
	  CTtelefonoBusPre.setText("");
	  CTtelefonoBus.setText("");
	}

  	if(accion.getSource()==LibrosM3){
	  vista11.setVisible(false);
	  vista12.setVisible(false);
	  vista13.setVisible(true);
	  vista21.setVisible(false);
	  vista22.setVisible(false);
	  vista23.setVisible(false);
	  vista31.setVisible(false);
	  vista32.setVisible(false);
	  vista33.setVisible(false);
	  vista121.setVisible(false);
	  vista221.setVisible(false);
	  vista321.setVisible(false);
	  TAregistroLibros.setText("");
	  TAmodificarLibros.setText(""); 
	  TAconsultarLibros.setText("");
	  TAregistroUsuarios.setText(""); 
	  TAmodificarUsuarios.setText(""); 
	  TAconsultarUsuarios.setText("");
 	  TAregistroPrestamos.setText("");
	  TAmodificarPrestamos.setText(""); 
	  TAconsultarPrestamos.setText("");
	  TAactLibros.setText("");
	  TAactPrestamos.setText(""); 
	  TAactUsuarios.setText("");
	  CTmodificarU.setText("");
	  CTmodificarP.setText("");
	  CTtelefonoBusPre.setText("");
	  CTtelefonoBus.setText("");
	}

	if(accion.getSource()==UsuariosM1){
	  vista11.setVisible(false);
	  vista12.setVisible(false);
	  vista13.setVisible(false);
	  vista21.setVisible(true);
	  vista22.setVisible(false);
	  vista23.setVisible(false);
	  vista31.setVisible(false);
	  vista32.setVisible(false);
	  vista33.setVisible(false);
	  vista121.setVisible(false);
	  vista221.setVisible(false);
	  vista321.setVisible(false);
	  TAregistroLibros.setText("");
	  TAmodificarLibros.setText(""); 
	  TAconsultarLibros.setText("");
	  TAregistroUsuarios.setText(""); 
	  TAmodificarUsuarios.setText(""); 
	  TAconsultarUsuarios.setText("");
 	  TAregistroPrestamos.setText("");
	  TAmodificarPrestamos.setText(""); 
	  TAconsultarPrestamos.setText("");
	  TAactLibros.setText("");
	  TAactPrestamos.setText(""); 
	  TAactUsuarios.setText("");
	  CTmodificarL.setText("");
	  CTmodificarP.setText("");
	  CTtelefonoBusPre.setText("");
	  CTtelefonoBus.setText("");
	}

	if(accion.getSource()==UsuariosM2){
	  vista11.setVisible(false);
	  vista12.setVisible(false);
	  vista13.setVisible(false);
	  vista21.setVisible(false);
	  vista22.setVisible(true);
	  vista23.setVisible(false);
	  vista31.setVisible(false);
	  vista32.setVisible(false);
	  vista33.setVisible(false);
	  vista121.setVisible(false);
	  vista221.setVisible(false);
	  vista321.setVisible(false);
	  TAregistroLibros.setText("");
	  TAmodificarLibros.setText(""); 
	  TAconsultarLibros.setText("");
	  TAregistroUsuarios.setText(""); 
	  TAmodificarUsuarios.setText(""); 
	  TAconsultarUsuarios.setText("");
 	  TAregistroPrestamos.setText("");
	  TAmodificarPrestamos.setText(""); 
	  TAconsultarPrestamos.setText("");
	  TAactLibros.setText("");
	  TAactPrestamos.setText(""); 
	  TAactUsuarios.setText("");
	  CTmodificarL.setText("");
	  CTmodificarP.setText("");
	  CTtelefonoBusPre.setText("");
	  CTtelefonoBus.setText("");
	}

	if(accion.getSource()==UsuariosM3){
	  vista11.setVisible(false);
	  vista12.setVisible(false);
	  vista13.setVisible(false);
	  vista21.setVisible(false);
	  vista22.setVisible(false);
	  vista23.setVisible(true);
	  vista31.setVisible(false);
	  vista32.setVisible(false);
	  vista33.setVisible(false);
	  vista121.setVisible(false);
	  vista221.setVisible(false);
	  vista321.setVisible(false);
	  TAregistroLibros.setText("");
	  TAmodificarLibros.setText(""); 
	  TAconsultarLibros.setText("");
	  TAregistroUsuarios.setText(""); 
	  TAmodificarUsuarios.setText(""); 
	  TAconsultarUsuarios.setText("");
 	  TAregistroPrestamos.setText("");
	  TAmodificarPrestamos.setText(""); 
	  TAconsultarPrestamos.setText("");
	  TAactLibros.setText("");
	  TAactPrestamos.setText(""); 
	  TAactUsuarios.setText("");
	  CTmodificarL.setText("");
	  CTmodificarP.setText("");
	  CTtelefonoBusPre.setText("");
	  CTtelefonoBus.setText("");
	}

	if(accion.getSource()==PrestamosM1){
	  vista11.setVisible(false);
	  vista12.setVisible(false);
	  vista13.setVisible(false);
	  vista21.setVisible(false);
	  vista22.setVisible(false);
	  vista23.setVisible(false);
	  vista31.setVisible(true);
	  vista32.setVisible(false);
	  vista33.setVisible(false);
	  vista121.setVisible(false);
	  vista221.setVisible(false);
	  vista321.setVisible(false);
	  TAregistroLibros.setText("");
	  TAmodificarLibros.setText(""); 
	  TAconsultarLibros.setText("");
	  TAregistroUsuarios.setText(""); 
	  TAmodificarUsuarios.setText(""); 
	  TAconsultarUsuarios.setText("");
 	  TAregistroPrestamos.setText("");
	  TAmodificarPrestamos.setText(""); 
	  TAconsultarPrestamos.setText("");
	  TAactLibros.setText("");
	  TAactPrestamos.setText(""); 
	  TAactUsuarios.setText("");
	  CTmodificarL.setText("");
	  CTmodificarU.setText("");
	  CTtelefonoBusPre.setText("");
	  CTtelefonoBus.setText("");
	}

	if(accion.getSource()==PrestamosM2){
	  vista11.setVisible(false);
	  vista12.setVisible(false);
	  vista13.setVisible(false);
	  vista21.setVisible(false);
	  vista22.setVisible(false);
	  vista23.setVisible(false);
	  vista31.setVisible(false);
	  vista32.setVisible(true);
	  vista33.setVisible(false);
	  vista121.setVisible(false);
	  vista221.setVisible(false);
	  vista321.setVisible(false);
	  TAregistroLibros.setText("");
	  TAmodificarLibros.setText(""); 
	  TAconsultarLibros.setText("");
	  TAregistroUsuarios.setText(""); 
	  TAmodificarUsuarios.setText(""); 
	  TAconsultarUsuarios.setText("");
 	  TAregistroPrestamos.setText("");
	  TAmodificarPrestamos.setText(""); 
	  TAconsultarPrestamos.setText("");
	  TAactLibros.setText("");
	  TAactPrestamos.setText(""); 
	  TAactUsuarios.setText("");
	  CTmodificarL.setText("");
	  CTmodificarU.setText("");
	  CTtelefonoBusPre.setText("");
	  CTtelefonoBus.setText("");
	}

	if(accion.getSource()==PrestamosM3){
	  vista11.setVisible(false);
	  vista12.setVisible(false);
	  vista13.setVisible(false);
	  vista21.setVisible(false);
	  vista22.setVisible(false);
	  vista23.setVisible(false);
	  vista31.setVisible(false);
	  vista32.setVisible(false);
	  vista33.setVisible(true);
	  vista121.setVisible(false);
	  vista221.setVisible(false);
	  vista321.setVisible(false);
	  TAregistroLibros.setText("");
	  TAmodificarLibros.setText(""); 
	  TAconsultarLibros.setText("");
	  TAregistroUsuarios.setText(""); 
	  TAmodificarUsuarios.setText(""); 
	  TAconsultarUsuarios.setText("");
 	  TAregistroPrestamos.setText("");
	  TAmodificarPrestamos.setText(""); 
	  TAconsultarPrestamos.setText("");
	  TAactLibros.setText("");
	  TAactPrestamos.setText(""); 
	  TAactUsuarios.setText("");
	  CTmodificarL.setText("");
	  CTmodificarU.setText("");
	  CTtelefonoBusPre.setText("");
	  CTtelefonoBus.setText("");
	}

	if(accion.getSource()==BactL){
	  vista11.setVisible(false);
	  vista12.setVisible(false);
	  vista13.setVisible(false);
	  vista21.setVisible(false);
	  vista22.setVisible(false);
	  vista23.setVisible(false);
	  vista31.setVisible(false);
	  vista32.setVisible(false);
	  vista33.setVisible(false);
	  vista121.setVisible(true);
	  vista221.setVisible(false);
	  vista321.setVisible(false);
	  TAregistroLibros.setText("");
	  TAmodificarLibros.setText(""); 
	  TAconsultarLibros.setText("");
	  TAregistroUsuarios.setText(""); 
	  TAmodificarUsuarios.setText(""); 
	  TAconsultarUsuarios.setText("");
 	  TAregistroPrestamos.setText("");
	  TAmodificarPrestamos.setText(""); 
	  TAconsultarPrestamos.setText("");
	  TAactLibros.setText("");
	  TAactPrestamos.setText(""); 
	  TAactUsuarios.setText("");
	  CTmodificarU.setText("");
	  CTmodificarP.setText("");
	  CTtelefonoBusPre.setText("");
	  CTtelefonoBus.setText("");
	}

	if(accion.getSource()==BactU){
	  vista11.setVisible(false);
	  vista12.setVisible(false);
	  vista13.setVisible(false);
	  vista21.setVisible(false);
	  vista22.setVisible(false);
	  vista23.setVisible(false);
	  vista31.setVisible(false);
	  vista32.setVisible(false);
	  vista33.setVisible(false);
	  vista121.setVisible(false);
	  vista221.setVisible(true);
	  vista321.setVisible(false);
	  TAregistroLibros.setText("");
	  TAmodificarLibros.setText(""); 
	  TAconsultarLibros.setText("");
	  TAregistroUsuarios.setText(""); 
	  TAmodificarUsuarios.setText(""); 
	  TAconsultarUsuarios.setText("");
 	  TAregistroPrestamos.setText("");
	  TAmodificarPrestamos.setText(""); 
	  TAconsultarPrestamos.setText("");
	  TAactLibros.setText("");
	  TAactPrestamos.setText(""); 
	  TAactUsuarios.setText("");
	  CTmodificarL.setText("");
	  CTmodificarP.setText("");
	  CTtelefonoBusPre.setText("");
	  CTtelefonoBus.setText("");
	}

	if(accion.getSource()==BactP){
	  vista11.setVisible(false);
	  vista12.setVisible(false);
	  vista13.setVisible(false);
	  vista21.setVisible(false);
	  vista22.setVisible(false);
	  vista23.setVisible(false);
	  vista31.setVisible(false);
	  vista32.setVisible(false);
	  vista33.setVisible(false);
	  vista121.setVisible(false);
	  vista221.setVisible(false);
	  vista321.setVisible(true);
	  TAregistroLibros.setText("");
	  TAmodificarLibros.setText(""); 
	  TAconsultarLibros.setText("");
	  TAregistroUsuarios.setText(""); 
	  TAmodificarUsuarios.setText(""); 
	  TAconsultarUsuarios.setText("");
 	  TAregistroPrestamos.setText("");
	  TAmodificarPrestamos.setText(""); 
	  TAconsultarPrestamos.setText("");
	  TAactLibros.setText("");
	  TAactPrestamos.setText(""); 
	  TAactUsuarios.setText("");
	  CTmodificarL.setText("");
	  CTmodificarU.setText("");
	  CTtelefonoBus.setText("");
	}

//******************************CADENAS DE AREAS DE TEXTO************************************

  	if(accion.getSource()==BregistrarL){
	  Vcodigo="";
	  Vtitulo="";
	  Vautor="";
	  Veditorial="";
     	  Vcodigo="LIBRO REGISTRADO\n\n Codigo: "+CTcodigo.getText().toString();
     	  Vtitulo="\n Titulo: "+CTtitulo.getText().toString();
     	  Vautor="\n Autor: "+CTautor.getText().toString();
     	  Veditorial="\n Editorial: "+CTeditorial.getText().toString();
	  Vcategoria="\n Categoria: "+Vcat;

  	  CadenaLibros=(Vcodigo+Vtitulo+Vautor+Veditorial+Vcategoria);
  	  TAregistroLibros.setText(CadenaLibros);
  	}

  	if(accion.getSource()==BregistrarU){
	  Vnombre="";
	  Vdomicilio="";
	  Vtelefono="";
	  Vcorreo="";
     	  Vnombre="USUARIO REGISTRADO\n\n Nombre: "+CTnombre.getText().toString();
     	  Vdomicilio="\n Domicilio: "+CTdomicilio.getText().toString();
     	  Vtelefono="\n Telefono: "+CTtelefono.getText().toString();
     	  Vcorreo="\n Correo: "+CTcorreo.getText().toString();
	  Vsexo="\n Sexo: "+Vsexo1;

  	  CadenaUsuarios=(Vnombre+Vdomicilio+Vtelefono+Vcorreo+Vsexo);
  	  TAregistroUsuarios.setText(CadenaUsuarios);
  	}

  	if(accion.getSource()==BregistrarP){
	  Vtitulo1="";
	  Vtelefono1="";
	  Vfecha="";
     	  Vtitulo1="PRESTAMO REGISTRADO\n\n Titulo: "+CTtituloPre.getText().toString();
     	  Vtelefono1="\n Telefono: "+CTtelefonoPre.getText().toString();
     	  Vfecha="\n Fecha: "+CTfecha.getText().toString();
     	  Vplazo1="\n Plazo: "+Vplazo;

  	  CadenaPrestamos=(Vtitulo1+Vtelefono1+Vfecha+Vplazo1);
  	  TAregistroPrestamos.setText(CadenaPrestamos);
  	}

  	if(accion.getSource()==BguardarL){
	  VcodigoAct="";
	  VtituloAct="";
	  VautorAct="";
	  VeditorialAct="";
     	  VcodigoAct="LIBRO ACTUALIZADO\n\n Codigo: "+CTmodificarL.getText().toString();
     	  VtituloAct="\n Titulo: "+CTtituloAct.getText().toString();
     	  VautorAct="\n Autor: "+CTautorAct.getText().toString();
     	  VeditorialAct="\n Editorial: "+CTeditorialAct.getText().toString();
	  VcategoriaAct="\n Categoria: "+VcatAct;

  	  CadenaLibrosAct=(VcodigoAct+VtituloAct+VautorAct+VeditorialAct+VcategoriaAct);
  	  TAactLibros.setText(CadenaLibrosAct);
  	}

  	if(accion.getSource()==BguardarU){
	  VnombreAct="";
	  VdomicilioAct="";
	  VtelefonoAct="";
	  VcorreoAct="";
     	  VnombreAct="USUARIO ACTUALIZADO\n\n Nombre: "+CTnombreAct.getText().toString();
     	  VdomicilioAct="\n Domicilio: "+CTdomicilioAct.getText().toString();
     	  VtelefonoAct="\n Telefono: "+CTtelefonoAct.getText().toString();
     	  VcorreoAct="\n Correo: "+CTcorreoAct.getText().toString();
	  VsexoAct="\n Sexo: "+Vsexo2;

  	  CadenaUsuariosAct=(VnombreAct+VdomicilioAct+VtelefonoAct+VcorreoAct+VsexoAct);
  	  TAactUsuarios.setText(CadenaUsuariosAct);
  	}

  	if(accion.getSource()==BguardarP){
	  Vtitulo2="";
	  Vtelefono2="";
	  Vfecha2="";
     	  Vtitulo2="PRESTAMO ACTUALIZADO\n\n Titulo: "+CTtituloActPre.getText().toString();
     	  Vtelefono2="\n Telefono: "+CTtelefonoActPre.getText().toString();
     	  Vfecha2="\n Fecha: "+CTfechaAct.getText().toString();
     	  Vplazo3="\n Plazo: "+Vplazo2;

  	  CadenaPrestamosAct=(Vtitulo2+Vtelefono2+Vfecha2+Vplazo3);
  	  TAactPrestamos.setText(CadenaPrestamosAct);
  	}
    //-------------------------------------------------------------

//--------------------------SECCION DE "ALTA" EN BASE DE DATOS---------------------


  if(accion.getSource()==BregistrarL){
 
	Connection cn=null;
	PreparedStatement pst=null;
	String AccionSQL="INSERT INTO libros (Codigo, Titulo, Autor, Editorial, Categoria) VALUES(?,?,?,?,?)";
	System.out.println("A punto de conectar con base de datos");
 	try{
	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  pst=cn.prepareStatement(AccionSQL);
	
	  pst.setString(1, CTcodigo.getText());
	  pst.setString(2, CTtitulo.getText());
	  pst.setString(3, CTautor.getText());
	  pst.setString(4, CTeditorial.getText());
	  pst.setString(5, Vcat);
	  pst.executeUpdate(); 

	}catch (Exception e){
	  System.out.println("Algo salio mal  "+e.getMessage());
    	}//fin del catch    
  }//Fin del if

   //------------------------------------------------------------- 
	
  if(accion.getSource()==BregistrarU){
	Connection cn=null;
	PreparedStatement pst=null;
	String AccionSQL="INSERT INTO usuarios(Nombre, Domicilio, Telefono, Correo, Sexo, Disponibilidad) VALUES(?,?,?,?,?,0)";
	System.out.println("A punto de conectar con base de datos");
 	try{
	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  pst=cn.prepareStatement(AccionSQL);
 	
	  pst.setString(1, CTnombre.getText());
	  pst.setString(2, CTdomicilio.getText());
	  pst.setString(3, CTtelefono.getText());
	  pst.setString(4, CTcorreo.getText());
	  pst.setString(5, Vsexo1);
	  pst.executeUpdate(); 

	}catch (Exception e){
	  System.out.println("Algo salio mal  "+e.getMessage());
    	}//fin del catch 
  }//Fin del if
  
//------------------------------------------------------------

    if(accion.getSource()==BregistrarP){
  	Connection cn=null;
	PreparedStatement pst=null;
	String AccionSQL="INSERT INTO prestamos(Titulo, Telefono, Fecha, Plazo) VALUES(?,?,?,?)";
	System.out.println("A punto de conectar con base de datos");
 	try{
	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  pst=cn.prepareStatement(AccionSQL);
 	
	  pst.setString(1, CTtituloPre.getText()); 
	  pst.setString(2, CTtelefonoPre.getText());
	  pst.setString(3, CTfecha.getText());
	  pst.setString(4, Vplazo);
	  pst.executeUpdate(); 


	}catch (Exception e){
	  System.out.println("Algo salio mal  "+e.getMessage());
    	}//fin del catch 

  }//Fin del if


//---------------------------------------------------------------------------------------
//--------------------------SECCION DE "ACTUALIZAR" EN BASE DE DATOS---------------------

  if(accion.getSource()==BguardarL){
	Connection cn=null;
	PreparedStatement pst=null;
	String AccionSQL="UPDATE libros SET Titulo=?, Autor=?, Editorial=?, Categoria=? WHERE Codigo=?";
	System.out.println("A punto de conectar con base de datos");
 	try{
	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  pst=cn.prepareStatement(AccionSQL);
	
	  pst.setString(1, CTtituloAct.getText());
	  pst.setString(2, CTautorAct.getText());
	  pst.setString(3, CTeditorialAct.getText());
	  pst.setString(4, VcatAct);
	  pst.setString(5, CTmodificarL.getText());
	  pst.executeUpdate(); 


	}catch (Exception e){
	  System.out.println("Algo salio mal  "+e.getMessage());
    	}//fin del catch   

	try{
	  if(pst!=null)pst.close();   
	  if(cn!=null)cn.close();
	}catch(SQLException e){
	  System.out.println("Algo salio mal 2 "+e.getMessage());
	}//Fin del catch 
 
  }//Fin del if

   //------------------------------------------------------------- 

  if(accion.getSource()==BguardarU){
	Connection cn=null;
	PreparedStatement pst=null;
	String AccionSQL="UPDATE usuarios SET Nombre=?, Domicilio=?, Telefono=?, Correo=?, Sexo=? WHERE Telefono=?";
	System.out.println("A punto de conectar con base de datos");
 	try{
	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  pst=cn.prepareStatement(AccionSQL);
 	
	  pst.setString(1, CTnombreAct.getText());
	  pst.setString(2, CTdomicilioAct.getText());
	  pst.setString(3, CTtelefonoAct.getText());
	  pst.setString(4, CTcorreoAct.getText());
	  pst.setString(5, Vsexo2);
	  pst.setString(6, CTmodificarU.getText());
	  pst.executeUpdate(); 


	}catch (Exception e){
	  System.out.println("Algo salio mal  "+e.getMessage());
    	}//fin del catch 

	try{
	  if(pst!=null)pst.close();   
	  if(cn!=null)cn.close();
	}catch(SQLException e){
	  System.out.println("Algo salio mal 2 "+e.getMessage());
	}//Fin del catch 

  }//Fin del if
  
   //------------------------------------------------------------- 

  if(accion.getSource()==BguardarP){
	Connection cn=null;
	PreparedStatement pst=null;
	String AccionSQL="UPDATE prestamos SET Titulo=?, Telefono=?, Fecha=?, Plazo=? WHERE Telefono=?";
	System.out.println("A punto de conectar con base de datos");
 	try{
	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  pst=cn.prepareStatement(AccionSQL);
 	
	  pst.setString(1, CTtituloActPre.getText());
	  pst.setString(2, CTtelefonoActPre.getText());
	  pst.setString(3, CTfechaAct.getText());
	  pst.setString(4, Vplazo2);
	  pst.setString(5, CTmodificarP.getText());
	  pst.executeUpdate(); 


	}catch (Exception e){
	  System.out.println("Algo salio mal  "+e.getMessage());
    	}//fin del catch 

	try{
	  if(pst!=null)pst.close();   
	  if(cn!=null)cn.close();
	}catch(SQLException e){
	  System.out.println("Algo salio mal 2 "+e.getMessage());
	}//Fin del catch 

  }//Fin del if
  
   //------------------------------------------------------------- 

//--------------------------SECCION DE "BAJAS" EN BASE DE DATOS---------------------

  if(accion.getSource()==BborrarL){
	Connection cn=null;
	PreparedStatement pst=null;
	String AccionSQL="DELETE FROM libros WHERE Codigo=?";    //AND o OR para borrar con mas de una condicion
	System.out.println("A punto de conectar con base de datos");
 	try{
	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  pst=cn.prepareStatement(AccionSQL);
	
	  pst.setString(1, CTmodificarL.getText());
	  System.out.println(pst.toString());
	  pst.executeUpdate(); 


	}catch (Exception e){
	  System.out.println("Algo salio mal  "+e.getMessage());
    	}//fin del catch   

	try{
	  if(pst!=null)pst.close();   
	  if(cn!=null)cn.close();
	}catch(SQLException e){
	  System.out.println("Algo salio mal 2 "+e.getMessage());
	}//Fin del catch 
 
  }//Fin del if

   //------------------------------------------------------------- 
  
if(accion.getSource()==BborrarU){
	Connection cn=null;
	PreparedStatement pst=null;
	String AccionSQL="DELETE FROM usuarios WHERE Telefono=?";    //AND o OR para borrar con mas de una condicion
	System.out.println("A punto de conectar con base de datos");
 	try{
	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  pst=cn.prepareStatement(AccionSQL);
	
	  pst.setString(1, CTmodificarU.getText());
	  System.out.println(pst.toString());
	  pst.executeUpdate(); 


	}catch (Exception e){
	  System.out.println("Algo salio mal  "+e.getMessage());
    	}//fin del catch   

	try{
	  if(pst!=null)pst.close();   
	  if(cn!=null)cn.close();
	}catch(SQLException e){
	  System.out.println("Algo salio mal 2 "+e.getMessage());
	}//Fin del catch 
 
  }//Fin del if

   //-------------------------------------------------------------

if(accion.getSource()==BborrarP){
	Connection cn=null;
	PreparedStatement pst=null;	
	String AccionSQL="DELETE FROM prestamos WHERE Telefono=?";    //AND o OR para borrar con mas de una condicion
	System.out.println("A punto de conectar con base de datos");
 	try{
	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  pst=cn.prepareStatement(AccionSQL);
	
	  pst.setString(1, CTmodificarP.getText());
	  System.out.println(pst.toString());
	  pst.executeUpdate(); 


	}catch (Exception e){
	  System.out.println("Algo salio mal  "+e.getMessage());
    	}//fin del catch   

	try{
	  if(pst!=null)pst.close();   
	  if(cn!=null)cn.close();
	}catch(SQLException e){
	  System.out.println("Algo salio mal 2 "+e.getMessage());
	}//Fin del catch 
 
  }//Fin del if

   //-------------------------------------------------------------


//--------------------------SECCION DE "CONSULTA" EN BASE DE DATOS---------------------

//**********************LIBROS*********************

  if(accion.getSource()==BbuscarL){
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String AccionSQL="";
	String cadena="\tLIBRO ENCONTRADO: \n\n";
	int numRegistros=0;

	try{
	  System.out.println("A punto de conectar con base de datos");

	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  AccionSQL="SELECT*FROM libros WHERE Codigo=?";
	  pst=cn.prepareStatement(AccionSQL);
	  pst.setString(1, CTmodificarL.getText());
	  rs=pst.executeQuery();  
	  while(rs.next()){
		cadena=cadena+"Codigo:\t"+
		rs.getString("Codigo")+"\n"+"Titulo:\t"+
		rs.getString("Titulo")+"\n"+"Autor:\t"+
		rs.getString("Autor")+"\n"+"Editorial:\t"+
		rs.getString("Editorial")+"\n"+"Categoria:\t"+
		rs.getString("Categoria")+"\n"+"\n";
	    numRegistros++;
	  }//fin del while
		System.out.println(numRegistros);
		
		if(numRegistros==0)cadena=cadena+"\tNo se encontraron registros\n";

	  }catch(Exception e){
 	   System.out.println("Algo salio mal "+e.getMessage());
	  } 

	TAmodificarLibros.setText(cadena);

	try{
	  if(rs!=null)rs.close();
	  if(pst!=null)pst.close();
	  if(cn!=null)cn.close();
	}catch(SQLException e){
 	   System.out.println("Algo salio mal 2"+e.getMessage());
	}//fin del catch


  }//fin del if


//------------------------------------------------------------------------------------
  
  if(accion.getSource()==BbuscarL1){
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String AccionSQL="";
	String cadena="\tLIBROS ENCONTRADOS: \n\n";
	int numRegistros=0;

	try{
	  System.out.println("A punto de conectar con base de datos");

	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  AccionSQL="SELECT*FROM libros WHERE Categoria=?";
	  pst=cn.prepareStatement(AccionSQL);
	  pst.setString(1, VcatCon);
	  rs=pst.executeQuery();  
	  while(rs.next()){
		cadena=cadena+"Codigo:\t"+
		rs.getString("Codigo")+"\n"+"Titulo:\t"+
		rs.getString("Titulo")+"\n"+"Autor:\t"+
		rs.getString("Autor")+"\n"+"Editorial:\t"+
		rs.getString("Editorial")+"\n"+"Categoria:\t"+
		rs.getString("Categoria")+"\n"+"\n";
	    numRegistros++;
	  }//fin del while
		System.out.println(numRegistros);
		
		if(numRegistros==0)cadena=cadena+"\tNo se encontraron registros\n";

	  }catch(Exception e){
 	   System.out.println("Algo salio mal "+e.getMessage());
	  } 

	TAconsultarLibros.setText(cadena);

	try{
	  if(rs!=null)rs.close();
	  if(pst!=null)pst.close();
	  if(cn!=null)cn.close();
	}catch(SQLException e){
 	   System.out.println("Algo salio mal 2"+e.getMessage());
	}//fin del catch


  }//fin del if


//------------------------------------------------------------------------------------

  if(accion.getSource()==BverL){
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String AccionSQL="";
	String cadena="\tTODOS LOS LIBROS:\n\n";
	int numRegistros=0;

	try{
	  System.out.println("A punto de conectar con base de datos");

	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  AccionSQL="SELECT*FROM libros";
	  pst=cn.prepareStatement(AccionSQL);
	  //pst.setString(1, VcatCon);
	  rs=pst.executeQuery();  
	  while(rs.next()){
		cadena=cadena+"Codigo:\t"+
		rs.getString("Codigo")+"\n"+"Titulo:\t"+
		rs.getString("Titulo")+"\n"+"Autor:\t"+
		rs.getString("Autor")+"\n"+"Editorial:\t"+
		rs.getString("Editorial")+"\n"+"Categoria:\t"+
		rs.getString("Categoria")+"\n"+"\n";
	    numRegistros++;
	  }//fin del while
		System.out.println(numRegistros);
		
		if(numRegistros==0)cadena=cadena+"\tNo se encontraron registros\n";

	  }catch(Exception e){
 	   System.out.println("Algo salio mal "+e.getMessage());
	  } 

	TAconsultarLibros.setText(cadena);

	try{
	  if(rs!=null)rs.close();
	  if(pst!=null)pst.close();
	  if(cn!=null)cn.close();
	}catch(SQLException e){
 	   System.out.println("Algo salio mal 2"+e.getMessage());
	}//fin del catch


  }//fin del if


//------------------------------------------------------------------------------------
//**********************USUARIOS*********************
  if(accion.getSource()==BbuscarU){
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String AccionSQL="";
	String cadena="\tUSUARIO ENCONTRADO: \n\n";
	int numRegistros=0;

	try{
	  System.out.println("A punto de conectar con base de datos");

	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  AccionSQL="SELECT*FROM usuarios WHERE Telefono=?";
	  pst=cn.prepareStatement(AccionSQL);
	  pst.setString(1, CTmodificarU.getText());
	  rs=pst.executeQuery();  
	  while(rs.next()){
		cadena=cadena+"Nombre:\t"+
		rs.getString("Nombre")+"\n"+"Domicilio:\t"+
		rs.getString("Domicilio")+"\n"+"Telefono:\t"+
		rs.getString("Telefono")+"\n"+"Correo:\t"+
		rs.getString("Correo")+"\n"+"Sexo:\t"+
		rs.getString("Sexo")+"\n"+"\n";
	    numRegistros++;
	  }//fin del while
		System.out.println(numRegistros);
		
		if(numRegistros==0)cadena=cadena+"\tNo se encontraron registros\n";

	  }catch(Exception e){
 	   System.out.println("Algo salio mal "+e.getMessage());
	  } 

	TAmodificarUsuarios.setText(cadena);

	try{
	  if(rs!=null)rs.close();
	  if(pst!=null)pst.close();
	  if(cn!=null)cn.close();
	}catch(SQLException e){
 	   System.out.println("Algo salio mal 2"+e.getMessage());
	}//fin del catch


  }//fin del if


//------------------------------------------------------------------------------------
  
  if(accion.getSource()==BbuscarU1){
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String AccionSQL="";
	String cadena="\tUSUARIOS ENCONTRADOS: \n\n";
	int numRegistros=0;

	try{
	  System.out.println("A punto de conectar con base de datos");

	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  AccionSQL="SELECT*FROM usuarios WHERE Telefono=?";
	  pst=cn.prepareStatement(AccionSQL);
	  pst.setString(1, CTtelefonoBus.getText());
	  rs=pst.executeQuery();  
	  while(rs.next()){
		cadena=cadena+"Nombre:\t"+
		rs.getString("Nombre")+"\n"+"Domicilio:\t"+
		rs.getString("Domicilio")+"\n"+"Telefono:\t"+
		rs.getString("Telefono")+"\n"+"Correo:\t"+
		rs.getString("Correo")+"\n"+"Sexo:\t"+
		rs.getString("Sexo")+"\n"+"\n";
	    numRegistros++;
	  }//fin del while
		System.out.println(numRegistros);
		
		if(numRegistros==0)cadena=cadena+"\tNo se encontraron registros\n";

	  }catch(Exception e){
 	   System.out.println("Algo salio mal "+e.getMessage());
	  } 

	TAconsultarUsuarios.setText(cadena);

	try{
	  if(rs!=null)rs.close();
	  if(pst!=null)pst.close();
	  if(cn!=null)cn.close();
	}catch(SQLException e){
 	   System.out.println("Algo salio mal 2"+e.getMessage());
	}//fin del catch


  }//fin del if


//------------------------------------------------------------------------------------

  if(accion.getSource()==BverU){
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String AccionSQL="";
	String cadena="\tTODOS LOS USUARIOS:\n\n";
	int numRegistros=0;

	try{
	  System.out.println("A punto de conectar con base de datos");

	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  AccionSQL="SELECT*FROM usuarios";
	  pst=cn.prepareStatement(AccionSQL);
	  //pst.setString(1, VcatCon);
	  rs=pst.executeQuery();  
	  while(rs.next()){
		cadena=cadena+"Nombre:\t"+
		rs.getString("Nombre")+"\n"+"Domicilio:\t"+
		rs.getString("Domicilio")+"\n"+"Telefono:\t"+
		rs.getString("Telefono")+"\n"+"Correo:\t"+
		rs.getString("Correo")+"\n"+"Sexo:\t"+
		rs.getString("Sexo")+"\n"+"\n";
	    numRegistros++;
	  }//fin del while
		System.out.println(numRegistros);
		
		if(numRegistros==0)cadena=cadena+"\tNo se encontraron registros\n";

	  }catch(Exception e){
 	   System.out.println("Algo salio mal "+e.getMessage());
	  } 

	TAconsultarUsuarios.setText(cadena);

	try{
	  if(rs!=null)rs.close();
	  if(pst!=null)pst.close();
	  if(cn!=null)cn.close();
	}catch(SQLException e){
 	   System.out.println("Algo salio mal 2"+e.getMessage());
	}//fin del catch


  }//fin del if


//------------------------------------------------------------------------------------
//**********************PRESTAMOS*********************
  

  if(accion.getSource()==BbuscarP){
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String AccionSQL="";
	String cadena="\tPRESTAMO ENCONTRADO: \n\n";
	int numRegistros=0, numRegistros1=0;

	try{
	  System.out.println("A punto de conectar con base de datos");

	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  AccionSQL="SELECT*FROM prestamos WHERE Telefono=?";
	  pst=cn.prepareStatement(AccionSQL);
	  pst.setString(1, CTmodificarP.getText());
	  rs=pst.executeQuery();  
	  while(rs.next()){
		cadena=cadena+"DATOS DEL PRESTAMO \nTitulo:\t"+
		rs.getString("Titulo")+"\n"+"Telefono:\t"+
		rs.getString("Telefono")+"\n"+"Fecha:\t"+
		rs.getString("Fecha")+"\n"+"Plazo:\t"+
		rs.getString("Plazo")+"\n"+"\n";
	    numRegistros++;

		System.out.println(numRegistros);
	  }//fin del while

 	  AccionSQL="SELECT*FROM usuarios WHERE Telefono=?";
	  pst=cn.prepareStatement(AccionSQL);
	  pst.setString(1, CTmodificarP.getText());
	  rs=pst.executeQuery(); 
	  while(rs.next()){
		cadena=cadena+"DATOS DEL USUARIO \nNombre:\t"+
		rs.getString("Nombre")+"\n"+"Domicilio:\t"+
		rs.getString("Domicilio")+"\n"+"Telefono:\t"+
		rs.getString("Correo")+"\n"+"Sexo:\t"+
		rs.getString("Sexo")+"\n"+"\n**************************************************";
	    numRegistros1++;

		System.out.println(numRegistros1);
	  }//fin del while

		if(numRegistros==0)cadena=cadena+"No se encontraron registros\n";
		if(numRegistros1==0)cadena=cadena+"No se encontro registro del usuario, verifique el numero\n";

	  }catch(Exception e){
 	   System.out.println("Algo salio mal "+e.getMessage());
	  } 

	TAmodificarPrestamos.setText(cadena);

	try{
	  if(rs!=null)rs.close();
	  if(pst!=null)pst.close();
	  if(cn!=null)cn.close();
	}catch(SQLException e){
 	   System.out.println("Algo salio mal 2"+e.getMessage());
	}//fin del catch

  }//fin del if

//------------------------------------------------------------------------------------
 
  if(accion.getSource()==BbuscarP1){
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String AccionSQL="";
	String cadena="\tPRESTAMOS ENCONTRADOS: \n\n";
	int numRegistros=0, numRegistros1=0;

	try{
	  System.out.println("A punto de conectar con base de datos");

	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  AccionSQL="SELECT*FROM prestamos WHERE Telefono=?";
	  pst=cn.prepareStatement(AccionSQL);
	  pst.setString(1, CTtelefonoBusPre.getText());
	  rs=pst.executeQuery();  
	  while(rs.next()){
		cadena=cadena+"DATOS DEL PRESTAMO \nTitulo:\t"+
		rs.getString("Titulo")+"\n"+"Telefono:\t"+
		rs.getString("Telefono")+"\n"+"Fecha:\t"+
		rs.getString("Fecha")+"\n"+"Plazo:\t"+
		rs.getString("Plazo")+"\n"+"\n";
	    numRegistros++;

		System.out.println(numRegistros);
	  }//fin del while

 	  AccionSQL="SELECT*FROM usuarios WHERE Telefono=?";
	  pst=cn.prepareStatement(AccionSQL);
	  pst.setString(1, CTtelefonoBusPre.getText());
	  rs=pst.executeQuery(); 
	  while(rs.next()){
		cadena=cadena+"DATOS DEL USUARIO \nNombre:\t"+
		rs.getString("Nombre")+"\n"+"Domicilio:\t"+
		rs.getString("Domicilio")+"\n"+"Telefono:\t"+
		rs.getString("Correo")+"\n"+"Sexo:\t"+
		rs.getString("Sexo")+"\n"+"\n**************************************************\n";
	    numRegistros1++;

		System.out.println(numRegistros1);
	  }//fin del while

		if(numRegistros==0)cadena=cadena+"No se encontraron registros\n";
		if(numRegistros1==0)cadena=cadena+"No se encontro registro del usuario, verifique el numero\n";


	  }catch(Exception e){
 	   System.out.println("Algo salio mal "+e.getMessage());
	  } 

	TAconsultarPrestamos.setText(cadena);

	try{
	  if(rs!=null)rs.close();
	  if(pst!=null)pst.close();
	  if(cn!=null)cn.close();
	}catch(SQLException e){
 	   System.out.println("Algo salio mal 2"+e.getMessage());
	}//fin del catch


  }//fin del if


//------------------------------------------------------------------------------------
  
  if(accion.getSource()==BverP){
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String AccionSQL="";
	String cadena="\tTODOS LOS PRESTAMOS:\n\n";
	int numRegistros=0;

	try{
	  System.out.println("A punto de conectar con base de datos");

	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moscow_books","root","");
	  System.out.println("Conexion exitosa");

 	  AccionSQL="SELECT*FROM prestamos";
	  pst=cn.prepareStatement(AccionSQL); 
	  //pst.setString(1, CTtelefonoBusPre);
	  rs=pst.executeQuery();  
	  while(rs.next()){
		cadena=cadena+"Titulo:\t"+
		rs.getString("Titulo")+"\n"+"Telefono:\t"+
		rs.getString("Telefono")+"\n"+"Fecha:\t"+
		rs.getString("Fecha")+"\n"+"Plazo:\t"+
		rs.getString("Plazo")+"\n"+"\n";
	    numRegistros++;
	  }//fin del while
		System.out.println(numRegistros);
		
		if(numRegistros==0)cadena=cadena+"\tNo se encontraron registros\n";

	  }catch(Exception e){
 	   System.out.println("Algo salio mal "+e.getMessage());
	  } 

	TAconsultarPrestamos.setText(cadena);

	try{
	  if(rs!=null)rs.close();
	  if(pst!=null)pst.close();
	  if(cn!=null)cn.close();
	}catch(SQLException e){
 	   System.out.println("Algo salio mal 2"+e.getMessage());
	}//fin del catch


  }//fin del if



//------------------------------------------------------------------------------------

  if(accion.getSource()==BregistrarL){
	CTcodigo.setText("");
	CTtitulo.setText("");
	CTautor.setText("");
	CTeditorial.setText("");
	//CBcategoria.setText("");
  }

  if(accion.getSource()==BregistrarU){
	CTnombre.setText("");
	CTdomicilio.setText("");
	CTtelefono.setText("");
	CTcorreo.setText("");
	//CBcategoria.setText("");
  }

  if(accion.getSource()==BregistrarP){
	CTtituloPre.setText("");
	CTtelefonoPre.setText("");
	CTfecha.setText("");
	//CBcategoria.setText("");
  }

  if(accion.getSource()==BguardarL){
	//CTcodigoAct.setText("");
	CTtituloAct.setText("");
	CTautorAct.setText("");
	CTeditorialAct.setText("");
	CTmodificarL.setText("");
	//CBcategoria.setText("");
  }

  if(accion.getSource()==BguardarU){
	CTnombreAct.setText("");
	CTdomicilioAct.setText("");
	CTtelefonoAct.setText("");
	CTcorreoAct.setText("");
	CTmodificarU.setText("");
	//CBcategoria.setText("");
  }

  if(accion.getSource()==BguardarP){
	CTtituloActPre.setText("");
	CTtelefonoActPre.setText("");
	CTfechaAct.setText("");
	CTmodificarP.setText("");
	//CBcategoria.setText("");
  }

  if(accion.getSource()==BborrarL){
	CTmodificarL.setText("");
	TAmodificarLibros.setText("\tLIBRO BORRADO");
  }

  if(accion.getSource()==BborrarU){
	CTmodificarU.setText("");
	TAmodificarUsuarios.setText("\tUSUARIO BORRADO");
  }

  if(accion.getSource()==BborrarP){
	CTmodificarP.setText("");
	TAmodificarPrestamos.setText("\tPRESTAMO BORRADO");
  }

  if(accion.getSource()==BactL){
	TAmodificarLibros.setText("");
  }

  if(accion.getSource()==BactU){
	TAmodificarUsuarios.setText("");
  }

  if(accion.getSource()==BactP){
	TAmodificarPrestamos.setText("");
  }


}//************************Fin de metodo actionPerformed**************************



//--------------------------------MAIN--------------------------------------------
public static void main(String args[]){
	PROYECTO miPROYECTO=new PROYECTO();
	miPROYECTO.setBounds(300,100,680,550);
	miPROYECTO.setVisible(true);
	miPROYECTO.setResizable(false);


}//Fin del main


}//Fin de la clase


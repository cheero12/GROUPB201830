
package clientserver;

import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.*;

public class Client_Second extends Frame  {

//*****  single-thread client, with UI
//            expects to find server on gamma.cs.unc.edu:8888

MyFrame outerBox;

TextField hostDisplay, portDisplay;
TextArea logDisplay, msgDisplay;
Panel topPanel;
Panel middlePanel;
Panel buttonPanel;
Button connectButton, sendButton, cancelButton, quitButton;

public static final String DEFAULT_HOST = "gamma.cs.unc.edu";
public static final int DEFAULT_PORT = 8888;

  public Client_Second ()  {
    super ("Client_Second ");
  } // end Client_Second constructor

// **************

  public void buildUI ()  {

  hostDisplay = new TextField ( DEFAULT_HOST, 30 );
  portDisplay = new TextField ( Integer.toString ( DEFAULT_PORT ), 4 );
  topPanel = new Panel ();
  topPanel.setLayout ( new BorderLayout () );
  topPanel.add ( "North", hostDisplay );
  topPanel.add ( "South", portDisplay );

  logDisplay = new TextArea ( 40, 10 );
  msgDisplay = new TextArea ( 40, 10 );
  msgDisplay .setText ( "Default message.\n" );
  middlePanel = new Panel ();
  middlePanel.setLayout ( new GridLayout ( 2, 1 ) );
  middlePanel.add ( logDisplay );
  middlePanel.add ( msgDisplay );

  connectButton = new Button ( "Connect" );
  sendButton = new Button ( "Send" );
  cancelButton = new Button ( "Cancel" );
  quitButton = new Button ( "Quit" );
  buttonPanel = new Panel ( );
  buttonPanel.add ( connectButton );
  buttonPanel.add ( sendButton );
  buttonPanel.add ( cancelButton );
  buttonPanel.add ( quitButton );

  outerBox = new MyFrame ( this, "Client_Second" );
  outerBox.add ( "North", topPanel );
  outerBox.add ( "Center", middlePanel );
  outerBox.add ( "South", buttonPanel );

  outerBox.resize ( 350, 400 );
  outerBox.show ();

  }  // end buildUI 

// **************

  public void connectServer (  )  {

  Socket connection;
  InputStream input;
  OutputStream output;
  char c;
  String host;
  int port;

    host = hostDisplay.getText ();
    if ( host.equals ("" ) ) host = DEFAULT_HOST;
    if ( ! ( portDisplay.getText () ).equals ( "" ) ) port = Integer.parseInt ( portDisplay.getText () );
    else port = DEFAULT_PORT;

    try  {

      connection = new Socket ( InetAddress.getByName ( host ), port );
      output = connection.getOutputStream ();
      input = connection.getInputStream ();

      logDisplay.setText ( "Socket created:  connecting to server\n" );
      logDisplay.appendText ( "Message, below, sent to Server \n " );
      String string = new String ( (msgDisplay.getText ()).concat("#") );
      for ( int i = 0; i < string.length(); i++ ) 
        output.write ( (int) string.charAt ( i ) );

      logDisplay.appendText ( "InputStream created\n" );
      logDisplay.appendText ( "Message, below, received from server \n" );
      msgDisplay.setText ( "" );
      msgDisplay.setForeground ( Color.red );
      while ( (c = (char) input.read () ) != '#' ) 
         msgDisplay.appendText ( String.valueOf ( c ) ); 
      logDisplay.appendText ( "Message length = " + string.length () + "\n" );
      connection.close ();
      logDisplay.appendText ( "Connection closed\n" );
    }  // end try

    catch ( IOException except)  {
      except.printStackTrace ();
    }  // end catch

  }  // end connectServer 

// **************

  public boolean action (Event event, Object arg) {

    if (event.target == connectButton )  {
       this.connectServer ();
      return true;
    }  // end connectButton 

    if (event.target == sendButton )  {
      return true;
    }  // end sendButton

    if (event.target == cancelButton )  {
      msgDisplay.setText ( "" );
      return true;
    }  // end cancelButton 

    if (event.target == quitButton )  {
      hide ();
      dispose ();
      System.exit ( 0 );
      return true;
    }  // end quitButton 

    return false;

  }  // end action

  public boolean handleEvent ( Event event )  {

    if ( event.id == Event.WINDOW_ICONIFY )  {
      hide ();
      dispose ();
      System.exit ( 0 );
    }  // end if

    return super.handleEvent ( event );

  }  // end handleEvent 

// **************

  public static void main ( String [ ] args )  {

    Client_Second client = new Client_Second ();
    client.buildUI ();
//    client.connectServer ();

  }  // end main

  
  
  class MyFrame extends Frame  {
  Frame source;

  MyFrame ( Frame a )  {
    super ( );
    source = a;
  }  // end constructor

  MyFrame ( Frame a, String title )  {
    super ( title );
    source = a;
  }  // end constructor

  public boolean action ( Event event, Object object )  {
    if ( source.action ( event, object ) ) return true;
    else return false;
  }  // end action

  public boolean handleEvent ( Event event )  {
    if ( source.handleEvent ( event ) ) return true;
    else return super.handleEvent ( event );
  }  // end handleEvent

}  // end MyFrame
 
  
  
  
  
  
  
  
  
}  // end Client_Second 

// http://www.cs.unc.edu/~jbs/resources/java/java_client_server1/
//http://www2.sys-con.com/itsg/virtualcd/java/archives/0501/dodson/index.html




package clientserver;

    import java.net.*;
    import java.io.*;
    import java.util.*;
    import java.awt.*;
    import java.applet.*;

    public class Client_Applet extends Applet  {

    //*****  Applet-based, single-thread client, with UI
    //            expects to find server on gamma.cs.unc.edu:8888

    MyAppletFrame outerBox;

    TextField hostDisplay, portDisplay;
    TextArea logDisplay, msgDisplay;
    Panel topPanel;
    Panel middlePanel;
    Panel buttonPanel;
    Button connectButton, sendButton, cancelButton, quitButton;

    public static final String DEFAULT_HOST = "gamma.cs.unc.edu";
    public static final int DEFAULT_PORT = 8888;

      public Client_Applet ()  {
        super (  );
      }  // end Client_Applet constructor

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

      outerBox = new MyAppletFrame ( this, "Client_Applet" );
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
    System.out.println (host);
        if ( ! ( portDisplay.getText () ).equals ( "" ) ) port = Integer.parseInt ( portDisplay.getText () );
        else port = DEFAULT_PORT;
    System.out.println (port);
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
          stop ();
          destroy ();
    //      System.exit ( 0 );
          return true;
        }  // end quitButton 

        return false;

      }  // end action

      public boolean handleEvent ( Event event )  {

        if ( event.id == Event.WINDOW_ICONIFY )  {
          hide ();
          stop ();
          destroy ();
    //      System.exit ( 0 );
        }  // end if

        return super.handleEvent ( event );

      }  // end handleEvent 

    // **************

      public void init (  )  {

        Client_Applet client = new Client_Applet ();
        client.buildUI ();
    //    client.connectServer ();

      }  // end init 

      class MyAppletFrame extends Frame  {
      Applet source;

      MyAppletFrame ( Applet a )  {
        super ( );
        source = a;
      }  // end constructor

      MyAppletFrame ( Applet a, String title )  {
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

    }  // end MyAppletFrame 

    
      
    }  // end Client_Applet 

    // ********************  MyAppletFrame Class ********************

    

